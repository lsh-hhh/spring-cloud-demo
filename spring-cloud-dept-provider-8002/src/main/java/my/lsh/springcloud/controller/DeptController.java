package my.lsh.springcloud.controller;


import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Applications;
import lombok.extern.slf4j.Slf4j;
import my.lsh.springcloud.entity.DeptEntity;
import my.lsh.springcloud.service.DeptServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/dept")
public class DeptController {
    @Autowired
    private DeptServiceI deptService;
    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    private EurekaClient eurekaClient;

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public DeptEntity find(@PathVariable("id") Long id){
        DeptEntity deptEntity = deptService.find(id);
        if(deptEntity == null){
            throw new RuntimeException();
        }
        return deptEntity;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<DeptEntity> findAll(){
        return deptService.findAll();
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Boolean add(@RequestBody DeptEntity deptEntity){
        return deptService.add(deptEntity);
    }

    @RequestMapping("/discoveryInfo")
    public Object discoveryInfo(){
        log.info("服务描述" + discoveryClient.description());

        List<String> services = discoveryClient.getServices();
        log.info("eureka的所有服务" + services.toString());

        List<ServiceInstance> instances = discoveryClient.getInstances(services.get(0));
        discoveryClient.toString();

        instances.forEach(i -> {
            log.info("INSTANCE_ID: " + i.getInstanceId() + "\t" + "SERVICE_ID: " + i.getServiceId() + "\t" + "HOST: " + i.getHost() + "\t" + i.getUri());
        });
        return instances;
    }

    @RequestMapping("/eureka")
    public Object eureka(){
        Applications applications = eurekaClient.getApplications();

        List<InstanceInfo> instances = eurekaClient.getInstancesById("spring-cloud-dept-provider-8001");
        instances.forEach(i -> {
            log.info("instanceId: " + i.getInstanceId() + "\t" + "AppName: " + i.getAppName() + "\t" + "IPAddr: " + i.getIPAddr() );
        });

        return instances.toString();
    }
}
