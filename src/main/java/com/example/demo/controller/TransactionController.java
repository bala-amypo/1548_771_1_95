package com.example.demo.controller;

import com.example.demo.model.TransactionLog;
import com.example.demo.service.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/{userId}")
    public ResponseEntity<TransactionLog> addTransaction(@PathVariable Long userId, 
                                                        @RequestBody TransactionLog log) {
        return ResponseEntity.ok(transactionService.addTransaction(userId, log));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<TransactionLog>> getUserTransactions(@PathVariable Long userId) {
        return ResponseEntity.ok(transactionService.getUserTransactions(userId));
    }
}
