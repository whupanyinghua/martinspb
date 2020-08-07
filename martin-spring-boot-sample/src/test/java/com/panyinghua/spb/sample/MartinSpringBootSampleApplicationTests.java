package com.panyinghua.spb.sample;

import com.martin.spb.autoconfigure.service.MartinService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MartinSpringBootSampleApplicationTests {

    @Autowired(required = false)
    private MartinService martinService;

    @Test
    void contextLoads() {
    }

    @Test
    public void testMartinService() {
        martinService.hello();
    }

}
