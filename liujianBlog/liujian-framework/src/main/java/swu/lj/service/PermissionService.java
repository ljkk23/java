package swu.lj.service;

import swu.lj.domain.vo.UserVO;

import java.util.List;

public interface PermissionService {
    List<String> getPermissions(Integer userID);
    List<String> getRoles(Integer userID);
    UserVO getUserVo(Integer userID);

}
