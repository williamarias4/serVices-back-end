package com.una.serVices.data;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @Column(name = "id")
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
    @Getter
    @Setter
    private Person person;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    @Getter
    @Setter
    private Role role;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "business_profile_id", referencedColumnName = "id")
    @JsonBackReference
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
    private Set<Job> jobs_published;


}
