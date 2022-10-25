package com.cydeo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "customers")
@Data
@NoArgsConstructor
public class Customer extends BaseEntity {

    private String address;
    private String email;
    @Column(name = "firstName")
    private String name;
    @Column(name = "lastName")
    private String surName;
    private String userName;

    public Customer(String address, String email, String name, String surName, String userName) {
        this.address = address;
        this.email = email;
        this.name = name;
        this.surName = surName;
        this.userName = userName;
    }
}
