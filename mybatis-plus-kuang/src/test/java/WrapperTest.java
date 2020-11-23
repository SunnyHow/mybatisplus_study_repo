import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sun.mybatisplus.MybatisPlusApplication;
import com.sun.mybatisplus.mapper.UserMapper;
import com.sun.mybatisplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

/**
 * @Author: SunHao
 * @Description
 * @Date: 2020/11/23 19:56
 */
@SpringBootTest(classes = MybatisPlusApplication.class)
public class WrapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads(){
        // 查询name不为空的用户，并且邮箱不为空的用户，年龄大于等于12
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper
                .isNotNull("name")
                .isNotNull("email")
                .ge("age",12);
        userMapper.selectList(wrapper).forEach(System.out::println);
    }
    @Test
    void test2(){
        // 查询name为Jake
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("name","Jack");
        // 查询一个数据，出现多个结果使用List或者Map
        User user = userMapper.selectOne(wrapper);
        System.out.println(user);
    }
    @Test
    void test3(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.between("age",20,30);
        Integer count = userMapper.selectCount(wrapper);
        System.out.println(count);
    }
    @Test
    void test4(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper
                .notLike("name","e")
                .likeRight("email","t");
        List<Map<String, Object>> maps = userMapper.selectMaps(wrapper);
        maps.forEach(System.out::println);
    }
    @Test
    void test5(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.inSql("id","select id from user where id < 3");
        List<Object> objects = userMapper.selectObjs(wrapper);
        objects.forEach(System.out::println);
    }
    @Test
    void test6(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.orderByAsc("id");
        // 通过id进行排序
        List<User> users = userMapper.selectList(wrapper);
        users.forEach(System.out::println);
    }
}
