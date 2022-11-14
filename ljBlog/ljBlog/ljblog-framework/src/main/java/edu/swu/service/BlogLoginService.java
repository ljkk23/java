package edu.swu.service;


import edu.swu.domain.Result;
import edu.swu.domain.UserDTO.loginUserDTO;

public interface BlogLoginService {
    Result login(loginUserDTO user);

    Result logout();
}
