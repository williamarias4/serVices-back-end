package com.una.serVices.controller;

import com.una.serVices.config.APIRoute;
import com.una.serVices.config.ComponentConfig;
import com.una.serVices.data.Job;
import com.una.serVices.dto.JobDto;
import com.una.serVices.dto.UserDto;
import com.una.serVices.service.IGetAllByService;
import com.una.serVices.service.IService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = APIRoute.API.JOB_V1)
public class JobController implements IController<JobDto, Job>{

    @Autowired
    private ModelMapper modelMapper;

    @Qualifier(ComponentConfig.Service.JOB)
    @Autowired
    private IService service;

    @Qualifier(ComponentConfig.Service.JOB)
    @Autowired
    private IGetAllByService get_service;

    @GetMapping
    public List<JobDto> getAll(@RequestParam(required = false) String userName) {
        List<JobDto> services = (List<JobDto>) service
                .getAll()
                .stream()
                .map(job -> modelMapper.map(job, JobDto.class))
                .collect(Collectors.toList());

        if (userName != null) {
            return services
                    .stream()
                    .filter(job -> job.getPublisher().getUser_name().equals(userName))
                    .collect(Collectors.toList());
        }

        return services;
    }

    @GetMapping(APIRoute.RestAPI.GET_BY_USER_NAME)
    public List<JobDto> getAllByPublisher(@PathVariable String user_name){
        return (List<JobDto>) get_service.getAllBy(user_name).stream().map(job -> modelMapper
                .map(job, JobDto.class)).collect(Collectors.toList());
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public JobDto save(@Valid @RequestBody JobDto jobDto){
        Job job = convertToEntity(jobDto);
        return convertToDto((Job) service.save(job));
    }

    @DeleteMapping("{id}")
    @ResponseBody
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public JobDto update(@RequestBody JobDto jobDTO) {
        Job job = convertToEntity(jobDTO);
        return convertToDto((Job) service.update(job));
    }

    @Override
    public JobDto convertToDto(Job job) {
        return modelMapper.map(job, JobDto.class);
    }

    @Override
    public Job convertToEntity(JobDto jobDto) {
        return modelMapper.map(jobDto, Job.class);
    }
}
