package cn.raincoding;

import cn.raincoding.annotation.MyScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MyScan(basePackage = "cn.raincoding")
@SpringBootApplication
public class HelloSpringCustomAnnotationApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloSpringCustomAnnotationApplication.class, args);
	}

}
