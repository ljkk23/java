package edu.swu.domain.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlogUserLoginVO {
    String token;
    UserInfoVO userInfoVO;
}
