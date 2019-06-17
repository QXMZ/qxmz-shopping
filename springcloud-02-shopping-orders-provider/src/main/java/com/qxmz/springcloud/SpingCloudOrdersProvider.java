package com.qxmz.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@MapperScan("com.qxmz.springcloud.dao") //设置mybatis接口的位置
@EnableEurekaClient
public class SpingCloudOrdersProvider {

	public static void main(String[] args) {
		SpringApplication.run(SpingCloudOrdersProvider.class, args);
	}
}
