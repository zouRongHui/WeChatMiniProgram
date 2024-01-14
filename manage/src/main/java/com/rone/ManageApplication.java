package com.rone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * @author rone
 */
@SpringBootApplication
@ServletComponentScan
public class ManageApplication {
    public static void main(String[] args) {
        SpringApplication.run(ManageApplication.class, args);
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("==========================================================================================");
        System.out.println("-------------------------------------- 管理后台，启动 --------------------------------------");
        System.out.println("==========================================================================================");
        System.out.println("------------------------------------------------------------------------------------------");
    }
}
