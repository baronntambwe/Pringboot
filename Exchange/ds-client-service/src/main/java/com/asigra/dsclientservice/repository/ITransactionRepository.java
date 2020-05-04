package com.asigra.dsclientservice.repository;

import com.asigra.dsclientservice.model.Transaction;

import java.util.List;

public interface ITransactionRepository extends IGenericDao<Transaction> {
    List<Transaction> findAllTransactionsOfUser(Long userId);

    List<Transaction> findAllTransactionsOfBackupSet(Long backupSetId);
}
