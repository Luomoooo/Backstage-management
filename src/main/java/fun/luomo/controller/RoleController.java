package fun.luomo.controller;

import fun.luomo.domain.Permission;
import fun.luomo.domain.Role;
import fun.luomo.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author Luomo
 * @since 2020/2/17 13:25
 */
@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private IRoleService roleService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Role> roleList = roleService.findAll();
        mv.addObject("roleList", roleList);
        mv.setViewName("role-list");
        return mv;
    }

    @RequestMapping("/save.do")
    public String save(Role role) throws Exception {
        roleService.save(role);
        return "redirect:findAll.do";
    }

    @RequestMapping("findRoleByIdAndAllPermission.do")
    public ModelAndView findRoleByIdAndAllPermission(@RequestParam(name = "id", required = true) String roleId) throws Exception {
        ModelAndView mv = new ModelAndView();

        Role role = roleService.findById(roleId);
        List<Permission> otherPermission = roleService.findOtherPermission(roleId);

        mv.addObject("role", role);
        mv.addObject("permissionList", otherPermission);

        mv.setViewName("role-permission-add");

        return mv;
    }

    @RequestMapping("/addPermissionToRole.do")
    public String addPermissionToRole(
            @RequestParam(name = "roleId", required = true) String roleId,
            @RequestParam(name = "ids", required = true) String[] permissionIds) throws Exception {

        roleService.addPermissionToRole(roleId, permissionIds);

        return "redirect:findAll.do";
    }

}
