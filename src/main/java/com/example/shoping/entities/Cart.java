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
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer cartId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user",referencedColumnName = "userId",nullable = false)
    private User user;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "items",referencedColumnName = "itemId",nullable = false)
    private Items items;
    private Integer quantity;
    private boolean isActive=true;
}
