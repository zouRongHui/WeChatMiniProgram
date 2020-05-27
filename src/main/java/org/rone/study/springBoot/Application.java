package org.rone.study.springBoot;

import org.mybatis.spring.annotation.MapperScan;
import org.rone.study.springBoot.filter.FirstFilter;
import org.rone.study.springBoot.filter.SecondFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("org.rone.study.springBoot.mapper")
//@EnableScheduling
//通过注解注册Servlet、Filter、Listener
@ServletComponentScan
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		System.out.println("------------------------------------------------------------------------------------------");
		System.out.println("==========================================================================================");
		System.out.println("----------------------------------------程序已启动----------------------------------------");
		System.out.println("==========================================================================================");
		System.out.println("------------------------------------------------------------------------------------------");
	}

//	/**
//	 * 通过配置类注册filter
//	 * @Author Rone    2020/1/9
//	 * @return
//	 */
//	@Bean
//	public FilterRegistrationBean registerFirstFilter() {
//		FilterRegistrationBean bean = new FilterRegistrationBean(new FirstFilter());
//		bean.addUrlPatterns("/*");
//		bean.setOrder(1);
//		return bean;
//	}
//
//	/**
//	 * 通过配置类注册filter
//	 * @Author Rone    2020/1/9
//	 * @return
//	 */
//	@Bean
//	public FilterRegistrationBean registerSecondFilter() {
//		FilterRegistrationBean bean = new FilterRegistrationBean(new SecondFilter());
//		bean.addUrlPatterns("/*");
//		bean.setOrder(1);
//		return bean;
//	}
}