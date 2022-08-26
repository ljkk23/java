package swu.lj.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class UserPermissionInfoVO {
    List<String> permissions;
    List<String> roles;
    UserVO userVO;
}
