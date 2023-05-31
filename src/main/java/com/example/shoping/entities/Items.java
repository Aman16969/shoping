package com.example.shoping.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Items {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer itemId;
    private String name;
    private String description;
    private Integer stockQuantity;
    private String anyExtraField;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user",nullable = false,referencedColumnName = "userId")
    private User user;
}
