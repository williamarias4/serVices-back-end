package com.una.serVices.data;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "Person")
public class Person {

    @Id
    @Column(name = "id_number")
    private long id_number;

    @Column(name = "full_name")
    private String full_name;

    @Column(name = "email")
    private String email;

    @Column(name = "cell_phone")
    private int cell_phone;

    @Column(name = "province")
    private String province;

    @Column(name = "address")
    private String address;

    @Column(name = "birth_date", columnDefinition = "DATE")
    private Date birth_date;

    @OneToOne(mappedBy = "person")
    private User user;

}
