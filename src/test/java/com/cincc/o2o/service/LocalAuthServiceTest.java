package com.cincc.o2o.service;

import com.cincc.o2o.dao.PersonInfoDao;
import com.cincc.o2o.dto.ImageHolder;
import com.cincc.o2o.entity.LocalAuth;
import com.cincc.o2o.entity.PersonInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * @author li
 * Date: 2018/05/30
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class LocalAuthServiceTest  {
    @Autowired
    LocalAuthService localAuthService;
    @Autowired
    PersonInfoDao personInfoDao;

    @Test
    public void getLocalUserByUserNameAndPwd() {
    }

    @Test
    public void getLocalAuthByUserId() {
    }

    @Test
    public void modyfiLocalAuth() {
        long userId=4;
        String username="新用户";
        String password="newmima";
        String newPassword="newmima";
        localAuthService.modyfiLocalAuth(userId,username,password,newPassword);
    }

    @Test
    public void registerLocalAuth() throws FileNotFoundException {
        File thumbnailFile=new File("C:\\Users\\lotus\\Desktop\\新建文件夹\\op.jpg");
        InputStream is=new FileInputStream(thumbnailFile);
        ImageHolder thumbnail=new ImageHolder(thumbnailFile.getName(),is);
        LocalAuth localAuth=new LocalAuth();
        localAuth.setUsername("springboot2");
        localAuth.setPassword("mima1");
        PersonInfo personInfo=new PersonInfo();
        //personInfo.setUserId(3L);
        personInfo.setEnableStatus(1);
        personInfo.setUserType(1);
        personInfo.setName("test");
        localAuth.setPersonInfo(personInfo);
        localAuthService.registerLocalAuth(localAuth,thumbnail);

    }
}