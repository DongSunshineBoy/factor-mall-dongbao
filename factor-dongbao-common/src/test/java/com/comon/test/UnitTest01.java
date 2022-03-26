package com.comon.test;

import com.dwt.entity.PUserEntity;
import com.dwt.service.PUserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author: wenTaoDong
 * @Date: 2022/3/6 03-06 22:33
 * @Description: com.comon.test
 * @Version 1.0
 */
@SpringBootTest
public class UnitTest01 {

    @Autowired
    PUserService pUserService;

    @Test
    public void test01() {

        PUserEntity pUserEntity = new PUserEntity();
        pUserEntity.setPAge(12);
        pUserEntity.setPName("张三");
        pUserService.save(pUserEntity);
    }
}
