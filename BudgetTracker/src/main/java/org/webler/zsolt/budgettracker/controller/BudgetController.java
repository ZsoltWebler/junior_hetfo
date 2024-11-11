package org.webler.zsolt.budgettracker.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.webler.zsolt.budgettracker.model.Budget;
import org.webler.zsolt.budgettracker.service.BudgetService;

import java.util.List;

@RestController
@RequestMapping("/budgets")
public class BudgetController {

    private BudgetService budgetService;

    @Autowired
    public BudgetController(BudgetService budgetService) {
        this.budgetService = budgetService;
    }

    @GetMapping
    public List<Budget> getAllBudgets() {
        return budgetService.getAllBudgets();
    }

    @GetMapping("/{id}")
    public Budget getBudgetById(@PathVariable Long id) {
        return budgetService.getBudgetById(id);
    }

    @PostMapping
    public Budget save(@RequestBody Budget budget) {
        return budgetService.save(budget);
    }

    @DeleteMapping
    public void deleteBudgets() {
        budgetService.deleteBudgets();
    }

    @DeleteMapping("/{id}")
    public void deleteBudgetsById(@PathVariable Long id) {
        budgetService.deleteBudgetById(id);
    }

    @PatchMapping("/{id}")
    public Budget updateBudgetsById(@PathVariable Long id, @RequestBody Budget budget) {
        return budgetService.updateBudgetById(id, budget);
    }


}
