package com.poc.expense.projection;

import org.springframework.beans.factory.annotation.Value;


/**
 * The interface Expense projection.
 */
public interface ExpenseProjection {

    /**
     * Gets month and year.
     *
     * @return the month and year
     */
    @Value("#{target.monthAndYear}")
    String getMonthAndYear();

    /**
     * Gets amount.
     *
     * @return the amount
     */
    @Value("#{target.amount}")
    Double getAmount();

    /**
     * Gets expense category.
     *
     * @return the expense category
     */
    @Value("#{target.expenseCategory}")
    String getExpenseCategory();

    /**
     * Gets user id.
     *
     * @return the user id
     */
    @Value("#{target.userId}")
    String getUserId();
}
