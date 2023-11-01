package bf.softuni.pathfinder.model.entity;

import bf.softuni.pathfinder.model.enums.Level;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "routes")
public class Route extends BaseEntity{

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "gpx_coordinates", columnDefinition = "LONGTEXT")
    private String gpxCoordinates;

    @Enumerated(EnumType.STRING)
    @Column(name = "level")
    private Level level;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne
    private User author;

    @Column(name = "video_url")
    private String videoUrl;


    @Column(name = "image_url")
    private String imageUrl;

    @OneToMany(mappedBy = "route")
    private List<Comment> comments;

    @ManyToMany
    private Set<Category> categories;

    public Route() {
        this.categories = new HashSet<>();
    }

    public String getDescription () {
        return description;
    }

    public Route setDescription (String description) {
        this.description = description;
        return this;
    }

    public String getGpxCoordinates () {
        return gpxCoordinates;
    }

    public Route setGpxCoordinates (String gpxCoordinates) {
        this.gpxCoordinates = gpxCoordinates;
        return this;
    }

    public Level getLevel () {
        return level;
    }

    public Route setLevel (Level level) {
        this.level = level;
        return this;
    }

    public String getName () {
        return name;
    }

    public Route setName (String name) {
        this.name = name;
        return this;
    }

    public User getAuthor () {
        return author;
    }

    public Route setAuthor (User author) {
        this.author = author;
        return this;
    }

    public String getVideoUrl () {
        return videoUrl;
    }

    public Route setVideoUrl (String videoUrl) {
        this.videoUrl = videoUrl;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Route setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public Set<Category> getCategories () {
        return categories;
    }

    public Route setCategories (Set<Category> categories) {
        this.categories = categories;
        return this;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public Route setComments(List<Comment> comments) {
        this.comments = comments;
        return this;
    }

    public void addCategories (Set<Category> categories) {
        this.categories.addAll(categories);
    }
}