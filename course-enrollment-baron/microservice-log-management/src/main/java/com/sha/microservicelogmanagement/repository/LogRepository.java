package com.sha.microservicelogmanagement.repository;


import com.sha.microservicelogmanagement.model.Log;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

public interface LogRepository extends CrudRepository<Log, UUID> {
}
