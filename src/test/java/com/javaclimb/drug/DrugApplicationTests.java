package com.javaclimb.drug;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.javaclimb.drug.entity.Supplier;
import com.javaclimb.drug.entity.User;
import com.javaclimb.drug.mapper.SupplierMapper;
import com.javaclimb.drug.service.SupplierService;
import com.javaclimb.drug.service.UserService;
import com.javaclimb.drug.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DrugApplicationTests {

    @Autowired
    private UserService userService;
    @Test
    void contextLoads() {
        User user = new User();
        user.setUsername("admin");
        User user1 = userService.queryUserByUsername(user);
        if (user1!=null){
            System.out.println(user1.getPassword());
        }
    }


}
