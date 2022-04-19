package com.yuqi.alumnisystem;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author yuexi.guo
 * @date 2022/4/19 18:57
 */
@SpringBootApplication
@MapperScan("com.yuqi.alumnisystem.mapper")
@Slf4j
public class AlumniSystemApplication {

    public static void main(String[] args) throws UnknownHostException {
        ApplicationContext ctx = SpringApplication.run(AlumniSystemApplication.class, args);
        Environment env = ctx.getEnvironment();
        String[] activeProfiles = env.getActiveProfiles();
        log.info("profiles.size {}", activeProfiles.length);
        log.info(
                "\n----------------------------------------------------------\n\t"
                        + "Application '{}' is running! Access URLs:\n\t"
                        + "Local: \t\thttp://localhost:{}\n\t"
                        + "External: \thttp://{}:{}\n\t"
                        + "Swagger : \thttp://{}:{}/swagger-ui.html#/\n\t",
                env.getProperty("spring.application.name"), env.getProperty("server.port"),
                InetAddress.getLocalHost().getHostAddress(), env.getProperty("server.port"), InetAddress.getLocalHost().getHostAddress(), env.getProperty("server.port"));
    }

}
