package cn.bigmeng.excle_demo.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class CityReader {
    File cityFile;
    String cityFile_str;
    String[] name_arr;

    public CityReader(String fileName) throws IOException {
        this.cityFile = new File(fileName);

        if (!cityFile.exists()) {
            throw new FileNotFoundException();
        }
        FileInputStream fin = new FileInputStream(cityFile);
        byte[] buf = new byte[fin.available()];
        try {
            fin.read(buf);
            cityFile_str = new String(buf);
            name_arr = cityFile_str.split(" ");
            for (int i = 0; i < name_arr.length; i++) {
                name_arr[i] = name_arr[i].trim();
            }
        } catch (IOException e) {
            System.out.println("字符串缓存读入失败！");
            e.printStackTrace();
        }
    }

    public String getCity(int id) throws Exception {

        if (id > name_arr.length){
            throw new Exception("超出数组大小");
        }
        return name_arr[id];
    }

    public int getCount(){
        return name_arr.length;
    }
//    public int format() {
//        String[] name_arr = cityFile_str.split(" ");
//        for (int i = 0; i < name_arr.length; i++) {
//            if (name_arr[i].indexOf("市") != -1){
//            }
//        }
//    }
}
