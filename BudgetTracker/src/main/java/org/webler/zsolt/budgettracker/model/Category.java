package org.webler.zsolt.budgettracker.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {

    private String name;
    private String description;
    private List<Expense> expenses;
    private List<Budget> budgets;


}
