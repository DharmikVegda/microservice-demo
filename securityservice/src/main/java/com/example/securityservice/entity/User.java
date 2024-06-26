package com.example.securityservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private long id;

    private String username;

    private String email;

    private String password;

    private boolean active;

    private boolean accountLockedFlag;

    private LocalDate accountLockedDate;

    private Integer unsuccessfulLoginAttempts;

    private Set<Role> roles = new HashSet<>();
}
