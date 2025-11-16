package co.nz.csoft.razorpay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.RequestHandler;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger.web.UiConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;

import java.util.Collections;
import java.util.TimeZone;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EnableCaching
public class RazorpayApplication {

	 @PostConstruct
	  void started() {
	    TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
	  }
	 
	public static void main(String[] args) {
		SpringApplication.run(RazorpayApplication.class, args);
		
		
		
	}

	@Configuration
	@EnableSwagger2
	public class SwaggerConfig {
		private ApiInfo apiInfo() {
			return new ApiInfo("razorpay Payment Integration API", "razorpay Payment Integration API ",
					"v1", "CredenceSoft's Fair Usage Policy",
					new Contact("CredenceSoft Limited", "https://www.credencesoft.co.nz",
							"samaya.muduli@credencesoft.co.nz"),
					"License of API", "API license URL", Collections.emptyList());
		}

		@Bean
		public Docket razorpayApi() {
			return new Docket(DocumentationType.SWAGGER_2).select()
					.apis(RequestHandlerSelectors.basePackage("co.nz.csoft.razorpay.controller"))
					.paths(PathSelectors.ant("/api/razorpay/**")).build().groupName("razorpay").apiInfo(apiInfo());
		}

	}
	

	@Configuration
	@EnableWebMvc
	public class WebConfig implements WebMvcConfigurer {

		@Override
		public void addCorsMappings(CorsRegistry registry) {
			registry.addMapping("/**");
		}

		@Override
		public void addResourceHandlers(ResourceHandlerRegistry registry) {
			registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
			registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
		}

	}
}
