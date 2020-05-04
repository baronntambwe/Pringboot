package com.asigra.dsclientservice.intercomm;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient("plug-in-service")
public interface PlugInClient {

    @RequestMapping(method = RequestMethod.GET, value = "/service/data", consumes = "application/json")
    List<Long> getBackupData();
}