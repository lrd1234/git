package com.itcast.service.impl;

import com.itcast.dao.UserDao;
import com.itcast.domain.Role;
import com.itcast.domain.UserInfo;
import com.itcast.domain.Users_Role;
import com.itcast.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = userDao.findByUsername(username); //通过用户名来查找用户对象
        List<Role> roles = userInfo.getRoles();  //获取角色信息
        List<SimpleGrantedAuthority> authoritys = getAuthority(roles);  //简单的授权类
        User user = new User(    //user不是我们定义的，他来自于spring安全认证中的user，他包含如下信息
                userInfo.getUsername(),    //用户名
                 userInfo.getPassword(),  //密码  {noop}表示解密"{noop}" + userInfo.getPassword()
                userInfo.getStatus() == 0 ? false : true,     //状态吗
                true, //设置账户是否过期
                true, //设置凭证是否过期
                true,  //是否设置了账户锁
                authoritys);   //授权信息（也就是spring security中  admin = ROLE_ADMIN  user = ROLE_USER）

        return user;
    }

    private List<SimpleGrantedAuthority> getAuthority(List<Role> roles) {
        List<SimpleGrantedAuthority> authoritys = new ArrayList();
        for (Role role : roles) {
            authoritys.add(new SimpleGrantedAuthority("ROLE_"+role.getRoleName()));
        }
        return authoritys;
    }

    @Override
    public List<UserInfo> findAll() {
        return userDao.findAll();
    }

    @Override
    public void saveUser(UserInfo userInfo) {
        /*对密码进行加密处理*/
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        userDao.saveUser(userInfo);
    }

    @Override
    public UserInfo findById(String id) {
        UserInfo userInfo = userDao.findById(id);
        return userInfo;
    }

    @Override
    public void addRoleToUser(String userId, String[] ids) {
        for (String roleId : ids) {
            Users_Role ur = new Users_Role();
            ur.setUserId(userId);
            ur.setRoleId(roleId);
            userDao.addRoleToUser(ur);
        }

    }

}
