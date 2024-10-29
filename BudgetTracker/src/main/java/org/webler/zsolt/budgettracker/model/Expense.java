package org.webler.zsolt.budgettracker.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Expense {


    private String description;
    private BigDecimal amount;
    private LocalDate date;
    private Category category;

}
