package bf.softuni.pathfinder.model.dto;

public record UserRegisterBindingModel(String username,
                                       String fullName,
                                       String email,
                                       int age,
                                       String password,
                                       String confirmPassword) {
}
