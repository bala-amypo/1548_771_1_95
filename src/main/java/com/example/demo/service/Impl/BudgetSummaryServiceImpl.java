package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.BudgetSummaryService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service 
public class BudgetSummaryServiceImpl implements BudgetSummaryService {

    private final BudgetSummaryRepository budgetSummaryRepository;
    private final BudgetPlanRepository budgetPlanRepository;
    private final TransactionLogRepository transactionLogRepository;

    public BudgetSummaryServiceImpl(
            BudgetSummaryRepository budgetSummaryRepository,
            BudgetPlanRepository budgetPlanRepository,
            TransactionLogRepository transactionLogRepository) {

        this.budgetSummaryRepository = budgetSummaryRepository;
        this.budgetPlanRepository = budgetPlanRepository;
        this.transactionLogRepository = transactionLogRepository;
    }

    @Override
    public BudgetSummary generateSummary(Long budgetPlanId) {

        BudgetPlan plan = budgetPlanRepository.findById(budgetPlanId).orElseThrow();
        User user = plan.getUser();

        LocalDate start = LocalDate.of(plan.getYear(), plan.getMonth(), 1);
        LocalDate end = start.withDayOfMonth(start.lengthOfMonth());

        List<TransactionLog> logs =
                transactionLogRepository.findByUserAndTransactionDateBetween(
                        user, start, end);

        double totalIncome = logs.stream()
                .filter(t -> Category.TYPE_INCOME.equals(t.getCategory().getType()))
                .mapToDouble(TransactionLog::getAmount)
                .sum();

        double totalExpense = logs.stream()
                .filter(t -> Category.TYPE_EXPENSE.equals(t.getCategory().getType()))
                .mapToDouble(TransactionLog::getAmount)
                .sum();

        String status = totalExpense <= plan.getExpenseLimit()
                ? BudgetSummary.STATUS_UNDER_LIMIT
                : BudgetSummary.STATUS_OVER_LIMIT;

        BudgetSummary summary = new BudgetSummary(
                null, plan, totalIncome, totalExpense, status, null
        );

        return budgetSummaryRepository.save(summary);
    }

    @Override
    public BudgetSummary getSummary(Long budgetPlanId) {

        BudgetPlan plan = budgetPlanRepository.findById(budgetPlanId).orElseThrow();
        return budgetSummaryRepository.findByBudgetPlan(plan).orElse(null);
    }
}
