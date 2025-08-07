package com.deliverytech.delivery.entity;

import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Map;

// import org.apache.catalina.core.ApplicationFilterConfig;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class HealthController {

    @GetMapping("/health")
    public Map<String, String> health(){
        return Map.of(
            "status", "UP",
            "timestamp", LocalDateTime.now().toString(),
            "service", "Delivery API",
            "JavaVersion", System.getProperty("java.version")
        );
    }

    @GetMapping("/info")
    public AppInfo info(){
        return new AppInfo(
            "Delivery Tech API",
            "1.0.0",
            "Luiz Henrique",
            "JDK 21",
            "Spring boot 3.5.4"
        );
    }

    public record AppInfo(
        String application,
        String version,
        String developer,
        String javaVersion,
        String framework
    ){}
    








}
