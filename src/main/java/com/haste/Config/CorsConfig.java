package com.haste.Config;

/**
 * @Author: 臧立昆
 * @Email: 740969606@qq.com
 * @Date: 2020/8/3
 * @Time: 13:47
 */

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Configuration
public class CorsConfig extends WebMvcConfigurerAdapter {



    @Override

    public void addCorsMappings(CorsRegistry registry) {

        registry.addMapping("/**")

                .allowedOrigins("*")

                .allowCredentials(true)

                .allowedMethods("GET", "POST", "DELETE", "PUT")

                .maxAge(3600);

    }



}