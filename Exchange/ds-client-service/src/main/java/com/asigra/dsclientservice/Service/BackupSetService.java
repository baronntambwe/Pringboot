package com.asigra.dsclientservice.Service;

import com.asigra.dsclientservice.model.BackupSet;
import com.asigra.dsclientservice.model.Transaction;
import com.asigra.dsclientservice.repository.BackupSetRepository;
import com.asigra.dsclientservice.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BackupSetService implements IBackupSetService {

    @Autowired
    private BackupSetRepository backupSetRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public List<BackupSet> allBackupSets() {
        return backupSetRepository.findAll();
    }

    @Override
    public List<BackupSet> filterBackupSetsByIdList(final List<Long> idList){
        return backupSetRepository.filterBackupSetsByIdList(idList);
    }

    @Override
    public List<BackupSet> filterBackupSets(final String content) {
        return backupSetRepository.filterBackupSets(content);
    }

    @Override
    public List<Transaction> filterTransactionsOfUser(final Long userId){
        return transactionRepository.findAllTransactionsOfUser(userId);
    }

    @Override
    public List<Transaction> filterTransactionsOfBackupSet(final Long backupSetId){
        return transactionRepository.findAllTransactionsOfBackupSet(backupSetId);
    }

    @Override
    public void saveTransaction(final Transaction transaction){
        transactionRepository.save(transaction);
    }

    @Override
    public BackupSet findBackupSetById(Long backupSetId){
        return backupSetRepository.find(backupSetId);
    }
}