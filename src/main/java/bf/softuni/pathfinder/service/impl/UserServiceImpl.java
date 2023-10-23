package bf.softuni.pathfinder.service.impl;

import bf.softuni.pathfinder.exceptions.UserNotFoundException;
import bf.softuni.pathfinder.model.dto.view.UserProfileViewModel;
import bf.softuni.pathfinder.model.entity.User;
import bf.softuni.pathfinder.repository.UserRepository;
import bf.softuni.pathfinder.service.UserService;
import bf.softuni.pathfinder.service.session.LoggedUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final LoggedUser loggedUser;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository,
                           LoggedUser loggedUser,
                           ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.loggedUser = loggedUser;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean isUniqueUsername(String username) {
        return this.userRepository.findByUsername(username).isEmpty();
    }

    @Override
    public boolean isUniqueEmail(String email) {
        return this.userRepository.findByEmail(email).isEmpty();
    }

    @Override
    public UserProfileViewModel getUserProfile() {
        String username = loggedUser.getUsername();
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException("User with username: " + username + " was not found!"));

        return modelMapper.map(user, UserProfileViewModel.class);
    }
}