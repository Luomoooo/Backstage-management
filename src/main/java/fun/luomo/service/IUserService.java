package fun.luomo.service;

import fun.luomo.domain.Role;
import fun.luomo.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * @author Luomo
 * @since 2020/2/16 14:41
 */
public interface IUserService extends UserDetailsService {

    List<UserInfo> findAll() throws Exception;

    void save(UserInfo userInfo) throws Exception;

    UserInfo findById(String id) throws Exception;

    List<Role> findOtherRole(String userId)throws Exception;

    void addRoleToUser(String userId, String[] roleIds) throws Exception;

}
