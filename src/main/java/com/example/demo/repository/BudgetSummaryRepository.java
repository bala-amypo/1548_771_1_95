// package com.example.demo3.repository;

// import java.util.Optional;
// import org.springframework.data.jpa.repository.JpaRepository;
// import com.example.demo3.model.BudgetSummary;

//     public interface BudgetSummaryRepository extends JpaRepository<BudgetSummary, Long> {
//     Optional<BudgetSummary> findByBudgetPlanId(Long budgetPlanId);
// }

package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.BudgetPlan;
import com.example.demo.model.BudgetSummary;

public interface BudgetSummaryRepository
        extends JpaRepository<BudgetSummary, Long> {

    Optional<BudgetSummary> findByBudgetPlan(BudgetPlan plan);
}
