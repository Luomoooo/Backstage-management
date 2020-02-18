package fun.luomo.service;

import fun.luomo.domain.Permission;
import fun.luomo.domain.Role;

import java.util.List;

/**
 * @author Luomo
 * @since 2020/2/17 13:45
 */
public interface IRoleService {

    public List<Role> findAll() throws Exception;

    void save(Role role) throws Exception;

    Role findById(String roleId) throws Exception;

    List<Permission> findOtherPermission(String roleId) throws Exception;

    void addPermissionToRole(String roleId, String[] permissionIds) throws Exception;
}
