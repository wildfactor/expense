package com.poc.expense.util;

import com.poc.expense.dto.AddExpenseDto;
import com.poc.expense.entity.Expense;

/**
 * The type Expense mapper.
 */
public class ExpenseMapper {


    /**
     * To entity expense.
     *
     * @param addExpenseDto the add expense dto
     * @return the expense
     */
    public static Expense toEntity(AddExpenseDto addExpenseDto) {
        Expense expense = new Expense();
        return expense;
    }
}
