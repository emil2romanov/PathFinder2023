package bf.softuni.pathfinder.service;

import bf.softuni.pathfinder.model.dto.binding.UserLoginBindingModel;
import bf.softuni.pathfinder.model.dto.binding.UserRegisterBindingModel;

public interface AuthenticationService {

    void register(UserRegisterBindingModel userRegisterBindingModel);

    void login(UserLoginBindingModel userLoginBindingModel);

    void logout();
}
