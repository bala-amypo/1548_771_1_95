
// // package com.example.demo.service.impl;

// // import java.time.LocalDate;
// // import java.util.List;

// // import org.springframework.stereotype.Service;

// // import com.example.demo.exception.BadRequestException;
// // import com.example.demo.model.BudgetPlan;
// // import com.example.demo.model.BudgetSummary;
// // import com.example.demo.model.Category;
// // import com.example.demo.model.TransactionLog;
// // import com.example.demo.repository.BudgetPlanRepository;
// // import com.example.demo.repository.BudgetSummaryRepository;
// // import com.example.demo.repository.TransactionLogRepository;
// // import com.example.demo.service.BudgetSummaryService;

// // @Service
// // public class BudgetSummaryServiceImpl implements BudgetSummaryService {

// //     private final BudgetSummaryRepository budgetSummaryRepository;
// //     private final BudgetPlanRepository budgetPlanRepository;
// //     private final TransactionLogRepository transactionLogRepository;

// //     public BudgetSummaryServiceImpl(
// //             BudgetSummaryRepository budgetSummaryRepository,
// //             BudgetPlanRepository budgetPlanRepository,
// //             TransactionLogRepository transactionLogRepository
// //     ) {
// //         this.budgetSummaryRepository = budgetSummaryRepository;
// //         this.budgetPlanRepository = budgetPlanRepository;
// //         this.transactionLogRepository = transactionLogRepository;
// //     }

// //     @Override
// //     public BudgetSummary generateSummary(Long budgetPlanId) {

// //         BudgetPlan plan = budgetPlanRepository.findById(budgetPlanId)
// //                 .orElseThrow(() ->
// //                         new BadRequestException("Budget plan not found")
// //                 );

// //         LocalDate start = LocalDate.of(
// //                 plan.getYear(), plan.getMonth(), 1
// //         );
// //         LocalDate end = start.withDayOfMonth(start.lengthOfMonth());

// //         List<TransactionLog> logs =
// //                 transactionLogRepository.findByUserAndTransactionDateBetween(
// //                         plan.getUser(), start, end
// //                 );

// //         double totalIncome = 0;
// //         double totalExpense = 0;

// //         for (TransactionLog log : logs) {
// //             if (Category.TYPE_INCOME.equals(log.getCategory().getType())) {
// //                 totalIncome += log.getAmount();
// //             } else {
// //                 totalExpense += log.getAmount();
// //             }
// //         }

// //         String status = totalExpense <= plan.getExpenseLimit()
// //                 ? BudgetSummary.STATUS_UNDER_LIMIT
// //                 : BudgetSummary.STATUS_OVER_LIMIT;

// //         BudgetSummary summary = new BudgetSummary();
// //         summary.setBudgetPlan(plan);
// //         summary.setTotalIncome(totalIncome);
// //         summary.setTotalExpense(totalExpense);
// //         summary.setStatus(status);

// //         return budgetSummaryRepository.save(summary);
// //     }

// //     @Override
// //     public BudgetSummary getSummary(Long budgetPlanId) {

// //         BudgetPlan plan = budgetPlanRepository.findById(budgetPlanId)
// //                 .orElseThrow(() ->
// //                         new BadRequestException("Budget plan not found")
// //                 );

// //         return budgetSummaryRepository.findByBudgetPlan(plan)
// //                 .orElseThrow(() ->
// //                         new BadRequestException("Summary not found")
// //                 );
// //     }
// // }


// package com.example.demo.service.impl;

// import com.example.demo.exception.BadRequestException;
// import com.example.demo.model.*;
// import com.example.demo.repository.BudgetPlanRepository;
// import com.example.demo.repository.BudgetSummaryRepository;
// import com.example.demo.repository.TransactionLogRepository;
// import com.example.demo.service.BudgetSummaryService;

// import java.time.LocalDate;
// import java.time.YearMonth;
// import java.util.List;

// public class BudgetSummaryServiceImpl implements BudgetSummaryService {

