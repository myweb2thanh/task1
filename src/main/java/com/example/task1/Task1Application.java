package com.example.task1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Task1Application {

	public static void main(String[] args) {
		SpringApplication.run(Task1Application.class, args);
		System.out.println("=".repeat(60));
		System.out.println(" Ứng dụng đã khởi động thành công!");
		System.out.println("Truy cập ứng dụng tại: http://localhost:8080/users");
		System.out.println("Truy cập H2 Console tại: http://localhost:8080/h2-console");
		System.out.println("thông tin kết nối H2:");
		System.out.println("   - JDBC URL: jdbc:h2:mem:testdb");
	}
}
