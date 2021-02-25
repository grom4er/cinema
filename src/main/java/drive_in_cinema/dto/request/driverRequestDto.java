package drive_in_cinema.dto.request;

import drive_in_cinema.util.validate.annotation.PhoneNumberValidation;
import drive_in_cinema.util.validate.annotation.ValidatePassword;

@ValidatePassword.List({
        @ValidatePassword(
                field = "password",
                fieldMatch = "repeatPassword",
                message = "Passwords don't same!"
        )
})
public class driverRequestDto {
    @PhoneNumberValidation
    private String phoneNumber;
    private String password;
    private String repeatPassword;

    public String phoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }

    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }
}
