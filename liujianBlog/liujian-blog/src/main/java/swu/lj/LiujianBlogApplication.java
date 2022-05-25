package swu.lj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("swu.lj.mapper")
public class LiujianBlogApplication {
    public static void main(String[] args) {
        SpringApplication.run(LiujianBlogApplication.class,args);
    }
}
