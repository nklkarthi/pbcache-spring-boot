package com.csg.dpb.hazelcast;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class PbcacheApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder()
                .sources(PbcacheApplication.class)
                .run(args);
    }

}
