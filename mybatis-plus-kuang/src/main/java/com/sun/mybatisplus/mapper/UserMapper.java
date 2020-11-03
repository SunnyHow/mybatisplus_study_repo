package com.sun.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sun.mybatisplus.pojo.User;
import org.springframework.stereotype.Repository;

//在对应的Mapper上面继承BaseMapper
@Repository //代表持久层
public interface UserMapper extends BaseMapper<User> {
}
