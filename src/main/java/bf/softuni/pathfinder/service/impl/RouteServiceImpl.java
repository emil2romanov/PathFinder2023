package bf.softuni.pathfinder.service.impl;

import bf.softuni.pathfinder.model.dto.AddRouteBindingModel;
import bf.softuni.pathfinder.model.entity.Category;
import bf.softuni.pathfinder.model.entity.Route;
import bf.softuni.pathfinder.repository.CategoryRepository;
import bf.softuni.pathfinder.repository.RouteRepository;
import bf.softuni.pathfinder.service.RouteService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class RouteServiceImpl implements RouteService {

    private final RouteRepository routeRepository;
    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    public RouteServiceImpl(RouteRepository routeRepository, CategoryRepository categoryRepository, ModelMapper modelMapper) {
        this.routeRepository = routeRepository;
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void add(AddRouteBindingModel addRouteBindingModel) {
        Route route = modelMapper.map(addRouteBindingModel, Route.class);
        route.getCategories().clear();

        Set<Category> categories = categoryRepository.findByNameIn(addRouteBindingModel.getCategories());
        route.addCategories(categories);

        routeRepository.save(route);
    }
}
