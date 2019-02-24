package com.wisely.highlight_springmvc4.web.ch4_5;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.File;

/**
 * Created by dujiayong on 2016/7/6.
 */
@Controller
public class UploadController {

//    @RequestMapping(value = "/upload", method = RequestMethod.POST)
//    @ResponseBody
//    public String upload(MultipartFile file) {
//        //使用MultipartFile接受上传的文件
//        try {
//            //使用FileUtils.writeByteArrayToFile快速写文件到磁盘
//            FileUtils.writeByteArrayToFile(new File("e:/upload/" + file.getOriginalFilename()), file.getBytes());
//            return "ok";
//        } catch (IOException e) {
//            e.printStackTrace();
//            return "wrong";
//        }
//    }

//    @RequestMapping(value = "/upload", method = RequestMethod.POST)
//    @ResponseBody
//    public String upload(HttpServletRequest request) throws ServletException {
//        //使用Part接受上传的文件
//        try {
//            Part file = request.getPart("file");
//            file.write("E:/test.txt");
//            return "ok";
//        } catch (IOException e) {
//            e.printStackTrace();
//            return "wrong";
//        }
//    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public String upload(@RequestPart("file") Part part) throws ServletException {
        //使用Part接受上传的文件
        try {
            part.write("E:/test.txt");
            return "ok";
        } catch (IOException e) {
            e.printStackTrace();
            return "wrong";
        }
    }

}
