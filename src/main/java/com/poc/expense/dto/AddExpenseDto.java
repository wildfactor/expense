package com.poc.expense.dto;

import com.poc.expense.entity.Expense;

import java.util.List;


/**
 * The type Add expense dto.
 */
public class AddExpenseDto {


    /**
     * The Expenses.
     */
    List<Expense> expenses;

    public AddExpenseDto(List<Expense> expenses) {
        this.expenses = expenses;
    }


    /**
     * Gets expenses.
     *
     * @return the expenses
     */
    public List<Expense> getExpenses() {
        return expenses;
    }

    /**
     * Sets expenses.
     *
     * @param expenses the expenses
     */
    public void setExpenses(List<Expense> expenses) {
        this.expenses = expenses;
    }

    @Override
    public String toString() {
        return "AddExpenseDto{" +
                "expenses=" + expenses +
                '}';
    }
}
