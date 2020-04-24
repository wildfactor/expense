package com.poc.expense.service;

import com.poc.expense.dto.AddExpenseDto;
import com.poc.expense.dto.ExpenseSummeryDto;
import com.poc.expense.entity.Expense;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface ExpenseService {
 List<Expense>  getAllExpense();

 List<Expense> saveExpense(AddExpenseDto addExpenseDto);

 void sendASynchronousMail(String toEmail,String subject,String text);

 Optional<Expense> findById(Long id);

 void deleteById(Long id);

 List<Expense> findByUserId(String userId);
}
