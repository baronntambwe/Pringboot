package com.asigra.dsclientservice.Controller;

import com.asigra.dsclientservice.Service.BackupSetService;
import com.asigra.dsclientservice.intercomm.CyberSecurityClient;
import com.asigra.dsclientservice.intercomm.LogClient;
import com.asigra.dsclientservice.intercomm.PlugInClient;
import com.asigra.dsclientservice.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.core.env.Environment;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/service")
public class BackupSetController {

    @Autowired
    private PlugInClient plugInClient;

    @Autowired
    private CyberSecurityClient cyberSecurityClient;

    @Autowired
    private LogClient logClient;

    @Autowired
    private BackupSetService backupSetService;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private Environment env;

    @Value("${spring.application.name}")
    private String serviceId;

    @GetMapping("/service/port")
    public String getPort(){
        return "Service is working at port : " + env.getProperty("local.server.port");
    }

    @GetMapping("/service/instances")
    public ResponseEntity<?> getInstances() {
        return ResponseEntity.ok(discoveryClient.getInstances(serviceId));
    }

    @PostMapping("/backupset")
    public ResponseEntity<?> filterTransactions(@RequestBody Long userId){
        return new ResponseEntity<>(backupSetService.filterTransactionsOfUser(userId), HttpStatus.OK);
    }

    @GetMapping("/popular")
    public ResponseEntity<?> popularBackupSets(){
        List<Long> popularIdList = logClient.getPopularBackupSets();
        if(popularIdList==null || popularIdList.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity<>(backupSetService.filterBackupSetsByIdList(popularIdList), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<?> allBackupSets(){
        return new ResponseEntity<>(backupSetService.allBackupSets(), HttpStatus.OK);
    }

    @PostMapping("/filter")
    public ResponseEntity<?> filterBackupSets(@RequestBody String text){
        return new ResponseEntity<>(backupSetService.filterBackupSets(text), HttpStatus.OK);
    }

    @PostMapping("/operations")
    public ResponseEntity<?> saveTransaction(@RequestBody Transaction transaction){
        transaction.setDateOfOperation(LocalDateTime.now());
        transaction.setBackupSet(backupSetService.findBackupSetById(transaction.getBackupSet().getId()));
        backupSetService.saveTransaction(transaction);
        return ResponseEntity.ok(transaction);
    }


}