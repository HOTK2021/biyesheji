package org.cqipc.edu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages="org.cqipc.edu.dao")
public class HadesApplication {

	public static void main(String[] args) {
		SpringApplication.run(HadesApplication.class, args);
	}

}
