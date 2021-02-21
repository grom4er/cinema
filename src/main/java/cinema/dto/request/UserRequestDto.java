package cinema.dto.request;

import cinema.util.validate.annotation.EmailValidator;
import cinema.util.validate.annotation.ValidatePassword;

@ValidatePassword.List({
        @ValidatePassword(
                field = "password",
                fieldMatch = "repeatPassword",
                message = "Passwords don't same!"
        )
})
public class UserRequestDto {
    @EmailValidator
    private String email;
    private String password;
    private String repeatPassword;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
