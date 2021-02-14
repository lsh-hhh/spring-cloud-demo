package my.lsh.springcloud.mapper;

import my.lsh.springcloud.entity.DeptEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DeptMapper {
    Boolean add(DeptEntity deptEntity);

    DeptEntity find(Long id);

    List<DeptEntity> findAll();
}
