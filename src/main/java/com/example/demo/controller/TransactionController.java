// package com.example.demo3.controller;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import com.example.demo3.model.TransactionLog;
// import com.example.demo3.service.TransactionService;

// import io.swagger.v3.oas.annotations.parameters.RequestBody;

// @RestController
// @RequestMapping("/transactions")
// public class TransactionController {

//     @Autowired
//     private TransactionService service;

//     @PostMapping("/{userId}")
//     public TransactionLog add(@PathVariable Long userId,
//                               @RequestBody TransactionLog log) {
//         return service.addTransaction(userId, log);
//     }

//     @GetMapping("/{userId}")
//     public List<TransactionLog> list(@PathVariable Long userId) {
//         return service.getUserTransactions(userId);
//     }
// }
