// // package com.example.demo3.service.impl;

// // import org.springframework.beans.factory.annotation.Autowired;
// // import org.springframework.stereotype.Service;

// // import com.example.demo3.model.TransactionLog;
// // import com.example.demo3.model.User;
// // import com.example.demo3.repository.TransactionLogRepository;
// // import com.example.demo3.repository.UserRepository;
// // import com.example.demo3.service.TransactionService;

// // import java.time.LocalDate;
// // import java.util.List;

// // @Service
// // public class TransactionServiceImpl implements TransactionService {

// //     @Autowired
// //     private TransactionLogRepository transactionRepo;

// //     @Autowired
// //     private UserRepository userRepo;

// //     @Override
// //     public TransactionLog addTransaction(Long userId, TransactionLog log) {

// //         if (log.getAmount() <= 0) {
// //             throw new RuntimeException("Amount must be greater than zero");
// //         }

// //         if (log.getTransactionDate().isAfter(LocalDate.now())) {
// //             throw new RuntimeException("Future date not allowed");
// //         }

// //         User user = userRepo.findById(userId)
// //                 .orElseThrow(() -> new RuntimeException("User not found"));

// //         log.setUser(user);
// //         return transactionRepo.save(log);
// //     }

// //     @Override
// //     public List<TransactionLog> getUserTransactions(Long userId) {
// //         return transactionRepo.findByUserId(userId);
// //     }
// // }






// package com.example.demo.service.impl;

// import java.util.List;

// import org.springframework.stereotype.Service;

// import com.example.demo.exception.BadRequestException;
// import com.example.demo.model.TransactionLog;
// import com.example.demo.model.User;
// import com.example.demo.repository.TransactionLogRepository;
// import com.example.demo.repository.UserRepository;
// import com.example.demo.service.TransactionService;

// @Service
// public class TransactionServiceImpl implements TransactionService {

//     private final TransactionLogRepository transactionLogRepository;
//     private final UserRepository userRepository;

//     public TransactionServiceImpl(
//             TransactionLogRepository transactionLogRepository,
//             UserRepository userRepository
//     ) {
//         this.transactionLogRepository = transactionLogRepository;
//         this.userRepository = userRepository;
//     }

//     @Override
//     public TransactionLog addTransaction(Long userId, TransactionLog log) {

//         User user = userRepository.findById(userId)
//                 .orElseThrow(() ->
//                         new BadRequestException("User not found with id: " + userId)
//                 );

//         log.setUser(user);
//         log.validate();

//         return transactionLogRepository.save(log);
//     }

//     @Override
//     public List<TransactionLog> getUserTransactions(Long userId) {

//         User user = userRepository.findById(userId)
//                 .orElseThrow(() ->
//                         new BadRequestException("User not found with id: " + userId)
//                 );

//         return transactionLogRepository.findByUser(user);
//     }
// }




package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.exception.BadRequestException;
import com.example.demo.model.TransactionLog;
import com.example.demo.model.User;
import com.example.demo.repository.TransactionLogRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionLogRepository transactionLogRepository;
    private final UserRepository userRepository;

    public TransactionServiceImpl(
            TransactionLogRepository transactionLogRepository,
            UserRepository userRepository
    ) {
        this.transactionLogRepository = transactionLogRepository;
        this.userRepository = userRepository;
    }

    @Override
    public TransactionLog addTransaction(Long userId, TransactionLog log) {

        User user = userRepository.findById(userId)
                .orElseThrow(() ->
                        new BadRequestException("User not found with id: " + userId)
                );

        log.setUser(user);
        log.validate();

        return transactionLogRepository.save(log);
    }

    @Override
    public List<TransactionLog> getUserTransactions(Long userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() ->
                        new BadRequestException("User not found with id: " + userId)
                );

        return transactionLogRepository.findByUser(user);
    }
}
