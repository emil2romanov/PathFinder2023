package bf.softuni.pathfinder.model.dto.binding;

import bf.softuni.pathfinder.validation.annotations.PasswordMatch;
import bf.softuni.pathfinder.validation.annotations.UniqueEmail;
import bf.softuni.pathfinder.validation.annotations.UniqueUsername;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@PasswordMatch
public class UserRegisterBindingModel {

    @NotNull
    @UniqueUsername
    @Size(min = 2, message = "{user.username.length}")
    private String username;

    @NotNull
    @Size(min = 2, message = "{user.full-name.length}")
    private String fullName;

    @NotNull
    @UniqueEmail
    @Email(regexp = ".+[@].+", message = "{user.email}")
    private String email;

    @Positive(message = "{user.age}")
    private int age;

    @Size(min = 2, message = "{user.password.length}")
    private String password;

    @Size(min = 2, message = "{user.confirm-password.length}")
    private String confirmPassword;

    public UserRegisterBindingModel () {

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
