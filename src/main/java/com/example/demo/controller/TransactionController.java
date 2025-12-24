

// // package com.example.demo.controller;

// // import java.util.List;

// // import org.springframework.web.bind.annotation.GetMapping;
// // import org.springframework.web.bind.annotation.PathVariable;
// // import org.springframework.web.bind.annotation.PostMapping;
// // import org.springframework.web.bind.annotation.RequestBody;
// // import org.springframework.web.bind.annotation.RequestMapping;
// // import org.springframework.web.bind.annotation.RestController;

// // import com.example.demo.model.TransactionLog;
// // import com.example.demo.service.TransactionService;

// // @RestController
// // @RequestMapping("/transactions")
// // public class TransactionController {

// //     private final TransactionService transactionService;

// //     public TransactionController(TransactionService transactionService) {
// //         this.transactionService = transactionService;
// //     }

// //     @PostMapping("/{userId}")
// //     public TransactionLog addTransaction(
// //             @PathVariable Long userId,
// //             @RequestBody TransactionLog log
// //     ) {
// //         return transactionService.addTransaction(userId, log);
// //     }

// //     @GetMapping("/user/{userId}")
// //     public List<TransactionLog> getUserTransactions(
// //             @PathVariable Long userId
// //     ) {
// //         return transactionService.getUserTransactions(userId);
// //     }
// // }

// package com.example.demo.controller;

// import com.example.demo.model.TransactionLog;
// import com.example.demo.service.TransactionService;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;

// @RestController
// @RequestMapping("/transactions")
// public class TransactionController {

//     private final TransactionService transactionService;

//     public TransactionController(TransactionService transactionService) {
//         this.transactionService = transactionService;
//     }

//     @PostMapping("/{userId}")
//     public TransactionLog add(@PathVariable Long userId,
//                               @RequestBody TransactionLog log) {
//         return transactionService.addTransaction(userId, log);
//     }

//     @GetMapping("/user/{userId}")
//     public List<TransactionLog> getUserTransactions(@PathVariable Long userId) {
//         return transactionService.getUserTransactions(userId);
//     }
// }
package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Transaction;
import com.example.demo.service.TransactionService;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    public Transaction addTransaction(@RequestBody Transaction transaction) {
        return transactionService.addTransaction(transaction);
    }

    @GetMapping("/user/{userId}")
    public List<Transaction> getByUser(@PathVariable Long userId) {
        return transactionService.getTransactionsByUser(userId);
    }
}
