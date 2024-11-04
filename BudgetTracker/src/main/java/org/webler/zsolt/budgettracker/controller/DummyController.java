package org.webler.zsolt.budgettracker.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.webler.zsolt.budgettracker.model.Budget;
import org.webler.zsolt.budgettracker.model.Category;
import org.webler.zsolt.budgettracker.model.Expense;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@RestController
public class DummyController {


    @GetMapping("/expensessss")
    public List<Expense> testExpenses() {
        return List.of(
                new Expense(
                        1L,
                        "Lakbér",
                        BigDecimal.valueOf(100000),
                        LocalDate.now(),
                        new Category(
                                1L,
                                "Rezsi",
                                "",
                                Collections.emptyList(),
                                Collections.emptyList()
                        )
                )
        );
    }

    @GetMapping("/category")
    public List<Category> testCategory() {
        return List.of(
                new Category(
                        1L,
                        "Rezsi",
                        "",
                        List.of(

                                new Expense(
                                        1L,
                                        "Lakbér",
                                        BigDecimal.valueOf(100000),
                                        LocalDate.now(),
                                        null)),
                        Collections.emptyList())

        );
    }

    @GetMapping("/budget")
    public List<Budget> testBudget() {
        return List.of(
                new Budget(
                        BigDecimal.TEN,
                        10,
                        2024,
                        new Category(
                                1L,
                                "Rezsi",
                                "",
                                List.of(
                                        new Expense(
                                                1L,
                                                "Lakbér",
                                                BigDecimal.valueOf(100000),
                                                LocalDate.now(),
                                                null)),
                                Collections.emptyList())
                )

        );
    }

}
