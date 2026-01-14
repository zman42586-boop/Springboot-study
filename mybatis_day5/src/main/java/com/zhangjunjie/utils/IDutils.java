package com.zhangjunjie.utils;

import lombok.ToString;
import org.junit.jupiter.api.Test;


import java.util.UUID;

public class IDutils {
    public static String getID(){
        return UUID.randomUUID().toString().replace("-", "");
    }

    public static void main(String[] args) {
        System.out.println(getID());
    }
}
