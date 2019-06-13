package cn.sunshine.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Description 
 * @date  2019年5月29日
 * @author  wuj
 * @version  V1.0
 */
@Configuration
@EnableSwagger2
@EnableSwaggerBootstrapUI
public class SwaggerConfig {

//	  // 是否开启swagger，正式环境一般是需要关闭的，可根据springboot的多环境配置进行设置
//    @Value(value = "${swagger.enabled}")
//    Boolean swaggerEnabled;

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Sunshine").description("Sunshine")
                // .termsOfServiceUrl("http://blog.didispace.com/")
                // 创建人
                .contact(new Contact("wuj", "url:", "502393098@qq.com:")).version("1.0").build();
    }

    @Bean
    public Docket creatBasicRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("登录相关")
                .enable(true)
                .select()
                .apis(RequestHandlerSelectors.basePackage("cn.sunshine"))
                .paths(PathSelectors.any())
                .build();
    }
    
    @Bean
    public Docket creatUpmsRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("权限管理模块")
                .enable(true)
                .select()
                .apis(RequestHandlerSelectors.basePackage("cn.sunshine.upms"))
                .paths(PathSelectors.any())
                .build();
    }
}

