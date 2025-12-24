
// // package com.example.demo.controller;

// // import org.springframework.web.bind.annotation.GetMapping;
// // import org.springframework.web.bind.annotation.PathVariable;
// // import org.springframework.web.bind.annotation.PostMapping;
// // import org.springframework.web.bind.annotation.RequestMapping;
// // import org.springframework.web.bind.annotation.RestController;

// // import com.example.demo.model.BudgetSummary;
// // import com.example.demo.service.BudgetSummaryService;

// // @RestController
// // @RequestMapping("/summary")
// // public class BudgetSummaryController {

// //     private final BudgetSummaryService budgetSummaryService;

// //     public BudgetSummaryController(BudgetSummaryService budgetSummaryService) {
// //         this.budgetSummaryService = budgetSummaryService;
// //     }

// //     @PostMapping("/generate/{budgetPlanId}")
// //     public BudgetSummary generate(
// //             @PathVariable Long budgetPlanId
// //     ) {
// //         return budgetSummaryService.generateSummary(budgetPlanId);
// //     }

// //     @GetMapping("/{budgetPlanId}")
// //     public BudgetSummary get(
// //             @PathVariable Long budgetPlanId
// //     ) {
// //         return budgetSummaryService.getSummary(budgetPlanId);
// //     }
// // }
// package com.example.demo.controller;

// import com.example.demo.model.BudgetSummary;
// import com.example.demo.service.BudgetSummaryService;
// import org.springframework.web.bind.annotation.*;

// @RestController
// @RequestMapping("/summary")
// public class BudgetSummaryController {

//     private final BudgetSummaryService budgetSummaryService;

//     public BudgetSummaryController(BudgetSummaryService budgetSummaryService) {
//         this.budgetSummaryService = budgetSummaryService;
//     }

//     @PostMapping("/generate/{budgetPlanId}")
//     public BudgetSummary generate(@PathVariable Long budgetPlanId) {
//         return budgetSummaryService.generateSummary(budgetPlanId);
//     }

//     @GetMapping("/{budgetPlanId}")
//     public BudgetSummary get(@PathVariable Long budgetPlanId) {
//         return budgetSummaryService.getSummary(budgetPlanId);
//     }
// }

package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.BudgetSummaryService;

@RestController
@RequestMapping("/budget-summary")
public class BudgetSummaryController {

    private final BudgetSummaryService budgetSummaryService;

    public BudgetSummaryController(BudgetSummaryService budgetSummaryService) {
        this.budgetSummaryService = budgetSummaryService;
    }

    @GetMapping("/{userId}")
    public BudgetSummaryResponse getSummary(
            @PathVariable Long userId,
            @RequestParam Integer year,
            @RequestParam Integer month) {

        Double totalBudget =
                budgetSummaryService.getTotalBudget(userId, year, month);

        Double totalExpense =
                budgetSummaryService.getTotalExpense(userId, year, month);

        Double remainingBudget =
                budgetSummaryService.getRemainingBudget(userId, year, month);

        return new BudgetSummaryResponse(
                totalBudget, totalExpense, remainingBudget);
    }
}
