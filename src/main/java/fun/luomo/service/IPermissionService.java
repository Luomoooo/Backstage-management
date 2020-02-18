package fun.luomo.service;

import fun.luomo.domain.Permission;

import java.util.List;

/**
 * @author Luomo
 * @since 2020/2/17 14:57
 */
public interface IPermissionService {

    public List<Permission> findAll() throws Exception;

    void save(Permission permission) throws Exception;

}
