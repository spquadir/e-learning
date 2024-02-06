package com.example.foodrecipie.service;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Scanner;

@Service
public class DataSetupService {

    @Autowired
    private EntityManager entityManager;

    @Transactional
    public void executeSqlFile() throws Exception {
        Resource resource = new ClassPathResource("sample_data.sql");
        try (Scanner scanner = new Scanner(resource.getInputStream())) {
            while (scanner.hasNextLine()) {
                String sql = scanner.nextLine().trim();
                if (!sql.isEmpty()) {
                    entityManager.createNativeQuery(sql).executeUpdate();
                }
            }
        }catch (Exception e){
            
        }
    }
}