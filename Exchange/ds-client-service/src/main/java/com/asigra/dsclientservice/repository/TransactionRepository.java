package com.asigra.dsclientservice.repository;

import com.asigra.dsclientservice.model.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.List;

@Transactional
@Repository
public class TransactionRepository extends AbstractGenericDao<Transaction> implements ITransactionRepository{

    @Override
    public List<Transaction> findAllTransactionsOfUser(final Long userId){
        String hql="Select t from Transaction t Where t.userId = :pUserId";
        Query query = em.createQuery(hql);
        query.setParameter("pUserId",userId);
        return query.getResultList();
    }

    @Override
    public List<Transaction> findAllTransactionsOfBackupSet(final Long backupSetId){
        String hql = "Select t from Transaction t Where t.backupSet.id = :pBackupSetId";
        Query query = em.createQuery(hql);
        query.setParameter("pBackupSetId", backupSetId);
        return query.getResultList();
    }

}