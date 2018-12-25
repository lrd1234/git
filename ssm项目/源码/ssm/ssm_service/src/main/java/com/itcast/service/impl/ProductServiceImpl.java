package com.itcast.service.impl;

import com.itcast.dao.ProductDao;
import com.itcast.domain.Product;
import com.itcast.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductDao productDao;


    @Override
   // @PreAuthorize("authentication.principal.username == 'lisi'")
   // @PreAuthorize("hasRole('ROLE_ADMIN')")
    //@RolesAllowed("ADMIN")
    @Secured("ADMIN")
    public List<Product> findAll() {

        return productDao.findAll();
    }
}

/*  /*@RolesAllowed("ADMIN")
@Secured("ADMIN")
@PreAuthorize("hasRole('ROLE_ADMIN')")
@PreAuthorize("authentication.principal.username=='zhangsan'")*/
/* <security:global-method-security  pre-post-annotations="enabled"/>
*   这句话写在spring-security  就则注解@RolesAllowed("ADMIN")只能作用在service层
*   配置在applicationContext中更好
*   测试上面四种方式
* */