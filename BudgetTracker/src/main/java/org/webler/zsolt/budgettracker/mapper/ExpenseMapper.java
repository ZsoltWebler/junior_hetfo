package org.webler.zsolt.budgettracker.mapper;

import org.webler.zsolt.budgettracker.dto.ExpenseDTO;
import org.webler.zsolt.budgettracker.model.Expense;

public class ExpenseMapper implements Mapper<Expense, ExpenseDTO>{


    @Override
    public ExpenseDTO mapTo(Expense from) {
        ExpenseDTO expenseDTO = new ExpenseDTO();

        expenseDTO.setId(from.getId());
        expenseDTO.setDescription(from.getDescription());
        expenseDTO.setDate(from.getDate());
        expenseDTO.setAmount(from.getAmount());

        return expenseDTO;

    }

    @Override
    public Expense mapFrom(ExpenseDTO to) {
        Expense expense = new Expense();

        expense.setId(to.getId());
        expense.setDescription(to.getDescription());
        expense.setDate(to.getDate());
        expense.setAmount(to.getAmount());

        return expense;
    }
}
