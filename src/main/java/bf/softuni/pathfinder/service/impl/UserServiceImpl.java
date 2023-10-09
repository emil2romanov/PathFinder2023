package bf.softuni.pathfinder.service.impl;

import bf.softuni.pathfinder.model.entity.User;
import bf.softuni.pathfinder.repository.UserRepository;
import bf.softuni.pathfinder.service.UserService;
import bf.softuni.pathfinder.service.session.LoggedUser;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final LoggedUser loggedUser;
    private final UserRepository userRepository;

    public UserServiceImpl(LoggedUser loggedUser, UserRepository userRepository) {
        this.loggedUser = loggedUser;
        this.userRepository = userRepository;
    }

    @Override
    public User getLoggedUser() {
        return userRepository.findByUsername(loggedUser.getUsername());
    }
}
