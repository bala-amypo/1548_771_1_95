package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.model.*;
import com.example.demo.repository.BudgetPlanRepository;
import com.example.demo.repository.BudgetSummaryRepository;
import com.example.demo.repository.TransactionLogRepository;
import com.example.demo.service.BudgetSummaryService;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.util.List;

@Service
public class BudgetSummaryServiceImpl implements BudgetSummaryService {
    private final BudgetSummaryRepository budgetSummaryRepository;
    private final BudgetPlanRepository budgetPlanRepository;
    private final TransactionLogRepository transactionLogRepository;

    public BudgetSummaryServiceImpl(BudgetSummaryRepository budgetSummaryRepository,
                                    BudgetPlanRepository budgetPlanRepository,
                                    TransactionLogRepository transactionLogRepository) {
        this.budgetSummaryRepository = budgetSummaryRepository;
        this.budgetPlanRepository = budgetPlanRepository;
        this.transactionLogRepository = transactionLogRepository;
    }

    @Override
    public BudgetSummary generateSummary(Long budgetPlanId) {
        BudgetPlan plan = budgetPlanRepository.findById(budgetPlanId)
                .orElseThrow(() -> new BadRequestException("Budget plan not found"));

        YearMonth ym = YearMonth.of(plan.getYear(), plan.getMonth());
        LocalDate start = ym.atDay(1);
        LocalDate end = ym.atEndOfMonth();

        List<TransactionLog> transactions = transactionLogRepository
                .findByUserAndTransactionDateBetween(plan.getUser(), start, end);

        double totalIncome = 0.0;
        double totalExpense = 0.0;

        for (TransactionLog t : transactions) {
            if (Category.TYPE_INCOME.equals(t.getCategory().getType())) {
                totalIncome += t.getAmount();
            } else if (Category.TYPE_EXPENSE.equals(t.getCategory().getType())) {
                totalExpense += t.getAmount();
            }
        }

        String status = totalExpense <= plan.getExpenseLimit() 
                ? BudgetSummary.STATUS_UNDER_LIMIT 
                : BudgetSummary.STATUS_OVER_LIMIT;

        BudgetSummary summary = new BudgetSummary();
        summary.setBudgetPlan(plan);
        summary.setTotalIncome(totalIncome);
        summary.setTotalExpense(totalExpense);
        summary.setStatus(status);
        summary.setGeneratedAt(LocalDateTime.now());

        return budgetSummaryRepository.save(summary);
    }

    @Override
    public BudgetSummary getSummary(Long budgetPlanId) {
        BudgetPlan plan = budgetPlanRepository.findById(budgetPlanId)
                .orElseThrow(() -> new BadRequestException("Budget plan not found"));
        return budgetSummaryRepository.findByBudgetPlan(plan)
                .orElseThrow(() -> new BadRequestException("Budget summary not found"));
    }
}