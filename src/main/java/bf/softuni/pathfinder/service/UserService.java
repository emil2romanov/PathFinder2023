package bf.softuni.pathfinder.service;

import bf.softuni.pathfinder.model.dto.view.UserProfileViewModel;
import bf.softuni.pathfinder.model.entity.User;

public interface UserService {

    boolean isUniqueUsername(String value);

    boolean isUniqueEmail(String value);

    UserProfileViewModel getUserProfile();
}
