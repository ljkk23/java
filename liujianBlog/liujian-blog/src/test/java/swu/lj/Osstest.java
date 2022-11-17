package swu.lj;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import org.junit.jupiter.api.Test;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import swu.lj.utils.JwtUtil;

import java.io.FileInputStream;
import java.io.InputStream;


public class Osstest {



    @Test
    public void testOss() throws Exception {

        BCryptPasswordEncoder cryptPasswordEncoder=new BCryptPasswordEncoder();
        System.out.println(cryptPasswordEncoder.encode("123456"));

        String username="doctor-liujian";
        System.out.println(username.contains("doctor-"));
        String[] userNameArray =  username.split("-");
        System.out.println(userNameArray[1]);

        Integer userID = Integer.valueOf(JwtUtil.parseJWT("eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJkZjNiZmRlNzUzYTM0Mzc1ODdhMWEzYjZkY2RhODFmMSIsInN1YiI6IjEiLCJpc3MiOiJsaXVqaWFuIiwiaWF0IjoxNjY4NTg0OTU4LCJleHAiOjE2Njg2NzEzNTh9.Zl5jsAoV8EJChGlajSs0nJzNQPvjk7yUeDgo0OsoSls").getSubject());
        System.out.println(userID);
    }
}