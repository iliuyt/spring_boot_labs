package com.example.lab7_bean.an;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AppLockValidator implements ConstraintValidator<AppLock, Object> {

    @Override
    public void initialize(AppLock constraintAnnotation) {

    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {

        return true;
    }

    private boolean isZero(Integer integer) {
        return integer == null || integer == 0;
    }
}
