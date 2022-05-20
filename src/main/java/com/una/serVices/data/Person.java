package com.una.serVices.data;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Person")
public class Person {

    @Id
    @Column(name = "id_number")
    @Getter
    @Setter
    private long id_number;

    @Column(name = "full_name")
    @Getter
    @Setter
    private String full_name;

    @Column(name = "email")
    @Getter
    @Setter
    private String email;

    @Column(name = "cell_phone")
    @Getter
    @Setter
    private int cell_phone;

    @Column(name = "province")
    @Getter
    @Setter
    private String province;

    @Column(name = "address")
    @Getter
    @Setter
    private String address;

    @Column(name = "birth_date", columnDefinition = "DATE")
    @Getter
    @Setter
    private Date birth_date;

    @OneToOne(mappedBy = "person")
    private User user;

}
