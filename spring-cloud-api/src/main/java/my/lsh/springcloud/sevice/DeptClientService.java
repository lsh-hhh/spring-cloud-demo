package my.lsh.springcloud.sevice;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import my.lsh.springcloud.entity.DeptEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(value = "SPRING-CLOUD-DEPT-PROVIDER", fallbackFactory = DeptClientFallbackFactory.class)
@RequestMapping("/dept")
public interface DeptClientService {
    @RequestMapping("/get/{id}")
    DeptEntity find(@PathVariable("id") Long id);

    @RequestMapping("/list")
    List<DeptEntity> findAll();

    @RequestMapping("/add")
    Boolean add(DeptEntity deptEntity);

    @RequestMapping("/discoveryInfo")
    Object discoveryInfo();

    @RequestMapping("/eureka")
    Object eureka();
}
