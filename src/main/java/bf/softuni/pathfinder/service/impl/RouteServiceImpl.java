package bf.softuni.pathfinder.service.impl;

import bf.softuni.pathfinder.exceptions.RouteNotFoundException;
import bf.softuni.pathfinder.model.dto.binding.AddRouteBindingModel;
import bf.softuni.pathfinder.model.dto.view.RouteDetailsViewModel;
import bf.softuni.pathfinder.model.dto.view.RouteViewModel;
import bf.softuni.pathfinder.model.entity.Route;
import bf.softuni.pathfinder.repository.RouteRepository;
import bf.softuni.pathfinder.service.RouteService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class RouteServiceImpl implements RouteService {
    private final RouteRepository routeRepository;
    private final ModelMapper modelMapper;

    public RouteServiceImpl(RouteRepository routeRepository,
                            ModelMapper modelMapper) {
        this.routeRepository = routeRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<RouteViewModel> getAll() {
        return routeRepository.findAll().stream()
                .map(route -> modelMapper.map(route, RouteViewModel.class))
                .toList();
    }

    @Override
    public void add(AddRouteBindingModel addRouteBindingModel) {

        Route route = modelMapper.map(addRouteBindingModel, Route.class);

        String regex = "v=(.*)";
        Pattern compile = Pattern.compile(regex);

        Matcher matcher = compile.matcher(addRouteBindingModel.getVideoUrl());
        if (matcher.find()) {
            String url = matcher.group(1);
            route.setVideoUrl(url);
        }

        System.out.println();

        routeRepository.save(route);
    }

    @Override
    public RouteDetailsViewModel getDetails(Long id) {
        Route route = routeRepository.findById(id)
                .orElseThrow(() -> new RouteNotFoundException("Route with id: " + id + " was not found!"));

        RouteDetailsViewModel routeDetailsViewModel = modelMapper.map(route, RouteDetailsViewModel.class);
        routeDetailsViewModel.setAuthorName(route.getAuthor().getFullName());

        return routeDetailsViewModel;
    }
}
