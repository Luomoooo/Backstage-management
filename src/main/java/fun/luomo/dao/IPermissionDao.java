package fun.luomo.dao;

import fun.luomo.domain.Permission;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Luomo
 * @since 2020/2/17 12:45
 */
public interface IPermissionDao {

    @Select("select * from permission where id in (select permissionId from role_permission where roleId=#{id})")
    public List<Permission> findPermissionByRoleId(String id) throws Exception;

    @Select("select * from permission")
    List<Permission> findAll() throws Exception;

    @Insert("insert into permission (id,permissionName,url) values(#{id},#{permissionName},#{url}) ")
    void save(Permission permission) throws Exception;

}
