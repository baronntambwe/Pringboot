package com.asigra.dsclientservice.repository;

import com.asigra.dsclientservice.model.BackupSet;

import java.util.List;

public interface IBackupSetRepository extends IGenericDao<BackupSet> {
    List<BackupSet> filterBackupSets(String text);

    List<BackupSet> filterBackupSetsByIdList(List<Long> idList);
}

