// package com.example.demo3.service.impl;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import com.example.demo3.model.BudgetPlan;
// import com.example.demo3.model.BudgetSummary;
// import com.example.demo3.repository.BudgetPlanRepository;
// import com.example.demo3.repository.BudgetSummaryRepository;
// import com.example.demo3.service.BudgetSummaryService;

// @Service
// public class BudgetSummaryServiceImpl implements BudgetSummaryService {

//     @Autowired
//     private BudgetSummaryRepository summaryRepo;

//     @Autowired
//     private BudgetPlanRepository budgetRepo;

//     @Override
//     public BudgetSummary generateSummary(Long budgetPlanId) {

//         BudgetPlan plan = budgetRepo.findById(budgetPlanId)
//                 .orElseThrow(() -> new RuntimeException("Budget plan not found"));

//         BudgetSummary summary = new BudgetSummary();
//         summary.setBudgetPlan(plan);

//         double totalIncome = plan.getIncomeTarget();
//         double totalExpense = plan.getExpenseLimit();

//         summary.setTotalIncome(totalIncome);
//         summary.setTotalExpense(totalExpense);

//         if (totalExpense <= plan.getExpenseLimit()) {
//             summary.setStatus("UNDER_LIMIT");
//         } else {
//             summary.setStatus("OVER_LIMIT");
//         }

//         return summaryRepo.save(summary);
//     }

//     @Override
//     public BudgetSummary getSummary(Long budgetPlanId) {
//         return summaryRepo.findByBudgetPlanId(budgetPlanId)
//                 .orElseThrow(() -> new RuntimeException("Summary not found"));
//     }
// }


package com.example.demo.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo4.exception.BadRequestException;
import com.example.demo4.model.BudgetPlan;
import com.example.demo4.model.BudgetSummary;
import com.example.demo4.model.Category;
import com.example.demo4.model.TransactionLog;
import com.example.demo4.repository.BudgetPlanRepository;
import com.example.demo4.repository.BudgetSummaryRepository;
import com.example.demo4.repository.TransactionLogRepository;
import com.example.demo4.service.BudgetSummaryService;

@Service
public class BudgetSummaryServiceImpl implements BudgetSummaryService {

    private final BudgetSummaryRepository budgetSummaryRepository;
    private final BudgetPlanRepository budgetPlanRepository;
    private final TransactionLogRepository transactionLogRepository;

    public BudgetSummaryServiceImpl(
            BudgetSummaryRepository budgetSummaryRepository,
            BudgetPlanRepository budgetPlanRepository,
            TransactionLogRepository transactionLogRepository
    ) {
        this.budgetSummaryRepository = budgetSummaryRepository;
        this.budgetPlanRepository = budgetPlanRepository;
        this.transactionLogRepository = transactionLogRepository;
    }

    @Override
    public BudgetSummary generateSummary(Long budgetPlanId) {

        BudgetPlan plan = budgetPlanRepository.findById(budgetPlanId)
                .orElseThrow(() ->
                        new BadRequestException("Budget plan not found")
                );

        LocalDate start = LocalDate.of(
                plan.getYear(), plan.getMonth(), 1
        );
        LocalDate end = start.withDayOfMonth(start.lengthOfMonth());

        List<TransactionLog> logs =
                transactionLogRepository.findByUserAndTransactionDateBetween(
                        plan.getUser(), start, end
                );

        double totalIncome = 0;
        double totalExpense = 0;

        for (TransactionLog log : logs) {
            if (Category.TYPE_INCOME.equals(log.getCategory().getType())) {
                totalIncome += log.getAmount();
            } else {
                totalExpense += log.getAmount();
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

        return budgetSummaryRepository.save(summary);
    }

    @Override
    public BudgetSummary getSummary(Long budgetPlanId) {

        BudgetPlan plan = budgetPlanRepository.findById(budgetPlanId)
                .orElseThrow(() ->
                        new BadRequestException("Budget plan not found")
                );

        return budgetSummaryRepository.findByBudgetPlan(plan)
                .orElseThrow(() ->
                        new BadRequestException("Summary not found")
                );
    }
}
