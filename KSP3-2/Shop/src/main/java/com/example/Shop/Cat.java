package com.example.Shop;

import javax.persistence.*;

@Entity
@Table(name = "cat")
public class Cat {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     public int id;

     @Column(length = 32)
     public String name;

     @Column
     public int price;
}
