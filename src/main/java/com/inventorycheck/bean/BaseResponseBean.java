package com.inventorycheck.bean;

import lombok.Data;

@Data
public class BaseResponseBean {
    boolean result=false;
    Object data;
    String message;
}