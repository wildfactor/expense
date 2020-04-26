package com.poc.expense.service;

import com.poc.expense.dto.AddExpenseDto;
import com.poc.expense.entity.Expense;

import java.util.List;
import java.util.Optional;

/**
 * The interface Expense service.
 */
public interface ExpenseService {
 /**
  * Gets all expense.
  *
  * @return the all expense
  */
 List<Expense>  getAllExpense();

 /**
  * Save expense list.
  *
  * @param addExpenseDto the add expense dto
  * @return the list
  */
 List<Expense> saveExpense(AddExpenseDto addExpenseDto);

 /**
  * Send a synchronous mail.
  *
  * @param toEmail the to email
  * @param subject the subject
  * @param text    the text
  */
 void sendASynchronousMail(String toEmail,String subject,String text);

 /**
  * Find by id optional.
  *
  * @param id the id
  * @return the optional
  */
 Optional<Expense> findById(Long id);

 /**
  * Delete by id.
  *
  * @param id the id
  */
 void deleteById(Long id);

 /**
  * Find by user id list.
  *
  * @param userId the user id
  * @return the list
  */
 List<Expense> findByUserId(String userId);
}
