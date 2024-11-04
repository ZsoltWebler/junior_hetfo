package org.webler.zsolt.budgettracker.service;

import org.springframework.stereotype.Service;
import org.webler.zsolt.budgettracker.model.Category;
import org.webler.zsolt.budgettracker.model.Expense;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ExpenseService {


    private final Category foodCategory = new Category("Food", "You are what you eat!");
    private final Category commuteCategory = new Category("Commute", "Petrol prices are skyrocketed!");

    private final List<Expense> expenseList = new ArrayList<>(
            List.of(
                    new Expense(1L, "Vacsora", BigDecimal.valueOf(25000), LocalDate.now(), foodCategory),
                    new Expense(2L, "Étel rendelés", BigDecimal.valueOf(18000), LocalDate.now(), foodCategory),
                    new Expense(3L, "Bevásárlás", BigDecimal.valueOf(32000), LocalDate.now(), foodCategory),
                    new Expense(4L, "Bérlet", BigDecimal.valueOf(25000), LocalDate.now(), commuteCategory),
                    new Expense(5L, "Vonaljegy", BigDecimal.valueOf(400), LocalDate.now(), commuteCategory)
            ));


    public List<Expense> getAllExpenses() {
        return expenseList;
    }


    public Expense getExpenseById(Long id) {
        return expenseList.stream().filter(expense -> expense.getId() == id).findFirst().orElseThrow();
    }

    public Expense save(Expense expense) {
        expenseList.add(expense);
        return expense;
    }

    public void deleteExpenses() {
        expenseList.clear();
    }

    public void deleteExpenseById(Long id) {
        Expense expenseById = getExpenseById(id);
        expenseList.remove(expenseById);
    }

    public Expense updateExpenseById(Long id, Expense expense) {

        Expense expenseById = getExpenseById(id);

        expenseById.setAmount(expense.getAmount());
        expenseById.setDate(expense.getDate());
        expenseById.setCategory(expense.getCategory());
        expenseById.setDescription(expense.getDescription());

        return expenseById;

    }


}
