package edu.swu.domain.UserDTO;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "User的DTO")
public class loginUserDTO {

    public String username;

    public String password;
}
