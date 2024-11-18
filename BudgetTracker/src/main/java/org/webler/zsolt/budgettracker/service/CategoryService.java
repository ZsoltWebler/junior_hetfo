package org.webler.zsolt.budgettracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webler.zsolt.budgettracker.model.Category;
import org.webler.zsolt.budgettracker.repository.CategoryRepository;

import java.util.List;

@Service
public class CategoryService {

    private  CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id).orElseThrow();
    }

    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    public void deleteCategories() {
        categoryRepository.deleteAll();
    }

    public void deleteCategoryById(Long id) {
        categoryRepository.deleteById(id);
    }

    public Category updateCategoryById(Long id, Category category) {
        Category categoryById = categoryRepository.findById(id).orElseThrow();

        categoryById.setName(category.getName());
        categoryById.setDescription(category.getDescription());
        categoryById.setExpenses(category.getExpenses());
        categoryById.setBudgets(category.getBudgets());

        return categoryRepository.save(categoryById);
    }
}
