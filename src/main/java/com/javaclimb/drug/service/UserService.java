package com.javaclimb.drug.service;

import com.javaclimb.drug.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户 服务类
 * </p>
 *
 * @author LaoJie
 * @since 2021-04-17
 */
public interface UserService extends IService<User> {
    /**
     * 根据用户名查询用户对象
     */
    public User queryUserByUsername(User user);

}
