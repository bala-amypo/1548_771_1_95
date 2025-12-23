

// // package com.example.demo.repository;

// // import java.util.Optional;

// // import org.springframework.data.jpa.repository.JpaRepository;

// // import com.example.demo.model.BudgetPlan;
// // import com.example.demo.model.User;

// // public interface BudgetPlanRepository
// //         extends JpaRepository<BudgetPlan, Long> {

// //     Optional<BudgetPlan> findByUserAndMonthAndYear(
// //             User user,
// //             Integer month,
// //             Integer year
// //     );
// // }


// package com.example.demo.repository;

// import com.example.demo.model.BudgetPlan;
// import com.example.demo.model.User;
// import org.springframework.data.jpa.repository.JpaRepository;

// import java.util.Optional;

// public interface BudgetPlanRepository extends JpaRepository<BudgetPlan, Long> {

//     Optional<BudgetPlan> findByUserAndMonthAndYear(
//             User user,
//             Integer month,
//             Integer year
//     );
// }
package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.BudgetPlan;

@Repository
public interface BudgetPlanRepository extends JpaRepository<BudgetPlan, Long> {

    List<BudgetPlan> findByUserIdAndYearAndMonth(
            Long userId,
            Integer year,
            Integer month
    );
}
