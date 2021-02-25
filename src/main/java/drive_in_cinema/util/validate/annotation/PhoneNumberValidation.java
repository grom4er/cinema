package drive_in_cinema.util.validate.annotation;

import drive_in_cinema.util.validate.impl.ValidatePhoneNumber;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = ValidatePhoneNumber.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface PhoneNumberValidation {
    String message() default "Incorrect phone number!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
