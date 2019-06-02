package cn.sunshine.component.redis.config;

import java.lang.reflect.Method;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;

import com.alibaba.fastjson.JSON;

/**
 * <p>
 * 
 * </p>
 *
 * @author wuj
 * @since 2019年5月29日
 */
@Configuration
@ConditionalOnClass(CacheConfig.class)
@EnableCaching
public class RedisCacheConfig {

	String prefix = ""; // RedisConstant.CACHE_NAMESPACE + "M";

	/**
	 * 
	 * @Title: keyGenerator
	 * @Description:设置key生成策略
	 * @return
	 *
	 * @date 创建时间：2019年5月29日
	 * @author 作者：wuj
	 */
	@Bean
	public KeyGenerator keyGenerator() {
		return new KeyGenerator() {
			/** 重写生成key方法 */
			public Object generate(Object o, Method method, Object... objects) {
				StringBuilder sb = new StringBuilder(prefix);
				CacheConfig cacheConfig = o.getClass().getAnnotation(CacheConfig.class);
				Cacheable cacheable = method.getAnnotation(Cacheable.class);
				CachePut cachePut = method.getAnnotation(CachePut.class);
				CacheEvict cacheEvict = method.getAnnotation(CacheEvict.class);
				if (cacheable != null) {
					String[] cacheNames = cacheable.value();
					if (isNotEmpty(cacheNames)) {
						sb.append(cacheNames[0]);
					}
				} else if (cachePut != null) {
					String[] cacheNames = cachePut.value();
					if (isNotEmpty(cacheNames)) {
						sb.append(cacheNames[0]);
					}
				} else if (cacheEvict != null) {
					String[] cacheNames = cacheEvict.value();
					if (isNotEmpty(cacheNames)) {
						sb.append(cacheNames[0]);
					}
				}
				if (cacheConfig != null && sb.toString().equals(prefix)) {
					String[] cacheNames = cacheConfig.cacheNames();
					if (isNotEmpty(cacheNames)) {
						sb.append(cacheNames[0]);
					}
				}
				if (sb.toString().equals(prefix)) {
					sb.append(o.getClass().getName()).append(".").append(method.getName());
				}
				sb.append(":");
				if (objects != null) {
					for (Object object : objects) {
						sb.append(JSON.toJSONString(object));
					}
				}
				return sb.toString();
			}
		};
	}

	// springboot 2.x的版本
	/**
	 * serializeKeysWith() 修改key的序列化规则，这里采用的是StringRedisSerializer()
	 * serializeValuesWith()
	 * 修改value的序列化规则，这里采用的是Jackson2JsonRedisSerializer<Employee>(Employee.class)
	 * 
	 * @param factory
	 * @return
	 */
	@Bean
	public CacheManager cacheManager(RedisConnectionFactory connectionFactory) {

//		RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig()
//		.serializeKeysWith(
//				RedisSerializationContext.SerializationPair.fromSerializer(new StringRedisSerializer()))
//		.serializeValuesWith(RedisSerializationContext.SerializationPair
//				.fromSerializer(new Jackson2JsonRedisSerializer<Employee>(Employee.class)));
//
//RedisCacheManager cacheManager = RedisCacheManager.builder(redisConnectionFactory).cacheDefaults(config)
//		.build();

		RedisCacheManager rcm = RedisCacheManager.builder(connectionFactory).build();
		return rcm;
	}
	
	
	@SuppressWarnings("unchecked")
	private <T> boolean isNotEmpty(final T... array) {
		return (array != null && array.length != 0);
	}

}
