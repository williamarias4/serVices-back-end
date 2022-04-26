package com.una.serVices.data;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "business_profile")
public class BusinessProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "about")
    @Getter
    @Setter
    private String about;

    @OneToMany(mappedBy = "business_profile", cascade = CascadeType.ALL)
    @Getter
    @Setter
    private Set<JobExperience> experience;

    @OneToMany(mappedBy = "business_profile", cascade = CascadeType.ALL)
    @Getter
    @Setter
    private Set<Service> services;

    @OneToOne(mappedBy = "business_profile", cascade = CascadeType.ALL)
    @Getter
    @Setter
    private User user;


}
