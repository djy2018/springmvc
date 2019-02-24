package com.wisely.highlight_springmvc4.web.excel;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by dujiayong on 2018/6/25
 */
@Controller
@RequestMapping(value = "/excel")
public class ExcelController {

    @RequestMapping(value = "/poiExport")
    public void poiExport(HttpServletResponse response){
        //创建HSSFWorkbook对象(excel文档对象)
        HSSFWorkbook workbook = new HSSFWorkbook();
        //建立新的sheet对象(excel的表单)
        HSSFSheet sheet = workbook.createSheet("成绩表");
        //在sheet里创建第一行，参数为行索引(excel的行)
        HSSFRow row1 = sheet.createRow(0);
        //创建单元格(excel单元格,参数为列索引，可以是0-255之间的任何一个)
        HSSFCell cell = row1.createCell(0);
        //设置单元格内容
        cell.setCellValue("学员考试成绩一览表");

        //单元格样式
        HSSFCellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        cell.setCellStyle(cellStyle);

        //合并单元格CellRangeAddress构造参数依次表示：起始行，截止行，起始列，截止列
        sheet.addMergedRegion(new CellRangeAddress(0,0,0,3));

        //在sheet里创建第二行
        HSSFRow row2 = sheet.createRow(1);
        //创建单元格并设置单元格内容
        row2.createCell(0).setCellValue("姓名");
        row2.createCell(1).setCellValue("班级");
        row2.createCell(2).setCellValue("笔试成绩");
        row2.createCell(3).setCellValue("机试成绩");

        //在sheet里创建第三行
        HSSFRow row3 = sheet.createRow(2);
        row3.createCell(0).setCellValue("李明");
        row3.createCell(1).setCellValue("As178");
        row3.createCell(2).setCellValue(87);
        row3.createCell(3).setCellValue(78);

        //输出excel文件
        OutputStream outputStream = null;
        try {
            outputStream = response.getOutputStream();
            response.reset();
            response.setContentType("application/msexcel");
            response.setCharacterEncoding("UTF-8");
            // excel文件名
            String fileName = "poi测试.xls";
            response.addHeader("Content-Disposition", "attachment;filename=" + new String(fileName.getBytes("gbk"), "iso8859-1"));
            workbook.write(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(outputStream != null){
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
