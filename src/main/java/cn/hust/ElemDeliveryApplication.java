package cn.hust;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ElemDeliveryApplication {

	public static void main(String[] args) {

		SpringApplication.run(ElemDeliveryApplication.class, args);
	}

}
