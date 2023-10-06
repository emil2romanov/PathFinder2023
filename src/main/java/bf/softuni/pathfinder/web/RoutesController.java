package bf.softuni.pathfinder.web;

import bf.softuni.pathfinder.model.dto.AddRouteBindingModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/routes")
public class RoutesController {

    @GetMapping("/add")
    public ModelAndView addRoute() {
        return new ModelAndView("add-route");
    }

    @PostMapping("/add")
    public ModelAndView addRoute(AddRouteBindingModel addRouteBindingModel) {
        return new ModelAndView("add-route");
    }
}
