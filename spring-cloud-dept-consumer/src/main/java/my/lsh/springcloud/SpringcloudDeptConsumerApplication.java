package my.lsh.springcloud;

import my.lsh.ribbon.MyRuleConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@EnableEurekaClient
@SpringBootApplication
@RibbonClient(name="SPRING-CLOUD-DEPT-PROVIDER", configuration = MyRuleConfig.class)
public class SpringcloudDeptConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringcloudDeptConsumerApplication.class, args);
    }
}
