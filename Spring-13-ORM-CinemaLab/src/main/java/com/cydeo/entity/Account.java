package com.cydeo.entity;

import com.cydeo.enums.UserRole;

import javax.persistence.*;

@Entity
@Table(name = "accountDetails")
public class Account extends BaseEntity {

    private String name;
    private String address;
    private String country;
    private String city;
    private String state;
    private Integer age;
    private String postalCode;
    @Enumerated(EnumType.STRING)
    private UserRole role = UserRole.USER;

    @OneToOne(mappedBy = "account")
    private User user;
}
