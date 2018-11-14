package io.training.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create service to register to discovery service This is the client of discovery service. Also it
 * is a service to serve others.
 * 
 * @author aruangth
 */
@EnableDiscoveryClient
@SpringBootApplication
@RestController
public class ServiceApplication {

    @Value("${service.instance.name}")
    private String instance;

    public static void main(String[] args) {
        SpringApplication.run(ServiceApplication.class, args);
    }

    @RequestMapping("/")
    public String message() {
        return "Hello from " + instance;
    }
}
