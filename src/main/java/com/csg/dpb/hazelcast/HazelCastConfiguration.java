package com.csg.dpb.hazelcast;

import com.hazelcast.config.Config;
import com.hazelcast.config.NetworkConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HazelcastConfiguration {

    @Autowired
    HazelcastMemberSettings applicationSettings;

    public HazelcastConfiguration() {
    }

    @Bean
    public HazelcastInstance createMember() {
        Config config = new Config();
        setupNetworkConfig(config);
        setupGroupConfig(config);
        return Hazelcast.newHazelcastInstance(config);
    }

    public void setupNetworkConfig(Config config) {
        NetworkConfig networkConfig = config.getNetworkConfig();

        networkConfig.setPort(applicationSettings.getPort());
        networkConfig.setPortAutoIncrement(false);

        networkConfig.getJoin().getMulticastConfig().setEnabled(false);

        networkConfig.getJoin().getTcpIpConfig().setEnabled(true);
        networkConfig.getJoin().getTcpIpConfig().addMember(applicationSettings.getIp());
    }

    public void setupGroupConfig(Config config) {
        config.getGroupConfig().setName("dev").setPassword("dev-pass");
    }
}