package com.una.serVices.data;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "jobs_hired_record")
public class JobHiredRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "job_id", referencedColumnName = "id")
    @Getter
    @Setter
    private Job job;

    @Column(name = "hire_date", columnDefinition = "DATE")
    private Date hire_date;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "publisher_id", referencedColumnName = "id")
    @Getter
    @Setter
    private User publisher;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    @Getter
    @Setter
    private User customer;

    @ManyToOne
    @JoinColumn(name = "user_record_id")
    private UserRecord user_record;
}
