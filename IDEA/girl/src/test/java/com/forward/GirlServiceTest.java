package com.forward;

import com.forward.domain.Girl;
import com.forward.service.GirlService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GirlServiceTest {
    @Autowired
    private GirlService girlService;

    @Test
    public void findOneTest(){
        Optional<Girl> one = girlService.findOne(1);
        Girl girl = one.get();
        Assert.assertEquals(new Integer(18),girl.getAge());
        //Assert.assertEquals(new Integer(11),girl.getAge());
    }
}
