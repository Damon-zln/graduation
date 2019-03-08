package per.dazhan.graduation.mapper;

import org.apache.ibatis.annotations.*;
import per.dazhan.graduation.model.User;

import java.util.List;

/**
 * @author Damon-zln
 * @date 2019/3/2 16:37
 * @description UserMapper
 * @update
 */
@Mapper
public interface UserMapper {

    @Select(value = "select * from t_users where username=#{username} and password=#{pwd};")
    @Results(id = "userResultMap", value = {
            @Result(property = "uid", column = "uid"),
            @Result(property = "username", column = "username"),
            @Result(property = "password", column = "password"),
            @Result(property = "create_time", column = "create_time")
    })
    List<User> selectByUser(@Param("username") String username, @Param("pwd") String pwd);

    @Select(value = "select * from t_users where username=#{username};")
    @ResultMap(value = "userResultMap")
    List<User> selectByName(@Param("username") String username);

    @Insert(value = "insert into t_users(username, password) values(#{username}, #{password});")
    @Options(useGeneratedKeys = true)
    int insertUser(User user);
}
