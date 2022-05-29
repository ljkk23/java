## 5.25

1. 

```java
LambdaQueryWrapper<Article> articleLambdaQueryWrapper=new LambdaQueryWrapper<>();
```

2. categoryid->categoryName,在VO中，因为categoryName为@TableName(exist=false)

3. @PathVariable

4. FastJson配置在webconfig中，以及中文乱码

5. List<Link> list = list();

## 5.26

1. - 需要暴露

```java
@Autowired
    private AuthenticationManager authenticationManager;

```

  同时在securtyconfig中要暴露出来，同时用@bean装配到容器中，注意

```txt
authenticationManager()和WebSecurityConfigurerAdapter的authenticationManagerBean()是两个不同的方法，并且		   
 您正在调用超类的 authenticationManagerBean() 方法，据我所知，这取决于 authenticationManager() 方法.这反过来会	
 创建方法的循环调用，最终导致 	StackOverflowError 异常
```

```
所以
@Bean
    @Override
    public AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManagerBean();
    }
    
    改为以下
    
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
```

- 同时还需要实现UserDetailsService接口并且重写loadUserByUsername方法，注意加上@Service,因为不加这个会导致authenticationManager在调用authenticate时找不到loadUserByUsername就会报错！！

- 在接收authenticate返回结果时：

  ```
  LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
  //注意一定要用实现了UserDetails的实体类去接收
  ```

  

2. 无法自动装配config'中返回的类：

需要在config文件上加上@Configuration

3. @Accessors(chain = true)可以链式生成

4. @compont和utlis的区别？？

5. 报错：java.lang.NoClassDefFoundError: javax/xml/bind/DatatypeConverter

   ```
   
   <dependency>
               <groupId>javax.xml.bind</groupId>
               <artifactId>jaxb-api</artifactId>
               <version>2.3.0</version>
           </dependency>
           java9以上没有这些javax的依赖，所以需要手动加入
   ```

6. 