package com.poc.expense.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ExpenseSummeryDto {
    private String monthAndYear;
    private Double expenses;
    private Double totalExpense;
}
