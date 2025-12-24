package com.example.demo.service.Impl;

import com.example.demo.dto.BudgetSummaryResponse;
import com.example.demo.exception.BadRequestException;
import com.example.demo.model.BudgetPlan;
import com.example.demo.model.User;
import com.example.demo.repository.BudgetPlanRepository;
import com.example.demo.repository.TransactionRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.BudgetSummaryService;
import org.springframework.stereotype.Service;

@Service   // ⭐ THIS LINE IS MANDATORY
public class BudgetSummaryServiceImpl implements BudgetSummaryService {

    private final BudgetPlanRepository budgetPlanRepository;
    private final TransactionRepository transactionRepository;
    private final UserRepository userRepository;

    public BudgetSummaryServiceImpl(
            BudgetPlanRepository budgetPlanRepository,
            TransactionRepository transactionRepository,
            UserRepository userRepository) {
        this.budgetPlanRepository = budgetPlanRepository;
        this.transactionRepository = transactionRepository;
        this.userRepository = userRepository;
    }

    @Override
    public BudgetSummaryResponse getSummary(Long userId, int month, int year) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new BadRequestException("User not found"));

        BudgetPlan plan = budgetPlanRepository
                .findByUserAndMonthAndYear(user, month, year)
                .orElseThrow(() -> new BadRequestException("Budget plan not found"));

        double spent = transactionRepository
                .sumExpensesByUserAndMonthAndYear(user, month, year);

        return new BudgetSummaryResponse(
                plan.getExpenseLimit(),
                spent,
                plan.getExpenseLimit() - spent
        );
    }
}
