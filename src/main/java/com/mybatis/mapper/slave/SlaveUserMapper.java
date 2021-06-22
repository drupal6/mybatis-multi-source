package com.mybatis.mapper.slave;

import com.mybatis.enums.UserSexEnum;
import com.mybatis.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface SlaveUserMapper {

    @Select("SELECT * FROM user")
    @Results({
            @Result(property = "userName", column = "user_name"),
            @Result(property = "passWord", column = "pass_word"),
            @Result(property = "userSex", column = "user_sex", javaType = UserSexEnum.class),
            @Result(property = "nickName", column = "user_name")
    })
    List<User> getAll();

    @Select("SELECT * FROM user WHERE id = #{id}")
    @Results({
            @Result(property = "userName", column = "user_name"),
            @Result(property = "passWord", column = "pass_word"),
            @Result(property = "userSex", column = "user_sex", javaType = UserSexEnum.class),
            @Result(property = "nickName", column = "user_name")
    })
    User getOne(Long id);

    @Insert("INSERT INTO user(user_name, pass_word, user_sex, nick_name) VALUES(#{userName}, #{passWord}, #{userSex}, #{nickName})")
    void insert(User user);

    @Update("UPDATE user SET user_name = #{userName}, user_sex = #{userSex}, nick_name = #{nickName} WHERE id = #{id}")
    void update(User user);

    @Delete("DELETE FROM user WHERE id = #{id}")
    void delete(Long id);

}
