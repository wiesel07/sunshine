package cn.sunshine.common.config;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.baomidou.mybatisplus.autoconfigure.ConfigurationCustomizer;
import com.baomidou.mybatisplus.core.parser.ISqlParser;
import com.baomidou.mybatisplus.extension.MybatisMapWrapperFactory;
import com.baomidou.mybatisplus.extension.parsers.BlockAttackSqlParser;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import com.baomidou.mybatisplus.extension.plugins.SqlExplainInterceptor;

import lombok.extern.slf4j.Slf4j;

/**
 * @Description
 * @date 2019年5月28日
 * @author wuj
 * @version V1.0
 */
@EnableTransactionManagement
@Configuration
@MapperScan("cn.sunshine.*.mapper*")
@Slf4j
public class MybatisPlusConfig {

	/**
	 * 
	 * @Title: paginationInterceptor
	 * @Description:分页插件
	 * @return
	 *
	 * @date 创建时间：2019年5月28日
	 * @author 作者：wuj
	 */
	@Bean
	public PaginationInterceptor paginationInterceptor() {
		log.info("注册分页插件");
		PaginationInterceptor paginationInterceptor = new PaginationInterceptor();

		List<ISqlParser> sqlParserList = new ArrayList<>();
		// 攻击 SQL 阻断解析器、加入解析链
		log.info("攻击 SQL 阻断解析器、加入解析链");
		sqlParserList.add(new BlockAttackSqlParser());
		paginationInterceptor.setSqlParserList(sqlParserList);

		return paginationInterceptor;
	}

//	@DependsOn("dataSource")
//	@Bean(name = "transactionManager")
//	public DataSourceTransactionManager transactionManager(
//			@Qualifier(value = "dataSource") DruidDataSource dataSource) {
//		log.info("配置事务管理");
//		return new DataSourceTransactionManager(dataSource);
//	}

	/**
	 * SQL执行效率插件
	 */
	@Bean
	@Profile({ "dev", "test" }) // 设置 dev test 环境开启
	public PerformanceInterceptor performanceInterceptor() {
		PerformanceInterceptor performanceInterceptor = new PerformanceInterceptor();
		/* <!-- SQL 执行性能分析，开发环境使用，线上不推荐。 maxTime 指的是 sql 最大执行时长 --> */
		performanceInterceptor.setMaxTime(3000);
		/* <!--SQL是否格式化 默认false--> */
		performanceInterceptor.setFormat(false);
		// performanceInterceptor.setWriteInLog(false);
		return performanceInterceptor;
	}

	@Bean
	public SqlExplainInterceptor sqlExplainInterceptor() {
		SqlExplainInterceptor sqlExplainInterceptor = new SqlExplainInterceptor();
		List<ISqlParser> sqlParserList = new ArrayList<>();
		sqlParserList.add(new BlockAttackSqlParser());
		sqlExplainInterceptor.setSqlParserList(sqlParserList);
		return sqlExplainInterceptor;
	}

	/**
	 * 
	 * @Title: mybatisConfigurationCustomizer
	 * @Description:补充map驼峰转换
	 * @return
	 *
	 * @date 创建时间：2019年3月29日
	 * @author 作者：wuj
	 */
	@Bean
	public ConfigurationCustomizer mybatisConfigurationCustomizer() {
		return new ConfigurationCustomizer() {
			@Override
			public void customize(org.apache.ibatis.session.Configuration configuration) {
				configuration.setObjectWrapperFactory(new MybatisMapWrapperFactory());
			}
		};
	}

}
