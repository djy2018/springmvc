package com.wisely.springmvc.ioc.resource;

import org.junit.Test;
import org.springframework.core.io.*;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

import java.io.IOException;

/**
 * @author dujiayong
 * @date 2020/05/14
 **/
public class ResourceLoaderTest {

    @Test
    public void resourceLoaderTest() {
        ResourceLoader resourceLoader = new DefaultResourceLoader();

        Resource fileResource1 = resourceLoader.getResource("D:/Users/chenming673/Documents/spark.txt");
        System.out.println("fileResource1 is FileSystemResource:" + (fileResource1 instanceof FileSystemResource));

        Resource fileResource2 = resourceLoader.getResource("/Users/chenming673/Documents/spark.txt");
        System.out.println("fileResource2 is ClassPathResource:" + (fileResource2 instanceof ClassPathResource));

        Resource urlResource1 = resourceLoader.getResource("file:/Users/chenming673/Documents/spark.txt");
        System.out.println("urlResource1 is UrlResource:" + (urlResource1 instanceof UrlResource));

        Resource urlResource2 = resourceLoader.getResource("http://www.baidu.com");
        System.out.println("urlResource1 is urlResource:" + (urlResource2 instanceof UrlResource));
    }

    @Test
    public void classRelativeResourceLoaderTest() throws IOException {
        ResourceLoader resourceLoader = new ClassRelativeResourceLoader(ResourceLoaderTest.class);
        Resource resource = resourceLoader.getResource("/test/test.xml");
        System.out.println(resource.getFile().getPath());
        System.out.println("resource is ClassPathResource: " + (resource instanceof ClassPathResource));
    }

    @Test
    public void test3(){
        String location = "classpath*:test/cc*/spring-*.xml";
        PathMatcher pathMatcher = new AntPathMatcher();

        // 找到冒号的后一位
        int prefixEnd = location.indexOf(':') + 1;
        // 根目录结束位置
        int rootDirEnd = location.length();
        // 在从冒号开始到最后的字符串中，循环判断是否包含通配符，如果包含，则截断最后一个由”/”分割的部分。
        while (rootDirEnd > prefixEnd && pathMatcher.isPattern(location.substring(prefixEnd, rootDirEnd))) {
            rootDirEnd = location.lastIndexOf('/', rootDirEnd - 2) + 1;
        }
        // 如果查找完成后，rootDirEnd = 0，则将之前赋值的 prefixEnd 的值赋给 rootDirEnd ，也就是冒号的后一位
        if (rootDirEnd == 0) {
            rootDirEnd = prefixEnd;
        }
        // 截取根目录
        String rootDir = location.substring(0, rootDirEnd);
        System.out.println("rootDir=" + rootDir);
    }

}
