package org.webler.zsolt.budgettracker.service;

import org.springframework.stereotype.Service;
import org.webler.zsolt.budgettracker.model.Category;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {

    private final List<Category> categoryList = new ArrayList<>(
            List.of(
                    new Category(1L, "Food", "You are what you eat!"),
                    new Category(2L, "Commute", "Petrol prices are skyrocketed!")
            )
    );


    public List<Category> getAllCategories() {
        return categoryList;
    }

    public Category getCategoryById(Long id) {
        return categoryList.stream().filter(category -> category.getId() == id).findFirst().orElseThrow();
    }

    public Category save(Category category) {
        categoryList.add(category);
        return category;
    }

    public void deleteCategories() {
        categoryList.clear();
    }

    public void deleteCategoryById(Long id) {
        Category categoryById = getCategoryById(id);
        categoryList.remove(categoryById);
    }

    public Category updateCategoryById(Long id, Category category) {
        Category categoryById = getCategoryById(id);

        categoryById.setName(category.getName());
        categoryById.setDescription(category.getDescription());
        categoryById.setExpenses(category.getExpenses());
        categoryById.setBudgets(category.getBudgets());

        return categoryById;
    }
}
