package com.una.serVices.data;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.una.serVices.config.JsonReferenceConfig;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "business_profile")
public class BusinessProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "about")
    private String about;

    @OneToMany(mappedBy = "business_profile", fetch = FetchType.EAGER)
    private Set<WorkExperience> experience;

    @ManyToMany(mappedBy = "business_profiles", fetch = FetchType.EAGER)
    @JsonBackReference
    private Set<Job> jobs;

    @OneToOne(mappedBy = "business_profile")
    @JsonBackReference(value = JsonReferenceConfig.USER_BUSINESS_PROFILE)
    private User user;


}
