package com.imooc.o2o;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.swing.*;

/**
 * @Author: zxw
 * @Date: Created in 20:10 2022/8/11
 */

/**
 *配置spring和junit整合，junit启动时加载springIOC容器
 **/



@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring配置文件的位置
@ContextConfiguration({"classpath:spring/spring-dao.xml","classpath:spring/spring-service.xml"})
public class BaseTest {
}
