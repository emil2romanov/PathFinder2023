package bf.softuni.pathfinder.service.impl;

import bf.softuni.pathfinder.model.entity.Role;
import bf.softuni.pathfinder.model.enums.UserRoles;
import bf.softuni.pathfinder.repository.RoleRepository;
import bf.softuni.pathfinder.service.RoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl (RoleRepository roleRepository) {

        this.roleRepository = roleRepository;
    }

    @Override
    public Role getRoleByName (String name) {

        return this.roleRepository.findByName(UserRoles.valueOf(name));
    }
}
