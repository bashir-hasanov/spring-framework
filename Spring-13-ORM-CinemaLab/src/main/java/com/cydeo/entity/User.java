package com.cydeo.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "userAccount")
@Data
@NoArgsConstructor
public class User extends BaseEntity {

    private String email;
    private String username;
    private String password;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "accountDetailsId")
    private Account account;
}
