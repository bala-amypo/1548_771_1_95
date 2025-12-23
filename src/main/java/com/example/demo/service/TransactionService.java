// package com.example.demo.service;

// import java.util.List;

// import com.example.demo.model.TransactionLog;

// public interface TransactionService {

//     TransactionLog addTransaction(Long userId, TransactionLog log);

//     List<TransactionLog> getUserTransactions(Long userId);
// }

package com.example.demo.service;

import com.example.demo.model.TransactionLog;

import java.util.List;

public interface TransactionService {

    TransactionLog addTransaction(Long userId, TransactionLog log);

    List<TransactionLog> getUserTransactions(Long userId);
}
