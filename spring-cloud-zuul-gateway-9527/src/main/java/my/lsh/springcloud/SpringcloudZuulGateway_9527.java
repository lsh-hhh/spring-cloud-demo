package my.lsh.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

//@EnableEurekaClient
//@EnableDiscoveryClient
//@EnableFeignClients
@EnableZuulProxy
@SpringBootApplication
public class SpringcloudZuulGateway_9527 {
    public static void main(String[] args) {
        SpringApplication.run(SpringcloudZuulGateway_9527.class, args);
    }
}
