package com.una.serVices.data;


import com.fasterxml.jackson.annotation.JsonBackReference;
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
    private Set<WorkExperience> experience;

    @ManyToMany(mappedBy = "business_profiles", fetch = FetchType.EAGER)
    @JsonBackReference
    @Getter
    @Setter
    private Set<Job> jobs;

    @OneToOne(mappedBy = "business_profile", cascade = CascadeType.ALL)
    @Getter
    @Setter
    private User user;


}
