package com.itcast.web;

import com.itcast.domain.Role;
import com.itcast.domain.UserInfo;
import com.itcast.service.RoleService;
import com.itcast.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll() {
        ModelAndView mav = new ModelAndView();
        List<UserInfo> userList = userService.findAll();
        mav.addObject("userList", userList);
        mav.setViewName("users/user-list");
        return mav;
    }

    @RequestMapping("/saveUser.do")
    @RolesAllowed("ADMIN")/*<!--服务器端的权限控制，第二步：使用RolesAllowed注解，参数写想调用该方法需要具备的权限，省略了ROLE_前缀-->*/

    public String save(UserInfo user) throws Exception {
        userService.saveUser(user);
        return "redirect:findAll.do";
    }

/*根据用户id查找用户信息*/
    @RequestMapping("/findById.do")
    public ModelAndView findById(String id) throws Exception {
        ModelAndView mav = new ModelAndView();

        UserInfo userInfo = userService.findById(id);
        System.out.println(userInfo);
        mav.addObject("user",userInfo);
        mav.setViewName("users/user-show");
        return mav;
    }
    @RequestMapping("/findUserByIdAndAllRole.do")
    public ModelAndView findUserByIdAndAllRole(@RequestParam(name = "id",required =true) String id){
        ModelAndView mav = new ModelAndView();

        /*根据用户id来查询用户信息*/
        UserInfo userInfo = userService.findById(id);
        /*根据用户id来查询还可以增加的角色信息*/
       List<Role> roleList =  roleService.findOtherRole(id);
       mav.addObject("user",userInfo);
       mav.addObject("roleList",roleList);
       mav.setViewName("users/user-role-add");
       return mav;
    }
    /*把该用户不存在的角色加给该用户，也就是在中间表users_role中增加一条记录*/
    @RequestMapping("/addRoleToUser.do")
    /*userId，ids要和页面上的一致，否则不等注入，userId指的是用户的id，ids指的是所有该用户不存在的角色*/
    public String addRoleToUser( String userId ,String[] ids){
        userService.addRoleToUser(userId,ids);
        return "redirect:findAll.do";
    }
}
