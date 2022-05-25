package swu.lj.mybatisplusdemo;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StringUtils;
import swu.lj.mybatisplusdemo.entity.User;
import swu.lj.mybatisplusdemo.mapper.UserMapper;
import swu.lj.mybatisplusdemo.service.IUserService;

import java.sql.ClientInfoStatus;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
class MybatisPlusDemoApplicationTests {

    @Autowired
    UserMapper userMapper;

    @Autowired
    IUserService userService;

    @Test
    void contextLoads() {
        //(1)
        // List<User> list=userMapper.selectList(null);

//        list.forEach(System.out::println);
        //(2)
//        QueryWrapper<User> userQueryWrapper=new QueryWrapper<>();
//        userQueryWrapper.select("u_id","name","email").likeRight("name","黄");
//        List<Map<String,Object>> maps=userMapper.selectMaps(userQueryWrapper);
//        maps.forEach(System.out::println);
        //(3)
//        QueryWrapper<User> wrapper = new QueryWrapper<>();
//        wrapper.select("manager_id", "avg(age) avg_age", "min(age) min_age", "max(age) max_age")
//                .groupBy("manager_id").having("sum(age) < {0}", 500);
//        List<Map<String, Object>> maps = userMapper.selectMaps(wrapper);
//        maps.forEach(System.out::println);
        //(4)
//        QueryWrapper<User> wrapper = new QueryWrapper<>();
//        wrapper.like("name", "黄");
//
//        Integer count = userMapper.selectCount(wrapper);
//        System.out.println(count);
        //(5)service CRUD
//
//        LambdaQueryWrapper<User> wrapper= Wrappers.lambdaQuery();
//        wrapper.gt(User::getAge,28);
//        User users=userService.getOne(wrapper,false);
//        System.out.println(users);
//       // (6)
//        List<User> userList=userService.lambdaQuery()
//                .gt(User::getAge,28)
//                .likeRight(User::getName,"黄")
//                .list();
//        userList.forEach(System.out::println);
        //(7)
//        userService.lambdaUpdate()
//                .gt(User::getAge, 39)
//                .likeLeft(User::getName, "鸟")
//                .set(User::getEmail, "w39@baomidou.com")
//                .update();
        //(8)
//        String name =null; // 假设name变量是一个外部传入的参数
//        QueryWrapper<User> wrapper = new QueryWrapper<>();
//        wrapper.like(StringUtils.hasText(name), "name", name)
//                .gt("age",28);
// 仅当 StringUtils.hasText(name) 为 true 时, 会拼接这个like语句到WHERE中
// 其实就是对下面代码的简化
//        if (StringUtils.hasText(name)) {
//            wrapper.like("name", name);
//    }
//        List<User> userList=userMapper.selectList(wrapper);
//        userList.forEach(System.out::println);
//        //(8)
//        User whereUser = new User();
//        whereUser.setAge(40);
//        whereUser.setName("黄");
//
//        LambdaUpdateWrapper<User> wrapper = new LambdaUpdateWrapper<>(whereUser);
//        User user = new User();
//        user.setEmail("share@baomidou.com");
//
//
//        userMapper.update(user, wrapper);
////        //(9)分页查询
//        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
//        wrapper.gt(User::getAge, 28);
//        Page<User> page=new Page<>(1,3);
//        Page<User> userPage=userMapper.selectPage(page,wrapper);
//        List<User> userList=userPage.getRecords();
//
//        System.out.println("总记录数 = " + userPage.getTotal());
//        System.out.println("总页数 = " + userPage.getPages());
//        System.out.println("当前页码 = " + userPage.getCurrent());
//
//        userList.forEach(System.out::println);
//        //(10)自定义sql
//        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
//        wrapper.ge(User::getAge, 28).likeRight(User::getName, "黄");
//        Page<User> page = new Page<>(3,2);
//        Page<User> userPage = userMapper.selectUserPage(page, wrapper);
//        System.out.println("总记录数 = " + userPage.getTotal());
//        System.out.println("总页数 = " + userPage.getPages());
//        userPage.getRecords().forEach(System.out::println);
//        //（11）自动填充
//        User user = new User();
//        user.setName("王一蛋");
//        user.setAge(29);
//        user.setEmail("yd@baomidou.com");
//        user.setManagerId(2L);
//        userMapper.insert(user);


    }
}

