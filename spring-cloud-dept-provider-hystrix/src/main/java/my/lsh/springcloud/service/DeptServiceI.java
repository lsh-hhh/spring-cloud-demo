package my.lsh.springcloud.service;

import my.lsh.springcloud.entity.DeptEntity;

import java.util.List;

public interface DeptServiceI {

    Boolean add(DeptEntity deptEntity);

    DeptEntity find(Long id);

    List<DeptEntity> findAll();
}
