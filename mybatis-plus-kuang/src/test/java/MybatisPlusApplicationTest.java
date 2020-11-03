import com.sun.mybatisplus.MybatisPlusApplication;
import com.sun.mybatisplus.mapper.UserMapper;
import com.sun.mybatisplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest(classes = MybatisPlusApplication.class)
public class MybatisPlusApplicationTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads(){
        //参数是一个条件构造器
        //查询全部用户
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }

    @Test
    public void testInsert(){
        User user = new User();
        user.setName("孙浩1");
        user.setAge(22);
        user.setEmail("348481904@qq.com");
        int result = userMapper.insert(user);
        System.out.println(result);

    }

    @Test
    public void testUpdate(){
        User user = new User();
        //通过条件，自动拼接SQL
        user.setId(12L);
        user.setName("关注公众号狂神说");
        user.setAge(221);
        int result = userMapper.updateById(user);
        System.out.println(result);
    }

}
