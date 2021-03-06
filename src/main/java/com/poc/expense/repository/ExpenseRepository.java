package com.poc.expense.repository;

import com.poc.expense.entity.Expense;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * The interface Expense repository.
 */
@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {

    /**
     * Gets expenses by user id.
     *
     * @param userId the user id
     * @return the expenses by user id
     */
    @Query(value = "select * from Expense where user_Id = ?1" , nativeQuery = true)
List<Expense> getExpensesByUserId(String userId);
}
