package swu.lj.service;

import org.springframework.stereotype.Component;
import swu.lj.domain.vo.MenuVo;

import java.util.List;

public interface RouterService {
    List<MenuVo> getRoutersByUserID(Integer userID);
}
