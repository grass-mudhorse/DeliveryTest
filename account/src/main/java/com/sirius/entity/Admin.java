package com.sirius.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Admin extends Account{
    private long adminid;
    private String username;
    private String password;
    private String email;
}
