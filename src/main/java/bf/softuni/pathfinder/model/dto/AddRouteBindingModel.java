package bf.softuni.pathfinder.model.dto;

import bf.softuni.pathfinder.model.enums.Level;

public class AddRouteBindingModel {

    private String name;
    private String description;
    //private String gpxCoordinates;
    private Level level;
    private String videoUrl;

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

   /* public String getGpxCoordinates() {
        return gpxCoordinates;
    }

    public AddRouteBindingModel setGpxCoordinates(String gpxCoordinates) {
        this.gpxCoordinates = gpxCoordinates;
        return this;
    }*/

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
}
