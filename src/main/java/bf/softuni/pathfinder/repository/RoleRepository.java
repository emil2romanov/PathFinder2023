package bf.softuni.pathfinder.repository;

import bf.softuni.pathfinder.model.entity.Role;
import bf.softuni.pathfinder.model.enums.UserRoles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName (UserRoles role);
}
