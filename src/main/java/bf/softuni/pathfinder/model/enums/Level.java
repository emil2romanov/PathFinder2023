package bf.softuni.pathfinder.model.enums;

import java.util.List;

public enum Level {
    BEGINNER,
    INTERMEDIATE,
    ADVANCED;

    public List<Level> getEnumsAsList() {
        return List.of(Level.BEGINNER, Level.INTERMEDIATE, Level.ADVANCED);
    }
}
