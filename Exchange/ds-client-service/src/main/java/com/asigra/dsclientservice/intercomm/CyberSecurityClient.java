package com.asigra.dsclientservice.intercomm;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient("cyber-security-service")
public interface CyberSecurityClient {

    @RequestMapping(method = RequestMethod.GET, value = "/service/config", consumes = "application/json")
    List<Long> getSecurityConfig();
}