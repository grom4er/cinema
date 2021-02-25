package drivercinema.util.validate.impl;

import drivercinema.util.validate.annotation.ValidatePassword;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.beans.BeanWrapperImpl;

public class ValidatePasswords
        implements ConstraintValidator<ValidatePassword, Object> {
    private String password;
    private String repeatPassword;

    public void initialize(ValidatePassword constraintAnnotation) {
        this.password = constraintAnnotation.field();
        this.repeatPassword = constraintAnnotation.fieldMatch();
    }

    public boolean isValid(Object user, ConstraintValidatorContext context) {
        Object fieldValue = new BeanWrapperImpl(user).getPropertyValue(password);
        Object fieldMatchValue = new BeanWrapperImpl(user).getPropertyValue(repeatPassword);
        return password != null && password.equals(repeatPassword);
    }
}
