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
// 공통 응답 형식을 사용한다면 "@EnableCommonApiResponse" 어노테이션을 활용하고 아니면 뺀다. 빼면 그냥 응답나감.
@EnableCommonApiResponse
@ConfigurationPropertiesScan
@SpringBootApplication
public class BlacklabelApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlacklabelApplication.class, args);
	}

}
