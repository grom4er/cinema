package drivercinema.util.validate.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidatePhoneNumber
        implements ConstraintValidator
        <drivercinema.util.validate.annotation.PhoneNumberValidation, String> {
    private static final String EMAIL_PATTERN = "^[+]+[/d]*";

    @Override
    public boolean isValid(String phoneNumber,
                           ConstraintValidatorContext constraintValidatorContext) {
        return phoneNumber != null && phoneNumber.matches(EMAIL_PATTERN);
    }
}
