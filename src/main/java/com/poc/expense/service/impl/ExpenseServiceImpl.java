package com.poc.expense.service.impl;

import com.poc.expense.dto.AddExpenseDto;
import com.poc.expense.entity.Expense;
import com.poc.expense.repository.ExpenseRepository;
import com.poc.expense.service.ExpenseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

@Service
public class ExpenseServiceImpl implements ExpenseService {
    @Autowired
    private ExpenseRepository expenseRepository;

    @Autowired
    private JavaMailSender sender;

    private static final Logger logger = LoggerFactory.getLogger(ExpenseServiceImpl.class);

    public ExpenseServiceImpl() {
    }

    public static int noOfQuickServiceThreads = 2;
    private ScheduledExecutorService quickService = Executors.newScheduledThreadPool(noOfQuickServiceThreads);

    public void sendASynchronousMail(String toEmail, String subject, String text) throws MailException, RuntimeException {
        logger.debug("inside sendASynchronousMail method");
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setFrom("sohamchaudhary@gmail.com");
        mail.setTo(toEmail);
        mail.setSubject(subject);
        mail.setText(text);
        quickService.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    sender.send(mail);
                } catch (Exception e) {
                    logger.error("Exception occurred while sending mails : ", e);
                }
            }
        });
    }

    @Override
    public List<Expense> getAllExpense() {
        return expenseRepository.findAll();
    }

    @Override
    public List<Expense> saveExpense(AddExpenseDto addExpenseDto) {
        List<Expense> expenses = addExpenseDto.getExpenses();
        for (Expense expense : expenses) {
            expenseRepository.save(expense);

        }
        return expenses;

    }

    public Optional<Expense> findById(Long id) {
        return expenseRepository.findById(id);
    }

    public void deleteById(Long id) {
        expenseRepository.deleteById(id);
    }

    public List<Expense> findByUserId(String userId){
        return expenseRepository.getExpensesByUserId(userId);
    }

}
