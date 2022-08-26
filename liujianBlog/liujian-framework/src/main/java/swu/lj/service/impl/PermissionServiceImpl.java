package swu.lj.service.impl;

import org.springframework.stereotype.Service;
import swu.lj.domain.vo.UserVO;
import swu.lj.service.PermissionService;

import java.util.ArrayList;
import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Override
    public List<String> getPermissions(Integer userID) {
         List<String> list=new ArrayList<>();
         list.add("s");
         list.add("ss");
         return list;
    }

    @Override
    public List<String> getRoles(Integer userID) {
        List<String> list=new ArrayList<>();
        list.add("a");
        list.add("aa");
        return list;
    }

    @Override
    public UserVO getUserVo(Integer userID) {
        return new UserVO(1L,"a","a","a","a");

    }
}
