package fun.luomo.dao;

import fun.luomo.domain.Role;
import fun.luomo.domain.UserInfo;
import org.apache.ibatis.annotations.*;
import sun.java2d.pipe.AAShapePipe;

import java.util.List;

/**
 * @author Luomo
 * @since 2020/2/16 14:42
 */
public interface IUserDao {
   /* @Select("select * from user where id=#{id}")
    public UserInfo findById(Long id) throws Exception;*/

    @Select("select * from users where username=#{username}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(column = "username", property = "username"),
            @Result(column = "email", property = "email"),
            @Result(column = "password", property = "password"),
            @Result(column = "phoneNum", property = "phoneNum"),
            @Result(column = "status", property = "status"),
            @Result(column = "id", property = "roles", javaType = List.class, many =
            @Many(select = "fun.luomo.dao.IRoleDao.findRoleByUserId"))})
    UserInfo findByUsername(String username);

    @Select("select * from users")
    List<UserInfo> findAll() throws Exception;

    @Insert("insert into users(id,email,username,password,phoneNum,status) " +
            "values(#{id},#{email},#{username},#{password},#{phoneNum},#{status})")
    void save(UserInfo userInfo) throws Exception;


    @Select("select * from users where id=#{id}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(column = "username", property = "username"),
            @Result(column = "email", property = "email"),
            @Result(column = "password", property = "password"),
            @Result(column = "phoneNum", property = "phoneNum"),
            @Result(column = "status", property = "status"),
            @Result(column = "id", property = "roles", javaType = List.class, many =
            @Many(select = "fun.luomo.dao.IRoleDao.findRoleByUserId"))})
    UserInfo findById(String id) throws Exception;

    @Select("select * from role where id not in(select roleId from users_role where userId=#{userId})")
    List<Role> findOtherRole(String userId);

    @Insert("insert into users_role (userId,roleId) values(#{userId},#{roleId})")
    void addRoleToUser(@Param("userId") String userId, @Param("roleId") String roleId);
}
