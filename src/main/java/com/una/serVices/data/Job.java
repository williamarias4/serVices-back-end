package com.una.serVices.data;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "job")
public class Job {

    //<editor-fold defaultstate="collapsed" desc="Variable Def">
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "title")
    @Getter
    @Setter
    private String title;

    @Column(name = "description")
    @Getter
    @Setter
    private String description;

    @Column(name = "category")
    @Getter
    @Setter
    private String Category;

    @Column(name = "price", columnDefinition = "decimal", length = 10, precision = 2)
    @Getter
    @Setter
    private BigDecimal price;
    //</editor-fold>

    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinTable(name = "profile_job", joinColumns = {@JoinColumn(name = "job_id")},
            inverseJoinColumns = {@JoinColumn(name = "business_profile_id")})
    @JsonBackReference
    @Getter
    @Setter
    Set<BusinessProfile> business_profiles = new HashSet<>();

    @OneToOne(mappedBy = "job")
    private JobHiredRecord jobs_hired_record;
}
