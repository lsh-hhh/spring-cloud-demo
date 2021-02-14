package my.lsh.springcloud.sevice;

import feign.hystrix.FallbackFactory;
import my.lsh.springcloud.entity.DeptEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DeptClientFallbackFactory implements FallbackFactory<DeptClientService> {
    @Override
    public DeptClientService create(Throwable throwable) {
        return new DeptClientService() {
            @Override
            public DeptEntity find(Long id) {
                return new DeptEntity().setId(id).setName("无id为" + id + "的记录").setDataSource("NONE");
            }

            @Override
            public List<DeptEntity> findAll() {
                return new ArrayList<>();
            }

            @Override
            public Boolean add(DeptEntity deptEntity) {
                return false;
            }

            @Override
            public Object discoveryInfo() {
                return "找不到记录！";
            }

            @Override
            public Object eureka() {
                return "找不到记录！";
            }
        };
    }
}
