package swu.lj.mapper;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface RoleMapper {
    List<String> getRoleByUserId(Integer userId);
}
