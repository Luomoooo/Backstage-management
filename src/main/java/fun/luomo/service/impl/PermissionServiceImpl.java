package fun.luomo.service.impl;

import fun.luomo.dao.IPermissionDao;
import fun.luomo.domain.Permission;
import fun.luomo.service.IPermissionService;
import fun.luomo.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Luomo
 * @since 2020/2/17 14:57
 */
@Service
@Transactional
public class PermissionServiceImpl implements IPermissionService {
    @Autowired
    private IPermissionDao permissionDao;

    @Override
    public List<Permission> findAll() throws Exception {
        return permissionDao.findAll();
    }

    @Override
    public void save(Permission permission) throws Exception {
        permission.setId(UUIDUtils.getUUID());
        permissionDao.save(permission);
    }

}
