package cinema.dto.request;

import javax.validation.constraints.NotNull;
import cinema.model.UserRole;
import cinema.util.validate.annotation.EmailValidator;
import cinema.util.validate.annotation.ValidatePassword;
import java.util.List;

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
    @NotNull
    private List<UserRole> roleList;

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

    public List<UserRole> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<UserRole> roleList) {
        this.roleList = roleList;
    }
}
