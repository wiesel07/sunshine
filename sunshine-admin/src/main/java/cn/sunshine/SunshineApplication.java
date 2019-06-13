package cn.sunshine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import lombok.extern.slf4j.Slf4j;

/**
 * @Description
 * @date 2019年5月27日
 * @author wuj
 * @version V1.0
 */
@SpringBootApplication
@Slf4j
@ComponentScan(value = { "cn.sunshine" })
@EnableAspectJAutoProxy(exposeProxy = true)
public class SunshineApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(SunshineApplication.class, args);
		log.info("SunshineApplication工程启动");
	}
	
}
