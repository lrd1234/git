package com.itcast.web;

import com.itcast.domain.Permission;
import com.itcast.domain.Role;
import com.itcast.domain.UserInfo;
import com.itcast.service.PermissionService;
import com.itcast.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @Autowired
    private PermissionService permissionService;
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(){
        ModelAndView mav = new ModelAndView();
        List<Role> roleList = roleService.findAll();
        mav.addObject("roleList",roleList);
        mav.setViewName("role/role-list");
        return mav;
    }
    @RequestMapping("/saveRole.do")
    public String saveRole(Role role){

        roleService.saveRole(role);

        return "redirect:findAll.do";
    }
    @RequestMapping("/findRoleByIdAndAllPermission.do")
    public ModelAndView findUserByIdAndAllPermission(@RequestParam(name = "id",required =true) String id){
        ModelAndView mav = new ModelAndView();

        /*根据roleid来查询用户信息*/
        Role role = roleService.findById(id);
        /*根据roleid来查询还可以增加的角色信息*/
        List<Permission> permissionList =permissionService.findOtherPermission(id);
        mav.addObject("role",role);
        mav.addObject("permissionList",permissionList);
        mav.setViewName("role/role-permission-add");
        return mav;
    }



    @RequestMapping("/addPermissionToRole.do")
    public String addPermissionToRole(String roleId,String[] ids){
        roleService.addPermissionToRole(roleId,ids);
        return  "redirect:findAll.do";
    }
}
