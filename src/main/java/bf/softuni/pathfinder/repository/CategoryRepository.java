package bf.softuni.pathfinder.repository;

import bf.softuni.pathfinder.model.entity.Category;
import bf.softuni.pathfinder.model.enums.CategoryNames;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;


@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Set<Category> getAllByNameIn (Set<CategoryNames> categories);
}
