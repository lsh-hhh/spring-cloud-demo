package my.lsh.springcloud.controller;

import com.netflix.ribbon.proxy.annotation.Hystrix;
import my.lsh.springcloud.entity.DeptEntity;
import my.lsh.springcloud.sevice.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/consumer/dept")
public class DeptConsumerController {
    @Autowired
    private DeptClientService deptClientService;

    @RequestMapping("/get/{id}")
    public DeptEntity find(@PathVariable("id") Long id){
        return deptClientService.find(id);
    }

    @RequestMapping("/list")
    public List<DeptEntity> findAll(){
        return deptClientService.findAll();
    }

    @RequestMapping("/add")
    public Boolean add(DeptEntity deptEntity){
        return deptClientService.add(deptEntity);
    }

    @RequestMapping("/discovery")
    public Object discovery(){
        return deptClientService.discoveryInfo();
    }
}
