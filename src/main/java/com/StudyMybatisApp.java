package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xxp.HelloWorld;

@RestController
@EnableAutoConfiguration
public class StudyMybatisApp implements Runnable {

	private String name;

	public StudyMybatisApp(String name) {
		this.name = name;
	}

	@RequestMapping(value = "/")
	String home() {
		return "helloworld";
	}

	public static void main(String[] args) {
		// SpringApplication.run(StudyMybatisApp.class, args);
		// new
		// SpringApplicationBuilder().showBanner(false).sources(StudyMybatisApp.class).run(args);
//		System.out.println("hello world".indexOf("hello"));
		HelloWorld helloWorld = new HelloWorld();
		helloWorld.sayHello();
		StudyMybatisApp studyMybatisApp1 = new StudyMybatisApp("aa");
		StudyMybatisApp studyMybatisApp2 = new StudyMybatisApp("bb");
		studyMybatisApp1.run();
		for (int i = 0; i < 5; i++) {
			System.out.println(i);
		}
//		studyMybatisApp2.run();

	}

	public void run() {
		System.out.println(name);
		for (int i = 0; i < 5; i++) {
			System.out.println(i);
		}
	}

}
