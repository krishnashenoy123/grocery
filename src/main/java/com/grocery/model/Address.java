package com.grocery.model;

import lombok.*;

import java.sql.Timestamp;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    private int id;
    private int user_id;
    private String street;
    private String city;
    private String state;
    private String pin_code;
    private Timestamp created_d;
}
