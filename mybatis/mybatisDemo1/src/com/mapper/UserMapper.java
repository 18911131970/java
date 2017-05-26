package com.mapper;

import com.entity.User;
import com.entity.UserCustom;
import com.entity.UserQueryVo;

import java.util.List;

/**
 * Created by yangzhe on 2017/5/16.
 */
public interface UserMapper {
    public User findUserById(int id);

    public List<UserCustom> findUserList(UserQueryVo userQueryVo) throws Exception;

}
