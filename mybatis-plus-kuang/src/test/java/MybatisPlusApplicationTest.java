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

    /**
     * 测试乐观锁成功
     */
    @Test
    public void testOptimisticLocker(){
        // 1、查询用户信息
        User user = userMapper.selectById(1L);
        // 2、修改用户信息
        user.setName("kuangshen");
        user.setEmail("24736743@qq.com");
        // 3、执行更新操作
        userMapper.updateById(user);
    }

    /**
     * 测试乐观锁失败 多线程下
     */
    @Test
    public void testOptimisticLocker2(){
        // 线程1
        User user = userMapper.selectById(1L);
        user.setName("kuangshen111");
        user.setEmail("24736743@qq.com");

        // 模拟另外一个线程执行了插队操作
        User user2 = userMapper.selectById(1L);
        user.setName("kuangshen222");
        user.setEmail("24736743@qq.com");
        userMapper.updateById(user2);

        // 如果没有乐观锁就会覆盖插队线程的值
        // 自旋锁来尝试多次提交！
        userMapper.updateById(user);
    }

}
