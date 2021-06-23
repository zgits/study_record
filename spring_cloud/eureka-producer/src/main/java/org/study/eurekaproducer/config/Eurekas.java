package org.study.eurekaproducer.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author
 * @date 2021年06月23日 23:02
 * @description
 */
@Component
@ConfigurationProperties(prefix = "eurekas")
public class Eurekas {


    private String user;
    private String password;


    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
