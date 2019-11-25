package com.crazycode.pojo;

import lombok.Data;

import javax.persistence.Column;

@Data
public class Users {

    private String id;
    private String email;
    private String username;
    private String password;
    @Column(name = "phoneNum")
    private String phoneNum;
    private Long status;


}
