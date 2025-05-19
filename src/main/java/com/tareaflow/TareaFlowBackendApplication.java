package com.tareaflow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.tareaflow")
public class TareaFlowBackendApplication {
    public static void main(String[] args) {
        SpringApplication.run(TareaFlowBackendApplication.class, args);
    }
}
