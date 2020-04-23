package com.poc.expense.projection;

import org.springframework.beans.factory.annotation.Value;


public interface ExpenseProjection {

    @Value("#{target.monthAndYear}")
    String getMonthAndYear();

    @Value("#{target.amount}")
    Double getAmount();
}
