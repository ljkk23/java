package Test;

import org.junit.Test;
import swu.lj.ssm.utils.MD5Util;

public class md5_test {
    @Test
    public void md5_test(){
        String md5= MD5Util.getMD5("liujian");
        System.out.println(md5);
    }
}
