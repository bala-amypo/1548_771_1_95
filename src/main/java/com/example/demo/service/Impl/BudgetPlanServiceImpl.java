package com.example.demo.service.Impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.model.BudgetPlan;
import com.example.demo.model.User;
import com.example.demo.repository.BudgetPlanRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.BudgetPlanService;
import org.springframework.stereotype.Service;

@Service   // 🔥 THIS IS REQUIRED
public class BudgetPlanServiceImpl implements BudgetPlanService {

    private final BudgetPlanRepository budgetPlanRepository;
    private final UserRepository userRepository;

    public BudgetPlanServiceImpl(BudgetPlanRepository budgetPlanRepository,
                                 UserRepository userRepository) {
        this.budgetPlanRepository = budgetPlanRepository;
        this.userRepository = userRepository;
    }

    @Override
    public BudgetPlan createBudgetPlan(Long userId, BudgetPlan plan) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new BadRequestException("User not found"));

        budgetPlanRepository.findByUserAndMonthAndYear(
                user, plan.getMonth(), plan.getYear()
        ).ifPresent(p -> {
            throw new BadRequestException("Budget plan already exists");
        });

        plan.setUser(user);
        return budgetPlanRepository.save(plan);
    }
}
