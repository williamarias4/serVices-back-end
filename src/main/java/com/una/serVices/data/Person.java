package com.una.serVices.data;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "id_card_number")
    @Getter
    @Setter
    private int id_number;

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
    private String cell_phone;

    @Column(name = "province")
    @Getter
    @Setter
    private String province;

    @Column(name = "location")
    @Getter
    @Setter
    private String exact_location;

    @Column(name = "birth_date", columnDefinition = "DATE")
    @Getter
    @Setter
    private Date birth_date;

    @OneToOne(mappedBy = "person")
    private User user;

}
