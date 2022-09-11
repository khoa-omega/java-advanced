package com.vti.configuration;

import com.vti.utils.HibernateUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DIContainer {
    @Bean
    public HibernateUtils provideHibernateUtils() {
        return new HibernateUtils();
    }
}
