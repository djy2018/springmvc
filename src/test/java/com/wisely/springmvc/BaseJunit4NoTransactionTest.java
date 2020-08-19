package com.wisely.highlight_springmvc4;

import org.junit.runner.RunWith;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.test.context.ActiveProfiles;
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
@ContextConfiguration(classes = {WebInitializer.class})
// 设置web项目的环境，如果是Web项目，必须配置该属性，否则无法获取 web 容器相关的信息（request、context 等信息）
@WebAppConfiguration
public class BaseJunit4NoTransactionTest {

}
