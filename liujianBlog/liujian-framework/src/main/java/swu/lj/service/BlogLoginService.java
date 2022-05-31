package swu.lj.service;

import swu.lj.domain.ResponseResult;
import swu.lj.domain.entity.User;

public interface BlogLoginService {
    ResponseResult login(User user);

    ResponseResult logout();
}
