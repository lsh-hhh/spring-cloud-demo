package my.lsh.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class SpringcloudEureka_7002 {
    public static void main(String[] args) {
        SpringApplication.run(SpringcloudEureka_7002.class, args);
    }
}
