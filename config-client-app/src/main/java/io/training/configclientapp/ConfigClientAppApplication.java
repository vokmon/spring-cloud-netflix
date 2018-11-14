package io.training.configclientapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableDiscoveryClient
@SpringBootApplication
@RestController
public class ConfigClientAppApplication {

    @Autowired
    private ConfigClientAppConfiguration properties;

    @Value("${some.other.property}")
    private String someOtherPrperty;

    public static void main(String[] args) {
        SpringApplication.run(ConfigClientAppApplication.class, args);
    }

    @RequestMapping("/")
    public String printConfig() {
        StringBuilder sb = new StringBuilder();
        sb.append(properties.getProperty());
        sb.append("||");
        sb.append(someOtherPrperty);
        return sb.toString();
    }
}
