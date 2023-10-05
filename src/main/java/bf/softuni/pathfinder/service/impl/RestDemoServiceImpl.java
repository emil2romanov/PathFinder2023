package bf.softuni.pathfinder.service.impl;

import bf.softuni.pathfinder.model.User;
import bf.softuni.pathfinder.repository.UserRepository;
import bf.softuni.pathfinder.service.RestDemoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestDemoServiceImpl implements RestDemoService {

    private final UserRepository userRepository;

    public RestDemoServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }
}
