package my.lsh.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@EnableDiscoveryClient
@SpringBootApplication
public class SpringcloudConfigClientDeptProvider_8001 {
    public static void main(String[] args) {
        SpringApplication.run(SpringcloudConfigClientDeptProvider_8001.class, args);
    }
}
