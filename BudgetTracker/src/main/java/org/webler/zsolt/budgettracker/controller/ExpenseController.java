package org.webler.zsolt.budgettracker.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.webler.zsolt.budgettracker.model.Expense;
import org.webler.zsolt.budgettracker.service.ExpenseService;

import java.util.List;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {

    private ExpenseService expenseService;

    @Autowired
    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @GetMapping
    public List<Expense> getAllExpenses() {
        return expenseService.getAllExpenses();
    }

    @GetMapping("/{id}")
    public Expense getExpenseById(@PathVariable Long id) {
        return expenseService.getExpenseById(id);
    }

    @PostMapping
    public Expense save(@RequestBody Expense expense) {
        return expenseService.save(expense);
    }

    @DeleteMapping
    public void deleteExpenses() {
        expenseService.deleteExpenses();
    }

    @DeleteMapping("/{id}")
    public void deleteExpensesById(@PathVariable Long id) {
        expenseService.deleteExpenseById(id);
    }

    @PatchMapping("/{id}")
    public Expense updateExpenseById(@PathVariable Long id, @RequestBody Expense expense) {
        return expenseService.updateExpenseById(id, expense);
    }


}
