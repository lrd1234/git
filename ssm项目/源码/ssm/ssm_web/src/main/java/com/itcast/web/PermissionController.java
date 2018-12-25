package com.itcast.web;

import com.itcast.domain.Permission;
import com.itcast.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/permission")
public class PermissionController {
    @Autowired
    private PermissionService permissionService;
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(){
        ModelAndView mav = new ModelAndView();
        List<Permission> permissionList = permissionService.findAll();
        mav.addObject("permissionList",permissionList);
        mav.setViewName("permission/permission-list");
        return mav;
    }
    /*增加一个资源权限*/
    @RequestMapping("/savePermission.do")
    public String savePermission(Permission permission){
        permissionService.savePermission(permission);

        return "redirect:findAll.do";
    }
}
