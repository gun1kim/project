package com.example.practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class PracticeApplication {
// EC2 인스턴스 메타데이터에 엑서스하여 인증 정보를 자동으로 가져오는 기능
//	static {
//		System.setProperty("com.amazonaws.sdk.disableEc2Metadata", "true");
//	}
	public static void main(String[] args) {
		SpringApplication.run(PracticeApplication.class, args);
	}

}
