package com.inventorycheck.bean;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class RegistrationRequest {

    private final String branch;

    private final String mobileNo;

    private final String password;
}
