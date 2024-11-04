package org.webler.zsolt.budgettracker.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {

    private long Id;
    private String name;
    private String description;
    private List<Expense> expenses;
    private List<Budget> budgets;


    public Category(long id, String name, String description) {
        this.Id = id;
        this.name = name;
        this.description = description;
        this.expenses = new ArrayList<>();
        this.budgets = new ArrayList<>();
    }

    public Category(String name, String description) {
        this(0L, name, description);
    }

}
