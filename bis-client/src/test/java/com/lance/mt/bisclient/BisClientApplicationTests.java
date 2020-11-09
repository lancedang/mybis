package com.lance.mt.bisclient;


import com.lance.mt.bisservicefacade.pboc.PbocRequest;
import com.lance.mt.bisservicefacade.pboc.PbocResponse;
import com.lance.mt.bisservicefacade.pboc.PbocService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class BisClientApplicationTests {

    @Autowired
    private PbocService pbocService;

    @Test
    public void test() {
        PbocRequest pbocRequest = new PbocRequest();
        pbocRequest.setAppNo("111");
        pbocRequest.setQueryType("query");

        PbocResponse pbocResponse = pbocService.queryPbocByIdNo(pbocRequest);
        System.out.println(pbocResponse.getData());
    }

}
