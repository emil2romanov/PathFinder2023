package bf.softuni.pathfinder.service.impl;

import bf.softuni.pathfinder.model.dto.UserLoginBindingModel;
import bf.softuni.pathfinder.model.entity.User;
import bf.softuni.pathfinder.model.dto.UserRegisterBindingModel;
import bf.softuni.pathfinder.repository.UserRepository;
import bf.softuni.pathfinder.service.UserService;
import bf.softuni.pathfinder.service.session.LoggedUser;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final LoggedUser loggedUser;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder, LoggedUser loggedUser) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
        this.loggedUser = loggedUser;
    }

    @Override
    public void register(UserRegisterBindingModel userRegisterBindingModel) {
        User user = modelMapper.map(userRegisterBindingModel, User.class);
        user.setPassword(passwordEncoder.encode(userRegisterBindingModel.getPassword()));
        userRepository.save(user);
    }

    @Override
    public boolean login(UserLoginBindingModel userLoginBindingModel) {
        String username = userLoginBindingModel.getUsername();
        User user = this.userRepository.findByUsername(username);

        if (user == null) {
            throw new IllegalArgumentException("User with that username: " + username + " is not present");
        }

        boolean passwordMatch = passwordEncoder.matches(userLoginBindingModel.getPassword(), user.getPassword());

        if (!passwordMatch) {
            throw new IllegalArgumentException("User entered incorrect password");
        }

        loggedUser.setUsername(user.getUsername());
        loggedUser.setEmail(user.getEmail());
        loggedUser.setFullName(user.getFullName());

        return passwordMatch;
    }

    @Override
    public void logout() {
        loggedUser.reset();
    }
}
