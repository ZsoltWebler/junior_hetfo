package org.webler.zsolt.budgettracker.service;

import org.springframework.stereotype.Service;
import org.webler.zsolt.budgettracker.model.Budget;
import org.webler.zsolt.budgettracker.model.Category;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class BudgetService {

    private final List<Budget> budgetList = new ArrayList<>(
            List.of(
                    new Budget(1L, BigDecimal.valueOf(10000), 12, 2024, new Category()),
                    new Budget(2L, BigDecimal.valueOf(20000), 11, 2024, new Category()),
                    new Budget(3L, BigDecimal.valueOf(50000), 10, 2023, new Category())
            ));

    public List<Budget> getAllBudgets() {
        return budgetList;
    }

    public Budget getBudgetById(Long id) {
        return budgetList.stream().filter(budget -> budget.getId() == id).findFirst().orElseThrow();
    }

    public Budget save(Budget budget) {
        budgetList.add(budget);
        return budget;
    }

    public void deleteBudgets() {
        budgetList.clear();
    }

    public void deleteBudgetById(Long id) {
        budgetList.remove(getBudgetById(id));
    }

    public Budget updateBudgetById(Long id, Budget budget) {
        Budget budgetById = getBudgetById(id);
        budgetById.setAmount(budget.getAmount());
        budgetById.setYear(budget.getYear());
        budgetById.setMonth(budget.getMonth());
        budgetById.setCategory(budget.getCategory());

        return budgetById;
    }
}
