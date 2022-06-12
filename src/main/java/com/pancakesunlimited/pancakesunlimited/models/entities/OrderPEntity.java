package com.pancakesunlimited.pancakesunlimited.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.sql.Time;
import java.util.List;
import java.util.Objects;

@Data
@Entity
@Table(name = "order_p")
public class OrderPEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "description")
    private String description;
    @Basic
    @Column(name = "time")
    private String time;
    @OneToMany(mappedBy = "orderPByOrderId")
    @JsonIgnore
    private List<PancakeEntity> pancakesBy;

}
