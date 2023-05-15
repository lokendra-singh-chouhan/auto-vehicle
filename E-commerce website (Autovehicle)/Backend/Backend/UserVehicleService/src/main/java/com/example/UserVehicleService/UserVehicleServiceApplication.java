package com.example.UserVehicleService;

import com.example.UserVehicleService.filter.JwtFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class UserVehicleServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserVehicleServiceApplication.class, args);
	}



	@Bean
	public FilterRegistrationBean<JwtFilter> jwtFilter() {
		FilterRegistrationBean<JwtFilter> registrationBean = new FilterRegistrationBean<>();
		registrationBean.setFilter(new JwtFilter());
		registrationBean.addUrlPatterns("/api/v2/user/*");
		registrationBean.setName("jwtFilter");
		registrationBean.setOrder(1);
//		registrationBean.setDisplayName("JWT Authentication Filter");
		return registrationBean;
	}
}
