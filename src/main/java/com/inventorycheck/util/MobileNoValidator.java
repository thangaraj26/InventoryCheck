package com.inventorycheck.util;

import org.springframework.stereotype.Service;
import org.springframework.util.NumberUtils;

import java.math.BigInteger;
import java.util.function.Predicate;

@Service
public class MobileNoValidator implements Predicate<String> {


    @Override
    public boolean test(String s) {
        if(s.matches("\\d{10}"))
            return true;
        else
            return false;


    }
}