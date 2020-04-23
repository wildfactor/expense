package com.poc.expense.util;

import com.poc.expense.dto.AddExpenseDto;
import com.poc.expense.entity.Expense;

public class ExpenseMapper {


    public static Expense toEntity(AddExpenseDto addExpenseDto) {
        Expense expense = new Expense();
        return expense;
    }
}
