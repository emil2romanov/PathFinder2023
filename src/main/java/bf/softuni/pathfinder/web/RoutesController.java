package bf.softuni.pathfinder.web;

import bf.softuni.pathfinder.model.dto.AddRouteBindingModel;
import bf.softuni.pathfinder.model.enums.CategoryNames;
import bf.softuni.pathfinder.model.enums.Level;
import bf.softuni.pathfinder.service.RouteService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/routes")
public class RoutesController {

    private final RouteService routeService;

    public RoutesController(RouteService routeService) {
        this.routeService = routeService;
    }

    @GetMapping("/add")
    public ModelAndView addRoute() {

        ModelAndView modelAndView = new ModelAndView("add-route");

        modelAndView.addObject("levels", Level.values());
        modelAndView.addObject("categories", CategoryNames.values());

        return modelAndView;
    }

    @PostMapping("/add")
    public ModelAndView addRoute(AddRouteBindingModel addRouteBindingModel) {

        routeService.add(addRouteBindingModel);

        return new ModelAndView("redirect:/");
    }
}