//     private final BudgetSummaryRepository budgetSummaryRepository;
//     private final BudgetPlanRepository budgetPlanRepository;
//     private final TransactionLogRepository transactionLogRepository;

//     public BudgetSummaryServiceImpl(BudgetSummaryRepository budgetSummaryRepository,
//                                     BudgetPlanRepository budgetPlanRepository,
//                                     TransactionLogRepository transactionLogRepository) {
//         this.budgetSummaryRepository = budgetSummaryRepository;
//         this.budgetPlanRepository = budgetPlanRepository;
//         this.transactionLogRepository = transactionLogRepository;
//     }

//     @Override
//     public BudgetSummary generateSummary(Long budgetPlanId) {
//         BudgetPlan plan = budgetPlanRepository.findById(budgetPlanId)
//                 .orElseThrow(() -> new BadRequestException("Budget plan not found"));

//         YearMonth ym = YearMonth.of(plan.getYear(), plan.getMonth());
//         LocalDate start = ym.atDay(1);
//         LocalDate end = ym.atEndOfMonth();

//         List<TransactionLog> logs =
//                 transactionLogRepository.findByUserAndTransactionDateBetween(
//                         plan.getUser(), start, end);

//         double income = 0;
//         double expense = 0;

//         for (TransactionLog log : logs) {
//             if (Category.TYPE_INCOME.equals(log.getCategory().getType())) {
//                 income += log.getAmount();
//             } else {
//                 expense += log.getAmount();
//             }
//         }

//         BudgetSummary summary = new BudgetSummary();
//         summary.setBudgetPlan(plan);
//         summary.setTotalIncome(income);
//         summary.setTotalExpense(expense);
//         summary.setStatus(
//                 expense <= plan.getExpenseLimit()
//                         ? BudgetSummary.STATUS_UNDER_LIMIT
//                         : BudgetSummary.STATUS_OVER_LIMIT
//         );

//         return budgetSummaryRepository.save(summary);
//     }

//     @Override
//     public BudgetSummary getSummary(Long budgetPlanId) {
//         BudgetPlan plan = budgetPlanRepository.findById(budgetPlanId)
//                 .orElseThrow(() -> new BadRequestException("Budget plan not found"));

//         return budgetSummaryRepository.findByBudgetPlan(plan)
//                 .orElseThrow(() -> new BadRequestException("Summary not found"));
//     }
// }
package com.example.demo.service.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.BudgetPlan;
import com.example.demo.model.Transaction;
import com.example.demo.repository.BudgetPlanRepository;
import com.example.demo.repository.TransactionRepository;
import com.example.demo.service.BudgetSummaryService;

@Service
public class BudgetSummaryServiceImpl implements BudgetSummaryService {

    private final BudgetPlanRepository budgetPlanRepository;
    private final TransactionRepository transactionRepository;

    public BudgetSummaryServiceImpl(
            BudgetPlanRepository budgetPlanRepository,
            TransactionRepository transactionRepository) {
        this.budgetPlanRepository = budgetPlanRepository;
        this.transactionRepository = transactionRepository;
    }

    @Override
    public Double getTotalBudget(Long userId, Integer year, Integer month) {
        List<BudgetPlan> plans =
                budgetPlanRepository.findByUserIdAndYearAndMonth(userId, year, month);

        return plans.stream()
                .mapToDouble(BudgetPlan::getExpenseLimit)
                .sum();
    }

    @Override
    public Double getTotalExpense(Long userId, Integer year, Integer month) {
        List<Transaction> transactions =
                transactionRepository.findByUserIdAndYearAndMonth(
                        userId, year, month, "EXPENSE");

        return transactions.stream()
                .mapToDouble(Transaction::getAmount)
                .sum();
    }

    @Override
    public Double getRemainingBudget(Long userId, Integer year, Integer month) {
        Double budget = getTotalBudget(userId, year, month);
        Double expense = getTotalExpense(userId, year, month);
        return budget - expense;
    }
}
