package com.asigra.dsclientservice.repository;

import com.asigra.dsclientservice.model.BackupSet;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.List;

@Transactional
@Repository
public class BackupSetRepository extends AbstractGenericDao<BackupSet> implements IBackupSetRepository {

    @Override
    public List<BackupSet> filterBackupSets(final String text){
        String hql = "Select c from BackupSet c where 1=1 ";
        if(text!=null && !"".equals(text.trim())){
            hql+="AND (lower(c.name) like lower(:pText) or lower(c.description) like lower(:pText)" +
                    "like lower(:pText))";
        }
        Query query = em.createQuery(hql);
        if(text!=null && !"".equals(text.trim())){
            query.setParameter("pText","%"+text+"%");
        }
        return query.getResultList();
    }

    @Override
    public List<BackupSet> filterBackupSetsByIdList(final List<Long> idList){
        String hql = "Select c from BackupSet c where c.id in (:pIdList)";
        Query query = em.createQuery(hql);
        query.setParameter("pIdList", idList);
        return query.getResultList();
    }
}
