package com.una.serVices.data;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "service")
public class Service {

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

    @ManyToOne
    @JoinColumn(name = "business_profile_id")
    private BusinessProfile business_profile;
}
