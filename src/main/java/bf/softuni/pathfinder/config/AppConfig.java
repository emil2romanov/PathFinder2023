package bf.softuni.pathfinder.config;

import bf.softuni.pathfinder.exceptions.LoginCredentialsException;
import bf.softuni.pathfinder.model.dto.binding.AddRouteBindingModel;
import bf.softuni.pathfinder.model.dto.binding.UserRegisterBindingModel;
import bf.softuni.pathfinder.model.entity.Category;
import bf.softuni.pathfinder.model.entity.Route;
import bf.softuni.pathfinder.model.entity.User;
import bf.softuni.pathfinder.model.enums.CategoryNames;
import bf.softuni.pathfinder.model.enums.Level;
import bf.softuni.pathfinder.repository.UserRepository;
import bf.softuni.pathfinder.service.CategoryService;
import bf.softuni.pathfinder.service.RoleService;
import bf.softuni.pathfinder.service.session.LoggedUser;
import bf.softuni.pathfinder.util.YoutubeUtil;
import org.modelmapper.Conditions;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.Provider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;

@Configuration
public class AppConfig {

    private final LoggedUser loggedUser;
    private final UserRepository userRepository;
    private final CategoryService categoryService;
    private final RoleService roleService;

    public AppConfig(LoggedUser loggedUser,
                     UserRepository userRepository,
                     CategoryService categoryService,
                     RoleService roleService) {

        this.loggedUser = loggedUser;
        this.userRepository = userRepository;
        this.categoryService = categoryService;
        this.roleService = roleService;
    }

    @Bean
    public ModelMapper modelMapper() {

        final ModelMapper modelMapper = new ModelMapper();

        //AddRouteBindingModel -> Route
        Provider<User> loggedUserProvider = req -> getLoggedUser();
        Provider<String> youtubeSubUrlProvider = req -> YoutubeUtil.getUrl((String) req.getSource());

        Converter<Set<CategoryNames>, Set<Category>> toEntitySet
                = ctx -> (ctx.getSource() == null)
                ? null
                : categoryService.getAllByNameIn(ctx.getSource());

        modelMapper
                .createTypeMap(AddRouteBindingModel.class, Route.class)
                .addMappings(mapper -> mapper
                        .using(toEntitySet)
                        .map(AddRouteBindingModel::getCategories, Route::setCategories))
                .addMappings(mapper -> mapper
                        .when(Conditions.isNull())
                        .with(loggedUserProvider)
                        .map(AddRouteBindingModel::getAuthor, Route::setAuthor))
                .addMappings(mapper -> mapper
                        .with(youtubeSubUrlProvider)
                        .map(AddRouteBindingModel::getVideoUrl, Route::setVideoUrl));

        //UserRegisterBindingModel -> User
        Provider<User> newUserProvider = req -> new User()
                .setRoles(Set.of(roleService.getRoleByName("USER")))
                .setLevel(Level.BEGINNER);

        Converter<String, String> passwordConverter
                = ctx -> (ctx.getSource() == null)
                ? null
                : passwordEncoder().encode(ctx.getSource());

        modelMapper
                .createTypeMap(UserRegisterBindingModel.class, User.class)
                .setProvider(newUserProvider)
                .addMappings(mapper -> mapper
                        .using(passwordConverter)
                        .map(UserRegisterBindingModel::getPassword, User::setPassword));

        // TODO check why mapping is not working!!!
//        modelMapper
//                .createTypeMap(Route.class, RouteDetailsViewModel.class)
//                .addMappings(mapper -> mapper
//                        .map(route -> route.getAuthor().getUsername(), RouteDetailsViewModel::setAuthorName));

        return modelMapper;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    private User getLoggedUser() {
        final String username = loggedUser.getUsername();
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new LoginCredentialsException("User with username: " + username + " is not present"));
    }
}
