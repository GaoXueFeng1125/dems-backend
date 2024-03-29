package edu.sugon.demsbackend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("edu.sugon.demsbackend.dao")
public class DemsBackendApplication {

	public static void main(String[] args) {

		SpringApplication.run(DemsBackendApplication.class, args);
	}

}



