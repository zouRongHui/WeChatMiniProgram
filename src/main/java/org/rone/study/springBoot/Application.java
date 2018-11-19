package org.rone.study.springBoot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("org.rone.study.springBoot.mapper")
//@EnableScheduling
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		System.out.println("------------------------------------------------------------------------------------------");
		System.out.println("==========================================================================================");
		System.out.println("----------------------------------------程序已启动----------------------------------------");
		System.out.println("==========================================================================================");
		System.out.println("------------------------------------------------------------------------------------------");
	}
}
