package my.lsh.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@EnableDiscoveryClient  // 允许服务被发现
@SpringBootApplication
@MapperScan("my.lsh.springcloud.mapper")
public class SpringcloudDeptProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringcloudDeptProviderApplication.class, args);
    }
}
