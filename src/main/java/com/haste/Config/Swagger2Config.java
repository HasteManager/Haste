package com.haste.Config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author: 臧立昆
 * @Email: 740969606@qq.com
 * @Date: 2020/7/29
 * @Time: 15:33
 */
@Configuration //配置类
@EnableSwagger2 //启用Swagger2
@EnableKnife4j //开启swagger 新皮肤
public class Swagger2Config {
    @Bean
    public Docket apiConfig() {
        return new Docket(DocumentationType.SWAGGER_2)//创建Swagger2类型的文档
                .apiInfo(apiInfo())
                .groupName("臧立昆")
                .host("HOST");//apiInfo方法返回配置的接口信息
    }

   /* @Bean
    public Docket Group1() {
        return new Docket(DocumentationType.SWAGGER_2)//创建Swagger2类型的文档
                .apiInfo(apiInfo())
                .groupName("Group1")
                .enable(true)
                .host("HOST");//apiInfo方法返回配置的接口信息
    }

    @Bean
    public Docket Group2() {
        return new Docket(DocumentationType.SWAGGER_2)//创建Swagger2类型的文档
                .apiInfo(apiInfo())
                .groupName("Group2")
                .enable(true)
                .host("HOST");//apiInfo方法返回配置的接口信息
    }
*/

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("用户中心微服务前台网站接口")//接口标题
                .description("此文档描述了后台管理中心前台网站的基本API接口")//接口描述
                .version("1.0")//接口版本
                .contact(new Contact("ZLK", "http://www.zanglikun.com", "zanglikun@163.com"))//联系方式：名字、网址、邮箱
                .build();
    }
}