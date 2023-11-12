package bf.softuni.pathfinder.model.dto.binding;

import bf.softuni.pathfinder.model.entity.User;
import bf.softuni.pathfinder.model.enums.CategoryNames;
import bf.softuni.pathfinder.model.enums.Level;
import bf.softuni.pathfinder.validation.annotations.FileAnnotation;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.springframework.web.multipart.MultipartFile;

import java.util.Set;

public class AddRouteBindingModel {

    @Size(min = 3, message = "Name length must be more than 3 characters")
    private String name;

    @Size(min = 5, message = "Description length must be more than 5 characters")
    private String description;

    @FileAnnotation(contentTypes = "text/xml")
    private MultipartFile gpxCoordinates;

    private Level level;

    @Pattern(regexp = "https:\\/\\/www\\.youtube\\.com\\/watch\\?v=.*", message = "Invalid youtube url provided")
    private String videoUrl;

    private User author;

    private Set<CategoryNames> categories;

    public AddRouteBindingModel() {

    }

    public User getAuthor() {
        return author;
    }

    public AddRouteBindingModel setAuthor(User author) {
        this.author = author;
        return this;
    }

    public String getName() {
        return name;
    }

    public AddRouteBindingModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public AddRouteBindingModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public MultipartFile getGpxCoordinates() {
        return gpxCoordinates;
    }

    public AddRouteBindingModel setGpxCoordinates(MultipartFile gpxCoordinates) {
        this.gpxCoordinates = gpxCoordinates;
        return this;
    }

    public Level getLevel() {
        return level;
    }

    public AddRouteBindingModel setLevel(Level level) {
        this.level = level;
        return this;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public AddRouteBindingModel setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
        return this;
    }

    public Set<CategoryNames> getCategories() {
        return categories;
    }

    public AddRouteBindingModel setCategories(Set<CategoryNames> categories) {
        this.categories = categories;
        return this;
    }
}