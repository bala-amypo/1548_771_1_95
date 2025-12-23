

// // // package com.example.demo.service.impl;

// // // import org.springframework.stereotype.Service;

// // // import com.example.demo.exception.BadRequestException;
// // // import com.example.demo.model.BudgetPlan;
// // // import com.example.demo.model.User;
// // // import com.example.demo.repository.BudgetPlanRepository;
// // // import com.example.demo.repository.UserRepository;
// // // import com.example.demo.service.BudgetPlanService;

// // // @Service
// // // public class BudgetPlanServiceImpl implements BudgetPlanService {

// // //     private final BudgetPlanRepository budgetPlanRepository;
// // //     private final UserRepository userRepository;

// // //     public BudgetPlanServiceImpl(
// // //             BudgetPlanRepository budgetPlanRepository,
// // //             UserRepository userRepository
// // //     ) {
// // //         this.budgetPlanRepository = budgetPlanRepository;
// // //         this.userRepository = userRepository;
// // //     }

// // //     @Override
// // //     public BudgetPlan createBudgetPlan(Long userId, BudgetPlan plan) {

// // //         User user = userRepository.findById(userId)
// // //                 .orElseThrow(() ->
// // //                         new BadRequestException("User not found: " + userId)
// // //                 );

// // //         plan.setUser(user);
// // //         plan.validate();

// // //         budgetPlanRepository.findByUserAndMonthAndYear(
// // //                 user, plan.getMonth(), plan.getYear()
// // //         ).ifPresent(existing -> {
// // //             throw new BadRequestException(
// // //                     "Budget plan already exists for this month and year"
// // //             );
// // //         });

// // //         return budgetPlanRepository.save(plan);
// // //     }

// // //     @Override
// // //     public BudgetPlan getBudgetPlan(Long userId, Integer month, Integer year) {

// // //         User user = userRepository.findById(userId)
// // //                 .orElseThrow(() ->
// // //                         new BadRequestException("User not found: " + userId)
// // //                 );

// // //         return budgetPlanRepository.findByUserAndMonthAndYear(user, month, year)
// // //                 .orElseThrow(() ->
// // //                         new BadRequestException("Budget plan not found")
// // //                 );
// // //     }
// // // }

// // package com.example.demo.service.impl;

// // import com.example.demo.exception.BadRequestException;
// // import com.example.demo.model.BudgetPlan;
// // import com.example.demo.model.User;
// // import com.example.demo.repository.BudgetPlanRepository;
// // import com.example.demo.repository.UserRepository;
// // import com.example.demo.service.BudgetPlanService;

// // public class BudgetPlanServiceImpl implements BudgetPlanService {

// //     private final BudgetPlanRepository budgetPlanRepository;
// //     private final UserRepository userRepository;

// //     public BudgetPlanServiceImpl(BudgetPlanRepository budgetPlanRepository,
// //                                  UserRepository userRepository) {
// //         this.budgetPlanRepository = budgetPlanRepository;
// //         this.userRepository = userRepository;
// //     }

// //     @Override
// //     public BudgetPlan createBudgetPlan(Long userId, BudgetPlan plan) {
// //         User user = userRepository.findById(userId)
// //                 .orElseThrow(() -> new BadRequestException("User not found"));
// //         plan.setUser(user);
// //         plan.validate();

// //         if (budgetPlanRepository
// //                 .findByUserAndMonthAndYear(user, plan.getMonth(), plan.getYear())
// //                 .isPresent()) {
// //             throw new BadRequestException("Budget plan already exists");
// //         }
// //         return budgetPlanRepository.save(plan);
// //     }

// //     @Override
// //     public BudgetPlan getBudgetPlan(Long userId, Integer month, Integer year) {
// //         User user = userRepository.findById(userId)
// //                 .orElseThrow(() -> new BadRequestException("User not found"));
// //         return budgetPlanRepository
// //                 .findByUserAndMonthAndYear(user, month, year)
// //                 .orElseThrow(() -> new BadRequestException("Budget plan not found"));
// //     }
// // }

// package com.example.demo.service.impl;

// import java.util.List;

// import org.springframework.stereotype.Service;

// import com.example.demo.model.BudgetPlan;
// import com.example.demo.repository.BudgetPlanRepository;
// import com.example.demo.service.BudgetPlanService;

// @Service   // ⭐ THIS IS WHAT CREATES THE BEAN
// public class BudgetPlanServiceImpl implements BudgetPlanService {

//     private final BudgetPlanRepository repository;

//     public BudgetPlanServiceImpl(BudgetPlanRepository repository) {
//         this.repository = repository;
//     }

//     @Override
//     public BudgetPlan create(BudgetPlan plan) {
//         return repository.save(plan);
//     }

//     @Override
//     public List<BudgetPlan> getAll() {
//         return repository.findAll();
//     }

//     @Override
//     public BudgetPlan getById(Long id) {
//         return repository.findById(id)
//                 .orElseThrow(() -> new RuntimeException("BudgetPlan not found"));
//     }

//     @Override
//     public BudgetPlan update(Long id, BudgetPlan plan) {
//         BudgetPlan existing = getById(id);
//         existing.setName(plan.getName());
//         existing.setAmount(plan.getAmount());
//         return repository.save(existing);
//     }

//     @Override
//     public void delete(Long id) {
//         repository.deleteById(id);
//     }
// }
package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.BudgetPlan;
import com.example.demo.repository.BudgetPlanRepository;
import com.example.demo.service.BudgetPlanService;

@Service
public class BudgetPlanServiceImpl implements BudgetPlanService {

    private final BudgetPlanRepository repository;

    public BudgetPlanServiceImpl(BudgetPlanRepository repository) {
        this.repository = repository;
    }

    @Override
    public BudgetPlan createBudgetPlan(Long userId, BudgetPlan plan) {
        // example logic
        return repository.save(plan);
    }

    @Override
    public List<BudgetPlan> getBudgetPlan(Long userId, Integer month, Integer year) {
        // example logic
        return repository.findAll();
    }
}
