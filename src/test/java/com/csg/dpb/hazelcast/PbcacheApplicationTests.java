package com.csg.dpb.hazelcast;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = PbcacheApplication.class)
@Profile("unit-test")

public class PbcacheApplicationTests {

    @Test
    public void contextLoads() {
    }

}
