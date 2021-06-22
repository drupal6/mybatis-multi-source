package com.mybatis.mapper;

import com.mybatis.mapper.main.MainUserMapper;
import com.mybatis.mapper.slave.SlaveUserMapper;
import com.mybatis.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MapperTest {

    @Autowired
    private MainUserMapper mainUserMapper;

    @Autowired
    private SlaveUserMapper slaveUserMapper;

    @Test
    public void testQuery() {
        User mainUser = mainUserMapper.getOne(1l);
        User slaveUser = slaveUserMapper.getOne(1l);
        System.out.println(mainUser.getUserName() + ":" + slaveUser.getUserName());
    }
}
