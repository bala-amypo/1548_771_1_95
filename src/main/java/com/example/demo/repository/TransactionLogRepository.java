package com.example.demo.repository;

import com.example.demo.model.TransactionLog;
import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TransactionLogRepository
        extends JpaRepository<TransactionLog, Long> {

    @Query("""
        SELECT COALESCE(SUM(t.amount), 0)
        FROM TransactionLog t
        WHERE t.user = :user
          AND MONTH(t.transactionDate) = :month
          AND YEAR(t.transactionDate) = :year
    """)
    double sumByUserAndMonthAndYear(
            @Param("user") User user,
            @Param("month") int month,
            @Param("year") int year
    );
}
