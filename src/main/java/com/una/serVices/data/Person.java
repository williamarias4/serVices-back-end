package com.una.serVices.data;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "full_name")
    @Getter
    @Setter
    private String full_name;

    @Column(name = "email")
    @Getter
    @Setter
    private String email;

    @Column(name = "celphone")
    @Getter
    @Setter
    private String celphone;

    @OneToOne(mappedBy = "person")
    private User user;


}
