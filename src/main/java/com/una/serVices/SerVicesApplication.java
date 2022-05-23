package com.una.serVices;

import com.una.serVices.config.ComponentConfig;
import com.una.serVices.dao.RoleDao;
import com.una.serVices.data.Role;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.transaction.Transactional;

@Transactional
@EnableScheduling
@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
public class SerVicesApplication {

    @Qualifier(ComponentConfig.DAO.ROLE)
    @Autowired
    private RoleDao dao;

    public static void main(String[] args) {
        SpringApplication.run(SerVicesApplication.class, args);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Scheduled(fixedRate = 43200000L)
    public void initRoles() {
        Role publisher = new Role();
        Role customer = new Role();
        publisher.setId(1);
        publisher.setType(Role.Type.publisher);
        customer.setId(2);
        customer.setType(Role.Type.customer);
        dao.save(publisher);
        dao.save(customer);
    }

}
