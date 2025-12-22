// // package com.example.demo3.controller;

// // import java.util.List;

// // import org.springframework.beans.factory.annotation.Autowired;
// // import org.springframework.web.bind.annotation.GetMapping;
// // import org.springframework.web.bind.annotation.PathVariable;
// // import org.springframework.web.bind.annotation.PostMapping;
// // import org.springframework.web.bind.annotation.RequestMapping;
// // import org.springframework.web.bind.annotation.RestController;

// // import com.example.demo3.model.TransactionLog;
// // import com.example.demo3.service.TransactionService;

// // import io.swagger.v3.oas.annotations.parameters.RequestBody;

// // @RestController
// // @RequestMapping("/transactions")
// // public class TransactionController {

// //     @Autowired
// //     private TransactionService service;

// //     @PostMapping("/{userId}")
// //     public TransactionLog add(@PathVariable Long userId,
// //                               @RequestBody TransactionLog log) {
// //         return service.addTransaction(userId, log);
// //     }

// //     @GetMapping("/{userId}")
// //     public List<TransactionLog> list(@PathVariable Long userId) {
// //         return service.getUserTransactions(userId);
// //     }
// // }



// package com.example.demo.controller;

// import java.util.List;

// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import com.example.demo.model.TransactionLog;
// import com.example.demo.service.TransactionService;

// @RestController
// @RequestMapping("/transactions")
// public class TransactionController {

//     private final TransactionService transactionService;

//     public TransactionController(TransactionService transactionService) {
//         this.transactionService = transactionService;
//     }

//     @PostMapping("/{userId}")
//     public TransactionLog addTransaction(
//             @PathVariable Long userId,
//             @RequestBody TransactionLog log
//     ) {
//         return transactionService.addTransaction(userId, log);
//     }

//     @GetMapping("/user/{userId}")
//     public List<TransactionLog> getUserTransactions(
//             @PathVariable Long userId
//     ) {
//         return transactionService.getUserTransactions(userId);
//     }
// }
package com.example.demo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Category;
import com.example.demo.model.TransactionLog;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.TransactionLogRepository;
@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionLogRepository txRepo;
    private final CategoryRepository catRepo;

    public TransactionController(TransactionLogRepository txRepo,
                                 CategoryRepository catRepo) {
        this.txRepo = txRepo;
        this.catRepo = catRepo;
    }

    @PostMapping
    public TransactionLog create(@RequestBody TransactionLog log) {

        Long categoryId = log.getCategory().getId();

        Category category = catRepo.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found"));

        log.setCategory(category);
        return txRepo.save(log);
    }
}


// @RestController
// @RequestMapping("/transactions")
// public class TransactionController {

//     private final TransactionService transactionService;

//     public TransactionController(TransactionService transactionService) {
//         this.transactionService = transactionService;
//     }

//     @PostMapping("/{userId}")
//     public TransactionLog addTransaction(
//             @PathVariable Long userId,
//             @RequestBody TransactionLog log
//     ) {
//         return transactionService.addTransaction(userId, log);
//     }

//     @GetMapping("/user/{userId}")
//     public List<TransactionLog> getUserTransactions(
//             @PathVariable Long userId
//     ) {
//         return transactionService.getUserTransactions(userId);
//     }
// }
// 
package com.example.demo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Category;
import com.example.demo.model.TransactionLog;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.TransactionLogRepository;
@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionLogRepository txRepo;
    private final CategoryRepository catRepo;

    public TransactionController(TransactionLogRepository txRepo,
                                 CategoryRepository catRepo) {
        this.txRepo = txRepo;
        this.catRepo = catRepo;
    }

    @PostMapping
    public TransactionLog create(@RequestBody TransactionLog log) {

        Long categoryId = log.getCategory().getId();

        Category category = catRepo.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found"));

        log.setCategory(category);
        return txRepo.save(log);
    }
}
