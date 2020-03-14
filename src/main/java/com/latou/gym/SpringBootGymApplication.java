package com.latou.gym;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableSwagger2
public class SpringBootGymApplication extends WebMvcConfigurationSupport {

    protected void addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/admin").addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX+"/static/admin/");
        registry.addResourceHandler("/ui").addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX+"/static/ui/");
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
        super.addResourceHandlers(registry);
    }
    public static void main(String[] args) {
        SpringApplication.run(SpringBootGymApplication.class, args);
    }
}
