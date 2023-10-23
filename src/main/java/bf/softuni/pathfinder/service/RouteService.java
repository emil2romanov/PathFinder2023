package bf.softuni.pathfinder.service;

import bf.softuni.pathfinder.model.dto.binding.AddRouteBindingModel;
import bf.softuni.pathfinder.model.dto.view.RouteDetailsViewModel;
import bf.softuni.pathfinder.model.dto.view.RouteViewModel;

import java.util.List;

public interface RouteService {

    void add(AddRouteBindingModel addRouteBindingModel);

    List<RouteViewModel> getAll();

    RouteDetailsViewModel getDetails(Long id);
}
