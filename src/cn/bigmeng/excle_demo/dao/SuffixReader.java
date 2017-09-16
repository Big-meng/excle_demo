package cn.bigmeng.excle_demo.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class SuffixReader {
    File suffix_file;
    String[] suffix_arr;

    public SuffixReader(String name) {
        this.suffix_file = new File(name);

        try {
            FileInputStream fin = new FileInputStream(suffix_file);
            byte[] buf = new byte[fin.available()];
            fin.read(buf);
            String suffix_str = new String(buf);
            suffix_arr = suffix_str.split("[\\s]+");
        } catch (FileNotFoundException e) {
            System.out.println("文件未找到！");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getSuffix(int id) {
        return suffix_arr[id];
    }

    public int getCount(){
        return suffix_arr.length;
    }
}
