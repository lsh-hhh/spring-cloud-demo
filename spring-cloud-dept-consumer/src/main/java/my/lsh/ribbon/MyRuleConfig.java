package my.lsh.ribbon;

import com.netflix.loadbalancer.IRule;
import my.lsh.ribbon.customization.CustomizedRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyRuleConfig {

    @Bean
    public IRule myRule(){
//        return new RandomRule();
        return new CustomizedRule();
    }
}
