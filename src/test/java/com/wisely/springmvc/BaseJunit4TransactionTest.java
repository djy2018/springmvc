package com.wisely.springmvc;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Spring 单元测试基类
 *
 * @author dujiayong
 * @date 2020/03/05
 **/
// 使用junit4进行测试
@RunWith(SpringJUnit4ClassRunner.class)
// 加载Spring配置文件
@ContextConfiguration(classes = {MyMvcConfig.class})
// 设置web项目的环境，如果是Web项目，必须配置该属性，否则无法获取 web 容器相关的信息（request、context 等信息）
@WebAppConfiguration
// spring 4.2之前@TransactionConfiguration配置测试时事务管理器
// spring 4.2之后@Transaction新增属性transactionManager配置事务管理器，用来替代@TransactionConfiguration
//@Transactional(transactionManager = "transactionManager")
//@Rollback
public class BaseJunit4TransactionTest {

}
