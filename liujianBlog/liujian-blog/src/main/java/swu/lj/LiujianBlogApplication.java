package swu.lj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@MapperScan("swu.lj.mapper")
//允许使用配置注入类
@ConfigurationPropertiesScan
@EnableConfigurationProperties
//开启定时任务的功能
@EnableScheduling
//开启swagger2的功能
@EnableSwagger2
public class LiujianBlogApplication {
    public static void main(String[] args) {
        SpringApplication.run(LiujianBlogApplication.class,args);
    }
}
