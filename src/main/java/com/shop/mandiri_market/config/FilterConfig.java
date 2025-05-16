package com.shop.mandiri_market.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean<FilterInterceptor> jwtFilter() {
        FilterRegistrationBean<FilterInterceptor> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new FilterInterceptor());
        registrationBean.addUrlPatterns("/api/*"); // hanya endpoint /api yang difilter
        return registrationBean;
    }
}
