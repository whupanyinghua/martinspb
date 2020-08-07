package com.martin.spb.autoconfigure.configuration;

import com.martin.spb.autoconfigure.properties.MartinProperties;
import com.martin.spb.autoconfigure.service.MartinService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 类MartinAutoCOnfiguration的实现描述：autoconfig入口
 *
 * @author panyinghua 2020-8-7 14:43
 */
@Configuration
@ConditionalOnProperty(value = "martin.test.enable", havingValue = "true")
@EnableConfigurationProperties(MartinProperties.class)
public class MartinAutoConfiguration {

    @Bean
    public MartinService martinService(MartinProperties martinProperties) {
        return new MartinService(martinProperties.getNames());
    }
}
