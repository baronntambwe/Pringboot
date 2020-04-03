package com.sha.microservicelogmanagement.service;

import com.sha.microservicelogmanagement.model.Log;
import com.sha.microservicelogmanagement.model.Summary;

import java.util.List;
import java.util.UUID;

public interface LogService {
    Summary findSummaryByCourseId(Long courseId);

    Log saveOrUpdate(Log log);

    Summary saveOrUpdate(Summary summary);

    List<Summary> findPopularCourses();
}