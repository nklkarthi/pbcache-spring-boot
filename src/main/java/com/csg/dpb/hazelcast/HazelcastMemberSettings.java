package com.csg.dpb.hazelcast;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created by nklkarthi on 9/7/16.
 */
@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "hazelcast-settings")
public class HazelcastMemberSettings {

    private String ip;

    private int port;

    /**
     * @return Gets the value of ip and returns ip
     */
    public String getIp() {
        return ip;
    }

    /**
     * Sets the ip
     * You can use getIp() to get the value of ip
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * @return Gets the value of port and returns port
     */
    public int getPort() {
        return port;
    }

    /**
     * Sets the port
     * You can use getPort() to get the value of port
     */
    public void setPort(int port) {
        this.port = port;
    }
}
