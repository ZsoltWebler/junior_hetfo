package org.webler.zsolt.budgettracker.model;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@Entity
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id"
)
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;
    private String description;


    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Expense> expenses;
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Budget> budgets;



    public Category(){
        this.expenses = new ArrayList<>();
        this.budgets = new ArrayList<>();
    }

    public Category(long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.expenses = new ArrayList<>();
        this.budgets = new ArrayList<>();
    }

    public Category(String name, String description) {
        this(0L, name, description);
    }


    public boolean addExpense(Expense expense){

        return expenses.add(expense);
    }

    public boolean addBudget(Budget budget){
        return budgets.add(budget);
    }

}
