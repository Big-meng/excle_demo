package cn.bigmeng.excle_demo;

import cn.bigmeng.excle_demo.dao.CityReader;
import cn.bigmeng.excle_demo.dao.SuffixReader;
import org.apache.poi.hssf.usermodel.*;

import java.io.FileOutputStream;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws Exception {
        CityReader reader = new CityReader("/home/bigmeng/Desktop/city");
        SuffixReader suffixReader = new SuffixReader("/home/bigmeng/Desktop/suffix");

        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet = wb.createSheet();

        HSSFRow row = sheet.createRow(0);
        HSSFCellStyle  style = wb.createCellStyle();
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);  //居中

        HSSFCell cell = row.createCell(0);
        cell.setCellValue("群名");

        int count_city = reader.getCount();
        int count_suffix = suffixReader.getCount();

        Random random = new Random();
        for (int i = 0; i < 2000; i++) {
            int c = random.nextInt(count_city)%(count_city+1);
            int s = random.nextInt(count_suffix);
            System.out.println("C: " + c + "-------" + "S: " + s);
            String entry = reader.getCity(c) + suffixReader.getSuffix(s) + "群";
            System.out.println(entry);

            HSSFRow hssfRow = sheet.createRow(i+1);
            HSSFCell cell_temp = hssfRow.createCell(0);
            cell_temp.setCellValue(entry);
        }

        FileOutputStream fou = new FileOutputStream("XXXX.xls");
        wb.write(fou);
        fou.close();
        System.out.println("!!!");
    }
}
