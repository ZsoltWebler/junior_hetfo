package org.webler.zsolt.budgettracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.webler.zsolt.budgettracker.model.Budget;
import org.webler.zsolt.budgettracker.model.Expense;

@Repository
public interface BudgetRepository extends JpaRepository<Budget,Long> {
}