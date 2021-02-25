package drive_in_cinema.util.validate.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import drive_in_cinema.util.validate.annotation.PhoneNumberValidation;

public class ValidatePhoneNumber
        implements ConstraintValidator<drive_in_cinema.util.validate.annotation.PhoneNumberValidation, String> {
    private static final String EMAIL_PATTERN = "^[+]+[/d]*";

    @Override
    public boolean isValid(String phoneNumber, ConstraintValidatorContext constraintValidatorContext) {
        return phoneNumber != null && phoneNumber.matches(EMAIL_PATTERN);
    }
}
