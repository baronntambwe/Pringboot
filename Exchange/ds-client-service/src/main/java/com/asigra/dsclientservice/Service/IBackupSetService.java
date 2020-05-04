package com.asigra.dsclientservice.Service;

import com.asigra.dsclientservice.model.BackupSet;
import com.asigra.dsclientservice.model.Transaction;

import java.util.List;

public interface IBackupSetService {
    List<BackupSet> allBackupSets();

    List<BackupSet> filterBackupSetsByIdList(List<Long> idList);

    List<BackupSet> filterBackupSets(String content);

    List<Transaction> filterTransactionsOfUser(Long userId);

    List<Transaction> filterTransactionsOfBackupSet(Long backupSetId);

    void saveTransaction(Transaction transaction);

    BackupSet findBackupSetById(Long backupSetId);
}