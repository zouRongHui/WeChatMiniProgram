package com.rone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author rone
 */
@SpringBootApplication
@ServletComponentScan
@EnableScheduling
public class ServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceApplication.class, args);
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("==========================================================================================");
        System.out.println("----------------------------------------程序已启动----------------------------------------");
        System.out.println("==========================================================================================");
        System.out.println("------------------------------------------------------------------------------------------");
    }
}
