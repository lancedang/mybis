package com.lance.mt.bisserviceimpl;

import com.lance.mt.bisservicefacade.pboc.PbocService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class BisServiceImplApplicationTests {

    @Autowired
    private PbocService pbocService;

    @Test
    public void contextLoads() {
        Assert.assertNotNull(pbocService);
    }

}
