package org.webler.zsolt.budgettracker.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Budget {

    private BigDecimal amount;

    private int month;
    private int year;

    private Category category;

}
