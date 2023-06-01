package com.example.shoping.entities;


import java.util.*;

import com.example.shoping.utils.CartItemBody;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer orderId;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "user",referencedColumnName = "userId",nullable = false)
    private User user;
    private Cart[] carts;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="address",referencedColumnName = "addressId",nullable = false)
    private Address address;
    private Integer total;


}
