package com.una.serVices.data;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "role")
public class Role {

    @Id
    @Column(name = "id")
    private long id;

    public enum Type {
        customer, publisher
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private Type type;

    @OneToOne(mappedBy = "role")
    private User user;

}
