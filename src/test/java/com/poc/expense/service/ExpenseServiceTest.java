package com.poc.expense.service;


import com.poc.expense.dto.AddExpenseDto;
import com.poc.expense.entity.Expense;
import com.poc.expense.repository.ExpenseRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ExpenseServiceTest {
    @Autowired
    private ExpenseService expenseService;

    @MockBean
    private ExpenseRepository expenseRepository;

    private List<Expense> expenses = new ArrayList<>();

    private Expense expense;

    private AddExpenseDto addExpenseDto;


    @Before
    public void setUp() {
        expense = new Expense(1, "sept2020", 200.0, "stationary", "9876");
        expenses.add(expense);
        addExpenseDto = new AddExpenseDto(expenses);
    }


    @Test
    public void getAllExpenseTest() {
        when(expenseRepository.findAll()).thenReturn(expenses);
        assertEquals(1, expenseService.getAllExpense().size());
    }

    @Test
    public void saveExpenseTest() {
        when(expenseRepository.save(expense)).thenReturn(expense);
        List<Expense> outputExpense = expenseService.saveExpense(addExpenseDto);
        assertEquals(expenses, outputExpense);

    }

    @Test
    public void findByIdTest() {
        expenseRepository.findById(85L);

    }

    @Test
    public void deleteByIdTest() {
        expenseRepository.deleteById(85L);
        verify(expenseRepository, times(1)).deleteById(85L);
    }

    @Test
    public void findByUserIdTest() {
        String userId = "8765";
        when(expenseRepository.getExpensesByUserId(userId)).thenReturn(expenses);
        assertEquals(1, expenseService.findByUserId(userId).size());
    }
}