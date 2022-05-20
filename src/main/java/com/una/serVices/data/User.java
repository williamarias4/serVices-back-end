package com.una.serVices.data;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.una.serVices.config.JsonReferenceConfig;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {

    //<editor-fold defaultstate="collapsed" desc="Variable Def">
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @Getter
    @Setter
    private long id;

    @Column(name = "user_name", unique = true)
    @Getter
    @Setter
    private String user_name;

    @Column(name = "password")
    @Getter
    @Setter
    private String password;

    @Column(name = "reset_password_token")
    @Getter
    @Setter
    private String reset_password_token;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id", referencedColumnName = "id_number")
    @JsonBackReference(value = JsonReferenceConfig.USER_PERSON)
    @Getter
    @Setter
    private Person person;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    @JsonBackReference(value = JsonReferenceConfig.USER_ROLE)
    @Getter
    @Setter
    private Role role;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "business_profile_id", referencedColumnName = "id")
    @JsonBackReference(value = JsonReferenceConfig.USER_BUSINESS_PROFILE)
    @Getter
    @Setter
    private BusinessProfile business_profile;
    //</editor-fold>

    @OneToOne(mappedBy = "user")
    private UserRecord record;

    @OneToOne(mappedBy = "publisher")
    private JobHiredRecord job_hired_record_publisher;

    @OneToOne(mappedBy = "customer")
    private JobHiredRecord job_hired_record_customer;

    @OneToMany(mappedBy = "publisher", fetch = FetchType.EAGER)
    @JsonBackReference(value = JsonReferenceConfig.USER_JOBS_PUBLISHED)
    @Getter
    @Setter
    private Set<Job> jobs_published;


}
