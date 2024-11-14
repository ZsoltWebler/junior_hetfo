package org.webler.zsolt.budgettracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.webler.zsolt.budgettracker.model.Expense;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense,Long> {
}
