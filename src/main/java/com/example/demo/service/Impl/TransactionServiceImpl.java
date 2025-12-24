package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.TransactionService;

import java.util.List;

public class TransactionServiceImpl implements TransactionService {

    private final TransactionLogRepository txRepo;
    private final UserRepository userRepo;

    public TransactionServiceImpl(TransactionLogRepository txRepo, UserRepository userRepo) {
        this.txRepo = txRepo;
        this.userRepo = userRepo;
    }

    public TransactionLog addTransaction(Long userId, TransactionLog log) {
        User user = userRepo.findById(userId).orElseThrow();
        log.setUser(user);
        log.validate();
        return txRepo.save(log);
    }

    public List<TransactionLog> getUserTransactions(Long userId) {
        User user = userRepo.findById(userId).orElseThrow();
        return txRepo.findByUser(user);
    }
}
