package bf.softuni.pathfinder.web;

import bf.softuni.pathfinder.model.dto.AddRouteBindingModel;
import bf.softuni.pathfinder.model.enums.Level;
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

        ModelAndView modelAndView = new ModelAndView("add-route");

        modelAndView.addObject("levels", Level.getEnumsAsList());

        return modelAndView;
    }

    @PostMapping("/add")
    public ModelAndView addRoute(AddRouteBindingModel addRouteBindingModel) {
        return new ModelAndView("add-route");
    }
}
