package bf.softuni.pathfinder.service.impl;

import bf.softuni.pathfinder.model.entity.Category;
import bf.softuni.pathfinder.model.enums.CategoryNames;
import bf.softuni.pathfinder.repository.CategoryRepository;
import bf.softuni.pathfinder.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl (CategoryRepository categoryRepository) {

        this.categoryRepository = categoryRepository;
    }

    public Set<Category> getAllByNameIn (Set<CategoryNames> categoryNames) {

        return categoryRepository.getAllByNameIn(categoryNames);
    }
}
