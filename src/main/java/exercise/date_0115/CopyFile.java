package exercise.date_0115;

import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * 将文件夹a(包括其中所有的文件)复制到b文件夹.
 * 要求:使用10个线程同时进行,每一个线程单独处理一个文件.
 */
public class CopyFile {

    public boolean deleteFile(File file) {
        if (!file.exists()) { // 文件不存在
            return false;
        }

        if (file.isDirectory()) { // 文件夹
            // 获取文件夹子项
            File[] subFiles = file.listFiles();
            if (subFiles == null || subFiles.length == 0) { // 空文件夹
                file.delete();
            } else {
                for (File sub : subFiles) { // 不是空文件夹
                    deleteFile(sub);
                }
            }
        }
        file.delete();
        return true;
    }

    public static void main(String[] args) throws IOException {

        File file = new File("overwater\\work\\");
        String target = "overwater\\work2\\";
        System.out.println("开始!");
        copyFile2(file, target);// 44s  7s

    }

    public static void copyFile2(File originalFile, String parentPath) throws IOException {
        if (!originalFile.exists()) {
            return;
        }
        String fileName = "\\" + originalFile.getName();
        if (!fileName.contains(".")) {
            fileName = fileName + "\\";
        }
        String copyFileName = parentPath + fileName;
        // 第一次的文件名中有两个<\\>需要转换为<\>
//        if(copyFileName.contains("\\\\")){
//            copyFileName.replaceAll("\\\\","\\");
//        }
        System.out.println("parentPath:" + parentPath);
        System.out.println("复制文件名:" + copyFileName);

        File newFile = new File(copyFileName);
        if (originalFile.isDirectory()) { // 文件夹
            newFile.mkdir();
            File[] subs = originalFile.listFiles(); // 获取子项
            for (File sub : subs) {
                copyFile2(sub, newFile.getPath());
            }
        } else {
            MyThread myThread = new MyThread(originalFile, newFile);
            Thread thread = new Thread(myThread);
            thread.start();

//            InputStream in = in = new FileInputStream(originalFile);
//            OutputStream out = out = new FileOutputStream(newFile);
//            byte[] data = new byte[1024 * 10];
//            while (in.read(data) != -1) {
//                out.write(data);
//            }
//            System.out.println(originalFile.getName() + "文件复制结束");
//            in.close();
//            out.close();
        }
    }

    static class MyThread implements Runnable {
        File originalFile;
        File newFile;

        public MyThread(File originalFile, File newFile) {
            this.originalFile = originalFile;
            this.newFile = newFile;
        }
        @Override
        public void run() {
            InputStream in = null;
            OutputStream out = null;
            try {
                in = new FileInputStream(originalFile);
                out = new FileOutputStream(newFile);
                byte[] data = new byte[1024 * 10];
                while (in.read(data) != -1) {
                    out.write(data);
                }
                System.out.println(originalFile.getName() + "文件复制结束");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    in.close();
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
