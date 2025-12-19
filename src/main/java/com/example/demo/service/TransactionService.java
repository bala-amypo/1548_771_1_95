package com.example.demo4.service;

import java.util.List;

import com.example.demo4.model.TransactionLog;

public interface TransactionService {

    TransactionLog addTransaction(Long userId, TransactionLog log);

    List<TransactionLog> getUserTransactions(Long userId);
}
