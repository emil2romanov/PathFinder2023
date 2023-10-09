package bf.softuni.pathfinder.service;

import bf.softuni.pathfinder.model.dto.UserLoginBindingModel;
import bf.softuni.pathfinder.model.dto.UserRegisterBindingModel;

public interface AuthenticationService {

    void register(UserRegisterBindingModel userRegisterBindingModel);

    boolean login(UserLoginBindingModel userLoginBindingModel);

    void logout();
}
