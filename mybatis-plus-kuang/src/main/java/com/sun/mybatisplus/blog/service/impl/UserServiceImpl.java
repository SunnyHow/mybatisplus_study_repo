package com.sun.mybatisplus.blog.service.impl;

import com.sun.mybatisplus.blog.entity.User;
import com.sun.mybatisplus.blog.mapper.UserMapper;
import com.sun.mybatisplus.blog.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author SunHao
 * @since 2020-11-23
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
