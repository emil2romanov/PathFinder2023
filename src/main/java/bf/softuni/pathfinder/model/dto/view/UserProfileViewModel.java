package bf.softuni.pathfinder.model.dto.view;

import bf.softuni.pathfinder.model.enums.Level;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class UserProfileViewModel {
    private String fullName;
    private String username;
    private int age;
    private Level level;
}