package my.lsh.springcloud.controller;

import my.lsh.springcloud.entity.DeptEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/consumer/dept")
public class DeptConsumerController {
    @Autowired
    private RestTemplate restTemplate;
    // public final String BASE_URL = "http://localhost:8001";
    public final String BASE_URL = "http://SPRING-CLOUD-DEPT-PROVIDER";

    @RequestMapping("/get/{id}")
    public DeptEntity find(@PathVariable("id") Long id){
        String url = BASE_URL + "/dept/get/" + id;
        return restTemplate.getForObject(url, DeptEntity.class);
    }

    @RequestMapping("/list")
    public List<DeptEntity> findAll(){
        String url = BASE_URL + "/dept/list";
        return restTemplate.getForObject(url, List.class);
    }

    @RequestMapping("/add")
    public Boolean add(DeptEntity deptEntity){
        String url = BASE_URL + "/dept/add";
        return restTemplate.postForObject(url, deptEntity, Boolean.class);
    }

    @RequestMapping("/discovery")
    public Object discovery(){
        String url = BASE_URL + "/dept/discoveryInfo";
        Object result = restTemplate.getForObject(url, Object.class);
        return result;
    }
}
