package org.webler.zsolt.budgettracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webler.zsolt.budgettracker.model.Expense;
import org.webler.zsolt.budgettracker.repository.ExpenseRepository;

import java.util.List;

@Service
public class ExpenseService {


    private ExpenseRepository expenseRepository;

    @Autowired
    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }


    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }


    public Expense getExpenseById(Long id) {
        return expenseRepository.findById(id).orElseThrow();
    }

    public Expense save(Expense expense) {
        return expenseRepository.save(expense);
    }

    public void deleteExpenses() {
        expenseRepository.deleteAll();
    }

    public void deleteExpenseById(Long id) {
        expenseRepository.deleteById(id);
    }

    public Expense updateExpenseById(Long id, Expense expense) {

        Expense expenseById = expenseRepository.findById(id).orElseThrow();

        expenseById.setAmount(expense.getAmount());
        expenseById.setDate(expense.getDate());
        expenseById.setCategory(expense.getCategory());
        expenseById.setDescription(expense.getDescription());

        expenseRepository.saveAndFlush(expenseById);
        return expenseById;

    }


}
