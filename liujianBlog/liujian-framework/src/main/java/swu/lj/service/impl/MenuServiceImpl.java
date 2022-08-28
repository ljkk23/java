package swu.lj.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import swu.lj.Constants.SystemConstants;
import swu.lj.domain.entity.User;
import swu.lj.domain.vo.UserVO;
import swu.lj.domain.entity.Menu;
import swu.lj.mapper.MenuMapper;
import swu.lj.mapper.RoleMapper;
import swu.lj.mapper.UserMapper;
import swu.lj.service.IMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import swu.lj.utils.BeanCopyUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 菜单权限表 服务实现类
 * </p>
 *
 * @author liujian
 * @since 2022-08-27
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {
    @Autowired
    private MenuMapper menuMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private UserMapper userMapper;
    @Override
    public List<String> getPermissions(Integer userID) {
        //如果是超级管理员，就返回所有的权限
        if (userID==1){
            LambdaQueryWrapper<Menu> lambdaQueryWrapper=new LambdaQueryWrapper<>();
            lambdaQueryWrapper.eq(Menu::getStatus, SystemConstants.STATUS_NORMAL);
            lambdaQueryWrapper.in(Menu::getMenuType,SystemConstants.MENU,SystemConstants.BUTTON);
            List<Menu> menus = menuMapper.selectList(lambdaQueryWrapper);
            List<String> perms = menus.stream()
                    .map(Menu::getPerms)
                    .collect(Collectors.toList());
            return perms;
        }
        List<String> menuByUserId = menuMapper.selectPermsByUserId(userID);
        return menuByUserId;
    }

    @Override
    public List<String> getRoles(Integer userID) {
        //如果是超级管理员，就返回admin
        if (userID==1){
            List<String> list=new ArrayList<>();
            list.add("admin");
            return list;
        }
        List<String> roleByUserId = roleMapper.getRoleByUserId(userID);
        return roleByUserId;
    }

    @Override
    public UserVO getUserVo(Integer userID) {
        LambdaQueryWrapper<User> userLambdaQueryWrapper=new LambdaQueryWrapper<>();
        userLambdaQueryWrapper.eq(User::getId,userID);
        User user = userMapper.selectOne(userLambdaQueryWrapper);
        UserVO userVO = BeanCopyUtils.copyBean(user, UserVO.class);
        return userVO;
    }
}
