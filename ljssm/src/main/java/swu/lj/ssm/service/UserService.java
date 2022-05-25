package swu.lj.ssm.service;

import swu.lj.ssm.pojo.User;

public interface UserService {
   User login(String name, String pwd);
}
