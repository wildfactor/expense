package com.poc.expense.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * The type Expense.
 */
@Entity
public class Expense {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String monthAndYear;

    private Double amount;

    private String expenseCategory;

    private String userId;

    /**
     * Gets id.
     *
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(long id) {
        this.id = id;
    }

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
     * Gets amount.
     *
     * @return the amount
     */
    public Double getAmount() {
        return amount;
    }

    /**
     * Sets amount.
     *
     * @param amount the amount
     */
    public void setAmount(Double amount) {
        this.amount = amount;
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
}
