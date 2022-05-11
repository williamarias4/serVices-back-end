package com.una.serVices.data;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Getter
    @Setter
    private long id;

    public enum Type {
        customer, publisher
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    @Getter
    @Setter
    private Type type;

    @OneToOne(mappedBy = "role")
    private User user;

}
