package cn.sunshine.generator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * 
 * </p>
 *
 * @author wuj
 * @since 2019年6月17日
 */
@SpringBootApplication
@Slf4j
@ComponentScan(value = { "cn.sunshine.generator" })
public class GeneratorApplication {

	public static void main(String[] args) {

		SpringApplication.run(GeneratorApplication.class, args);
		log.info("GeneratorApplication工程启动");
	}
}
