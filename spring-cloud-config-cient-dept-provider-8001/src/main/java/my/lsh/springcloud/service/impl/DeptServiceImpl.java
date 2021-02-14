package my.lsh.springcloud.service.impl;

import my.lsh.springcloud.entity.DeptEntity;
import my.lsh.springcloud.mapper.DeptMapper;
import my.lsh.springcloud.service.DeptServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("deptService")
public class DeptServiceImpl implements DeptServiceI {
    @Autowired
    private DeptMapper deptMapper;
    @Override
    public Boolean add(DeptEntity deptEntity) {
        return deptMapper.add(deptEntity);
    }

    @Override
    public DeptEntity find(Long id) {
        return deptMapper.find(id);
    }

    @Override
    public List<DeptEntity> findAll() {
        return deptMapper.findAll();
    }
}
