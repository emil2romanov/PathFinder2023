package bf.softuni.pathfinder.web;

import bf.softuni.pathfinder.model.entity.User;
import bf.softuni.pathfinder.service.RestDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class RestDemoController {

    private RestDemoService userService;

    @Autowired
    public void setRestDemoService(RestDemoService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public List<User> getAll() {
        return this.userService.getAll();
    }
}
