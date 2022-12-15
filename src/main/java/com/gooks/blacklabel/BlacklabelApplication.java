package com.gooks.blacklabel;

import com.gooks.blacklabel.common.aop.custom.annotation.EnableCommonApiResponse;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

/**
* @package : com.gooks.blacklabel.blacklabel
* @name : BlacklabelApplication.java
* @date : 2022-12-14 오전 10:21
* @author : Jung Jae gook
* @version : 1.0.0
* @modifyed :
* @description : 샘플프로젝트
**/
@EnableCommonApiResponse // 공통 응답 형식 사용
@ConfigurationPropertiesScan
@SpringBootApplication
public class BlacklabelApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlacklabelApplication.class, args);
	}

}
