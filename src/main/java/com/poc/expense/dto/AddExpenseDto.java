package com.poc.expense.dto;

import com.poc.expense.entity.Expense;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AddExpenseDto {
    List<Expense> expenses;
}
