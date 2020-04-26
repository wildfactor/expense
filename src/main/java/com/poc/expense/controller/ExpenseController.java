package com.poc.expense.controller;

import com.poc.expense.dto.AddExpenseDto;
import com.poc.expense.entity.Expense;
import com.poc.expense.exception.ExceptionController;
import com.poc.expense.service.ExpenseService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * The type Expense controller.
 */
@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {
    private static final Logger logger = LoggerFactory.getLogger(ExpenseController.class);

    @Autowired
    private ExpenseService expenseService;

    /**
     * Send asynchronous mail response entity.
     *
     * @return the response entity
     */
    @ApiOperation(value = "Api for send Asynchronous mail", response = ResponseEntity.class)

    @Deprecated
    @PostMapping(value = "/mail", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Object> sendAsynchronousMail() {
        logger.debug("inside sendAsynchronousMail api");
        try {
            expenseService.sendASynchronousMail("paragbhavsar44@gmail.com",
                    "sending automatic mail using springboot",
                    "this is a testing mail");
        } catch (MailException e) {
            logger.error("Exception occur while send mail :");
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Internal server error");
        } catch (Exception e) {
            logger.error("Exception occur while send mail :");
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Internal server error");
        }
        return ResponseEntity.status(HttpStatus.OK).body("Mail sent successfully");
    }

    /**
     * Gets all expenses.
     *
     * @return the all expenses
     */
    @GetMapping("")
    public ResponseEntity<List<Expense>> getAllExpenses() throws ExceptionController {
        return ResponseEntity.ok(expenseService.getAllExpense());
    }

    /**
     * Add expense response entity.
     *
     * @param addExpenseDto the add expense dto
     * @return the response entity
     */
    @PostMapping("")
    public ResponseEntity addExpense(@Valid @RequestBody AddExpenseDto addExpenseDto) throws ExceptionController {
        expenseService.saveExpense(addExpenseDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    /**
     * Delete response entity.
     *
     * @param id the id
     * @return the response entity
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) throws ExceptionController {
        expenseService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    /**
     * Gets expenses by user.
     *
     * @param userId the user id
     * @return the expenses by user
     */
    @GetMapping("/{userId}")
    public ResponseEntity<List<Expense>> getExpensesByUser(@PathVariable String userId) throws ExceptionController {
        return ResponseEntity.ok(expenseService.findByUserId(userId));

    }

}
