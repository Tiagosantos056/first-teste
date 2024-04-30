package com.example.teste.config;

import com.example.teste.services.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig {

    @Autowired
    private DBService dbService;


    public void instanciaDB() {
        this.dbService.instanciaDB();
    }
}
