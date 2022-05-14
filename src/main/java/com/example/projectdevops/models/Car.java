package com.example.projectdevops.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Car {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    @Id
    private Integer carId;

    @Column(name = "brand_name")
    private String brandName;

    @Column(name = "model_name")
    private String modelName;

    private Double price;
}
