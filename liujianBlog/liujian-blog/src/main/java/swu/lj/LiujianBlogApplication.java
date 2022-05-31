package swu.lj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("swu.lj.mapper")
@ConfigurationPropertiesScan
@EnableConfigurationProperties
@EnableScheduling
public class LiujianBlogApplication {
    public static void main(String[] args) {
        SpringApplication.run(LiujianBlogApplication.class,args);
    }
}
