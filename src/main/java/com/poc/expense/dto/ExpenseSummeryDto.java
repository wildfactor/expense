package com.poc.expense.dto;

/**
 * The type Expense summery dto.
 */
public class ExpenseSummeryDto {
    private String monthAndYear;
    private Double expenses;
    private String expenseCategory;
    private String userId;
    private Double totalExpense;

    /**
     * Gets month and year.
     *
     * @return the month and year
     */
    public String getMonthAndYear() {
        return monthAndYear;
    }

    /**
     * Sets month and year.
     *
     * @param monthAndYear the month and year
     */
    public void setMonthAndYear(String monthAndYear) {
        this.monthAndYear = monthAndYear;
    }

    /**
     * Gets expenses.
     *
     * @return the expenses
     */
    public Double getExpenses() {
        return expenses;
    }

    /**
     * Sets expenses.
     *
     * @param expenses the expenses
     */
    public void setExpenses(Double expenses) {
        this.expenses = expenses;
    }

    /**
     * Gets expense category.
     *
     * @return the expense category
     */
    public String getExpenseCategory() {
        return expenseCategory;
    }

    /**
     * Sets expense category.
     *
     * @param expenseCategory the expense category
     */
    public void setExpenseCategory(String expenseCategory) {
        this.expenseCategory = expenseCategory;
    }

    /**
     * Gets user id.
     *
     * @return the user id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Sets user id.
     *
     * @param userId the user id
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * Gets total expense.
     *
     * @return the total expense
     */
    public Double getTotalExpense() {
        return totalExpense;
    }

    /**
     * Sets total expense.
     *
     * @param totalExpense the total expense
     */
    public void setTotalExpense(Double totalExpense) {
        this.totalExpense = totalExpense;
    }
}
