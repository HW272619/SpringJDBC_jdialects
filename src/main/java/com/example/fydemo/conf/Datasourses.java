package com.example.fydemo.conf;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "spring.datasource")
public class Datasourses {
    private String driver_class_name;
    private String jdbc_url;
    private String username;
    private String password;

}
