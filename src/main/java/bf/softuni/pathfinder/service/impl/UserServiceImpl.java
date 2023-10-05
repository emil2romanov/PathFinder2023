package bf.softuni.pathfinder.service.impl;

import bf.softuni.pathfinder.model.User;
import bf.softuni.pathfinder.model.dto.UserRegisterBindingModel;
import bf.softuni.pathfinder.repository.UserRepository;
import bf.softuni.pathfinder.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void register(UserRegisterBindingModel userRegisterBindingModel) {
        User user = modelMapper.map(userRegisterBindingModel, User.class);

        userRepository.save(user);
    }
}
