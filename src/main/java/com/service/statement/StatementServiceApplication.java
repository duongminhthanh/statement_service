package com.service.statement;

import com.service.statement.config.AuthFilter;
import com.service.statement.constant.APIConstant;
import org.mindrot.jbcrypt.BCrypt;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.ApplicationContext;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@SpringBootApplication
@MapperScan(basePackages = {"com.service.statement.mapper", "com.service.statement.common.mapper"})
@EnableEncryptableProperties
public class StatementServiceApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(StatementServiceApplication.class, args);
//        String hashedPassword = BCrypt.hashpw("123456", BCrypt.gensalt(10));
//        System.out.println("password: " + hashedPassword);
    }

//    @Bean
//    public FilterRegistrationBean<CorsFilter> corsFilter() {
//        FilterRegistrationBean<CorsFilter> registrationBean = new FilterRegistrationBean<>();
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        CorsConfiguration config = new CorsConfiguration();
//        config.addAllowedOrigin("*");
//        config.addAllowedHeader("*");
//        source.registerCorsConfiguration("/**", config);
//        registrationBean.setFilter(new CorsFilter(source));
//        registrationBean.setOrder(0);
//        return registrationBean;
//    }

    @Bean
    public FilterRegistrationBean<AuthFilter> filterRegistrationBean() {
        FilterRegistrationBean<AuthFilter> registrationBean = new FilterRegistrationBean<>();
        AuthFilter authFilter = new AuthFilter();
        registrationBean.setFilter(authFilter);
        registrationBean.addUrlPatterns(APIConstant.API_DEPARTMENT + "/*");
        registrationBean.addUrlPatterns(APIConstant.API_GROUP + "/*");
        registrationBean.addUrlPatterns(APIConstant.API_USER + "/*");
        registrationBean.addUrlPatterns(APIConstant.API_IMPORT + "/*");
        registrationBean.addUrlPatterns(APIConstant.API_REPORT + "/*");
        registrationBean.addUrlPatterns(APIConstant.API_DEPARTMENT1 + "/*");
        return registrationBean;
    }

}
