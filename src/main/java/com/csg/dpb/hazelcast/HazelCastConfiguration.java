package com.csg.dpb.hazelcast;

import com.hazelcast.config.Config;
import com.hazelcast.config.NetworkConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashSet;
import java.util.Set;

@Configuration
public class HazelcastConfiguration {

    @Autowired
    HazelcastSettings hazelcastSettings;


    public HazelcastConfiguration() {
    }

    @Bean(name = "ClusterMember", destroyMethod = "shutdown")
    public HazelcastInstance createMember() {
        Config config = new Config();
        config.setProperty("hazelcast.socket.bind.any", "false");

        Set<String> trustedInterfaces = new HashSet<>();
        trustedInterfaces.add(hazelcastSettings.getIp());

        NetworkConfig networkConfig = config.getNetworkConfig();

        networkConfig.setPort(hazelcastSettings.getPort());
        networkConfig.setPortAutoIncrement(false);

        networkConfig.getJoin().getMulticastConfig().setEnabled(false);

        networkConfig.getJoin().getTcpIpConfig().setEnabled(true);
        networkConfig.getJoin().getTcpIpConfig().addMember(hazelcastSettings.getIp());


        HazelcastInstance hazelcastInstance = Hazelcast.newHazelcastInstance(config);

        return hazelcastInstance;
    }

}