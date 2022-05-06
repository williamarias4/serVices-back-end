package com.una.serVices.data;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "work_experience")
public class WorkExperience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "title")
    @Getter
    @Setter
    private String title;

    @Column(name = "company_name")
    @Getter
    @Setter
    private String company_name;

    @Column(name = "start_date", columnDefinition = "DATE")
    @Getter
    @Setter
    private Date start_date;

    @Column(name = "end_date", columnDefinition = "DATE")
    @Getter
    @Setter
    private Date end_date;

    @Column(name = "description")
    @Getter
    @Setter
    private String description;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "business_profile_id", referencedColumnName = "id")
    @Getter
    @Setter
    private BusinessProfile business_profile;

}
