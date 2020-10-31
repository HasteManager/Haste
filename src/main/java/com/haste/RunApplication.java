package com.haste;


import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.apache.catalina.connector.Connector;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.Ssl;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.bind.annotation.CrossOrigin;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;


/**
 * 作者：臧立昆
 * 2020/10/9 14:51
 */

@SpringBootApplication
@CrossOrigin
public class RunApplication  {
        public static void main(String[] args) {
        SpringApplication.run(RunApplication.class,args);
    }

    @Bean
    public ServletWebServerFactory servletContainer() {
        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory(){};
        tomcat.addAdditionalTomcatConnectors(createHTTPConnector());
        return tomcat;
    }


    @Bean
    public Connector createHTTPConnector() {
        Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
        //同时启用http（8080）、https（8082）两个端口
        connector.setScheme("http");
        //如果ture 就是Http跳到Http,Https跳到Https
        connector.setSecure(true);
        //Connector监听的http的端口号
        connector.setPort(8688);
        //监听到http的端口号后转向到的https的端口号
        connector.setRedirectPort(8199);
        return connector;
    }
}
