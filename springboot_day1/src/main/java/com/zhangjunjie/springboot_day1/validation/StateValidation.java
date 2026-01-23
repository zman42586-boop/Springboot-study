package com.zhangjunjie.springboot_day1.validation;

import com.zhangjunjie.springboot_day1.anno.State;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class StateValidation implements ConstraintValidator<State,String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if(value.equals("已发布") || value.equals("草稿")){
            return true;
        }
        return false;
    }
}
