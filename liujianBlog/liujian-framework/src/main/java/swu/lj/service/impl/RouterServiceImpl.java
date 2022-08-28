package swu.lj.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import swu.lj.domain.entity.Menu;
import swu.lj.domain.vo.MenuVo;
import swu.lj.mapper.MenuMapper;
import swu.lj.service.RouterService;
import swu.lj.utils.BeanCopyUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RouterServiceImpl implements RouterService {
    @Autowired
    private MenuMapper menuMapper;
    @Override
    public List<MenuVo> getRoutersByUserID(Integer userID) {
        List<Menu> menus = null;
        if (userID==1){
            menus = menuMapper.selectAllRouters();
        }else {
           menus = menuMapper.selectRoutersByUserId(userID);
        }
        List<MenuVo> menuVos = BeanCopyUtils.copyBeanList(menus, MenuVo.class);
        List<MenuVo> parentMenus = menuVos.stream()
                .filter(menuVo -> menuVo.getParentId().equals(0L))
                .map(menuVo -> menuVo.setChildren(getRouterChildren(menuVo,menuVos)))
                .collect(Collectors.toList());
        return parentMenus;
    }

    public  List<MenuVo> getRouterChildren(MenuVo parentMenu,List<MenuVo> menuVoList){
        List<MenuVo> menuVos = menuVoList.stream()
                .filter(menuVo -> menuVo.getParentId().equals(parentMenu.getId()))
                .map(menuVo -> menuVo.setChildren(getRouterChildren(menuVo, menuVoList)))
                .collect(Collectors.toList());

        return menuVos;
    }
}
