package org.webler.zsolt.budgettracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webler.zsolt.budgettracker.model.Budget;
import org.webler.zsolt.budgettracker.repository.BudgetRepository;

import java.util.List;

@Service
public class BudgetService {

   private BudgetRepository budgetRepository;

   @Autowired
    public BudgetService(BudgetRepository budgetRepository) {
        this.budgetRepository = budgetRepository;
    }

    public List<Budget> getAllBudgets() {

       return budgetRepository.findAll();
    }

    public Budget getBudgetById(Long id) {
        return budgetRepository.findById(id).orElseThrow();
    }

    public Budget save(Budget budget) {
        return budgetRepository.save(budget);
    }

    public void deleteBudgets() {
        budgetRepository.deleteAll();
    }

    public void deleteBudgetById(Long id) {
        budgetRepository.deleteById(id);
    }

    public Budget updateBudgetById(Long id, Budget budget) {

        Budget budgetById = budgetRepository.findById(id).orElseThrow();

        budgetById.setAmount(budget.getAmount());
        budgetById.setYear(budget.getYear());
        budgetById.setMonth(budget.getMonth());
        budgetById.setCategory(budget.getCategory());

        return budgetRepository.saveAndFlush(budgetById);
    }
}
