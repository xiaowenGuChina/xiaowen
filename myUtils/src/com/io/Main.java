package com.io;

import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        //1.指定要读 的文件目录及名称
        File file =new File("src/xixixi");
        //2.创建文件读入流对象
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        InputStreamReader reader = new InputStreamReader(fis, "utf-8");
        BufferedReader bufferedReader = new BufferedReader(reader);
        //4.定义结束标志,可用字节数组读取
        //1.指定要写到的文件目录及名称
        File targetFile =new File("src/hahaha");
        //2.创建文件读入流对象
        FileOutputStream fos =new FileOutputStream(targetFile);
        //3.创建缓冲流对象加强fos功能
        BufferedOutputStream bos=new BufferedOutputStream(fos);
        String line ;
        while((line = bufferedReader.readLine())!=null){

            //4.向流中写入数据
            try {
                bos.write(line.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        //5.关闭流
        bufferedReader.close();
        //5.刷新和关闭流
        bos.flush();
        bos.close();
    }

}
