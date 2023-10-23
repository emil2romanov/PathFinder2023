package bf.softuni.pathfinder.service;

import bf.softuni.pathfinder.model.entity.Category;
import bf.softuni.pathfinder.model.enums.CategoryNames;

import java.util.Set;

public interface CategoryService {

    Set<Category> getAllByNameIn (Set<CategoryNames> categoryNames);

}