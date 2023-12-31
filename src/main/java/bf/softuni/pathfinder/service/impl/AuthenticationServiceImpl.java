package bf.softuni.pathfinder.service.impl;

import bf.softuni.pathfinder.exceptions.LoginCredentialsException;
import bf.softuni.pathfinder.model.dto.binding.UserLoginBindingModel;
import bf.softuni.pathfinder.model.entity.User;
import bf.softuni.pathfinder.model.dto.binding.UserRegisterBindingModel;
import bf.softuni.pathfinder.repository.UserRepository;
import bf.softuni.pathfinder.service.AuthenticationService;
import bf.softuni.pathfinder.service.session.LoggedUser;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;

    private final ModelMapper modelMapper;

    private final PasswordEncoder passwordEncoder;
    private final LoggedUser loggedUser;

    public AuthenticationServiceImpl(UserRepository userRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder, LoggedUser loggedUser) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
        this.loggedUser = loggedUser;
    }

    @Override
    public void register(UserRegisterBindingModel userRegisterBindingModel) {
        User user = modelMapper.map(userRegisterBindingModel, User.class);
        userRepository.save(user);
    }

    @Override
    public void login(UserLoginBindingModel userLoginBindingModel) throws LoginCredentialsException {
        String username = userLoginBindingModel.getUsername();

        User user = this.userRepository
                .findByUsername(username)
                .orElseThrow(() -> new LoginCredentialsException("User with username: [" + username + "] is not present"));

        boolean passwordMatch = passwordEncoder.matches(userLoginBindingModel.getPassword(),
                user.getPassword());

        if (!passwordMatch){
            throw new LoginCredentialsException("User entered incorrect password");
        }

        loggedUser.setUsername(user.getUsername())
                .setLogged(true)
                .setRoles(user.getRoles());
    }

    @Override
    public void logout() {
        loggedUser.reset();
    }
}