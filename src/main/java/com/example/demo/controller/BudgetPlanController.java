
// // package com.example.demo.controller;

// // import org.springframework.web.bind.annotation.GetMapping;
// // import org.springframework.web.bind.annotation.PathVariable;
// // import org.springframework.web.bind.annotation.PostMapping;
// // import org.springframework.web.bind.annotation.RequestBody;
// // import org.springframework.web.bind.annotation.RequestMapping;
// // import org.springframework.web.bind.annotation.RestController;

// // import com.example.demo.model.BudgetPlan;
// // import com.example.demo.service.BudgetPlanService;

// // @RestController
// // @RequestMapping("/budgets")
// // public class BudgetPlanController {

// //     private final BudgetPlanService budgetPlanService;

// //     public BudgetPlanController(BudgetPlanService budgetPlanService) {
// //         this.budgetPlanService = budgetPlanService;
// //     }

// //     @PostMapping("/{userId}")
// //     public BudgetPlan create(
// //             @PathVariable Long userId,
// //             @RequestBody BudgetPlan plan
// //     ) {
// //         return budgetPlanService.createBudgetPlan(userId, plan);
// //     }

// //     @GetMapping("/{userId}/{month}/{year}")
// //     public BudgetPlan get(
// //             @PathVariable Long userId,
// //             @PathVariable Integer month,
// //             @PathVariable Integer year
// //     ) {
// //         return budgetPlanService.getBudgetPlan(userId, month, year);
// //     }
// // }


// package com.example.demo.controller;

// import com.example.demo.model.BudgetPlan;
// import com.example.demo.service.BudgetPlanService;
// import org.springframework.web.bind.annotation.*;

// @RestController
// @RequestMapping("/budgets")
// public class BudgetPlanController {

//     private final BudgetPlanService budgetPlanService;

//     public BudgetPlanController(BudgetPlanService budgetPlanService) {
//         this.budgetPlanService = budgetPlanService;
//     }

//     @PostMapping("/{userId}")
//     public BudgetPlan create(@PathVariable Long userId,
//                              @RequestBody BudgetPlan plan) {
//         return budgetPlanService.createBudgetPlan(userId, plan);
//     }

//     @GetMapping
//     public List<BudgetPlan> getBudgetPlan(
//         @RequestParam Long userId,
//         @RequestParam Integer month,
//         @RequestParam Integer year) {

//     return budgetPlanService.getBudgetPlan(userId, month, year);
// }

// }




package com.example.demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.BudgetPlan;
import com.example.demo.service.BudgetPlanService;

@RestController
@RequestMapping("/api/budget-plans")
public class BudgetPlanController {

    private final BudgetPlanService budgetPlanService;

    public BudgetPlanController(BudgetPlanService budgetPlanService) {
        this.budgetPlanService = budgetPlanService;
    }

    // ✅ Create a budget plan
    @PostMapping("/{userId}")
    public ResponseEntity<BudgetPlan> createBudgetPlan(
            @PathVariable Long userId,
            @RequestBody BudgetPlan budgetPlan) {

        BudgetPlan savedPlan =
                budgetPlanService.createBudgetPlan(userId, budgetPlan);

        return ResponseEntity.ok(savedPlan);
    }

    // ✅ Get budget plans by user + year + month
    @GetMapping
    public ResponseEntity<List<BudgetPlan>> getBudgetPlans(
            @RequestParam Long userId,
            @RequestParam Integer year,
            @RequestParam Integer month) {

        List<BudgetPlan> plans =
                budgetPlanService.getBudgetPlans(userId, year, month);

        return ResponseEntity.ok(plans);
    }
}
