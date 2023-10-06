package bf.softuni.pathfinder.service.impl;

import bf.softuni.pathfinder.model.dto.AddRouteBindingModel;
import bf.softuni.pathfinder.model.entity.Route;
import bf.softuni.pathfinder.repository.RouteRepository;
import bf.softuni.pathfinder.service.RouteService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class RouteServiceImpl implements RouteService {

    private final RouteRepository routeRepository;
    private final ModelMapper modelMapper;

    public RouteServiceImpl(RouteRepository routeRepository, ModelMapper modelMapper) {
        this.routeRepository = routeRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void add(AddRouteBindingModel addRouteBindingModel) {
        Route route = modelMapper.map(addRouteBindingModel, Route.class);

        routeRepository.save(route);
    }
}
