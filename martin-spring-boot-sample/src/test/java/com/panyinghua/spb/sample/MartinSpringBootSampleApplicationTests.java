package com.panyinghua.spb.sample;

import com.martin.spb.autoconfigure.service.DLockService;
import com.martin.spb.autoconfigure.service.MartinService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeUnit;

@SpringBootTest
class MartinSpringBootSampleApplicationTests {

    @Autowired(required = false)
    private MartinService martinService;

    @Autowired(required = false)
    private DLockService dLockService;

    @Test
    void contextLoads() {
    }

    @Test
    public void testMartinService() {
        martinService.hello();
    }

    @Test
    public void testdLockServiceLock() {
        boolean lockresult = dLockService.lock("sbp-martin-dlock-001", "martin's test lock value", 1000, TimeUnit.SECONDS);
        System.out.println("lock result is :" + lockresult);
    }

    @Test
    public void testdLockServiceUnLock() {
        dLockService.unlock("sbp-martin-dlock-001", "martin's test lock value");
    }

}
