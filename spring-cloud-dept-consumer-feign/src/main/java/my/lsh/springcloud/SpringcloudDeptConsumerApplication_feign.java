package my.lsh.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableEurekaClient
@EnableFeignClients(basePackages = {"my.lsh.springcloud"})
@SpringBootApplication
public class SpringcloudDeptConsumerApplication_feign {
    public static void main(String[] args) {
        SpringApplication.run(SpringcloudDeptConsumerApplication_feign.class, args);
    }
}
