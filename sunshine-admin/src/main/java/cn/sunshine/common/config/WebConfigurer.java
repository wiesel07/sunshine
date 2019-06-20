package cn.sunshine.common.config;

import java.io.IOException;
import java.math.BigInteger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

/**
 * <p>
 * WebMvcConfigurer实现类
 * </p>
 *
 * @author wuj
 * @since 2019年6月20日
 */
@Configuration
public class WebConfigurer implements WebMvcConfigurer {

	@Bean
	@Primary
//	wuj 配置类中有两个Computer类的bean，一个是笔记本电脑，一个是备用电脑。如果当前容器中已经有电脑bean了，就不注入备用电脑，如果没有，则注入备用电脑，这里需要使用到@ConditionalOnMissingBean。
//	@ConditionalOnMissingBean(ObjectMapper.class)
	public ObjectMapper jacksonObjectMapper(Jackson2ObjectMapperBuilder builder) {
		ObjectMapper objectMapper = builder.createXmlMapper(false).build();
		/**
		 * 前端long丢失问题
		 */
		SimpleModule module = new SimpleModule();
		module.addSerializer(Long.class, ToStringSerializer.instance);
		module.addSerializer(Long.TYPE, ToStringSerializer.instance);
		module.addSerializer(BigInteger.class, ToStringSerializer.instance);
		objectMapper.registerModule(module);
		objectMapper.getSerializerProvider().setNullValueSerializer(new JsonSerializer<Object>() {

			@Override
			public void serialize(Object value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
				// TODO Auto-generated method stub
				gen.writeString("");
			}
		});
		return objectMapper;
	}
}
