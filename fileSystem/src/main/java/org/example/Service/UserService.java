package org.example.Service;

import org.example.pojo.User;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.FileNotFoundException;
import java.util.List;

public interface UserService {
    //注册用户
    void reg(User user);
    //登陆用户
    Boolean getUser(User user);

    Integer getNowUserRole(String userName);

    User passwordVerify(User user);

    List<User> getUserList(Integer role);

    void deleteUser(String userName);


}
