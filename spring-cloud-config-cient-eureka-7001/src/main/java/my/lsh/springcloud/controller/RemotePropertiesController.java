package my.lsh.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RemotePropertiesController {
    @Value("${spring.application.name}")
    private String appName;
    @Value("${server.port}")
    private Integer port;
    @Value("${eureka.client.service-url.defaultZone}")
    private String eurekaDefaultZone;

    @RequestMapping("/config")
    public String getConfig(){
        StringBuffer sb = new StringBuffer();
        sb.append("applicationName=").append(appName)
                .append("; serverPort=").append(port)
                .append("; eurekaUrl").append(eurekaDefaultZone);
        System.out.println("********configInfo:" + sb.toString());
        return sb.toString();
    }
}
