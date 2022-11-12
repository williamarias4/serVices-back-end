package com.una.serVices.data;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "work_experience")
public class WorkExperience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "company_name")
    private String company_name;

    @Column(name = "start_date", columnDefinition = "DATE")
    private Date start_date;

    @Column(name = "end_date", columnDefinition = "DATE")
    private Date end_date;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "business_profile_id", referencedColumnName = "id")
    private BusinessProfile business_profile;

}
