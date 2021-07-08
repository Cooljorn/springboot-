package com.example.demo.test;

import com.example.demo.util.SoutUtil;
import org.junit.Test;

import java.io.*;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * 压缩文件测试
 * */
public class ZipTest {
    public static String ZIP_FILE = "D:\\out\\zip.zip";
    public static String FILE_PATH = "D:\\out\\JAVA核心知识点整理.pdf";
    public static String FILE_NAME = "111.pdf";
    public static String SUFFIX_FILE = "";
    public static long FILE_SIZE = 1;

    @Test
    public  void zipFileNoBuffer() {

        File zipFile = new File(ZIP_FILE);
        try (ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(zipFile))) {
            //开始时间
            Instant beginTime = Instant.now();
            try (InputStream input = new FileInputStream(FILE_PATH)) {
                zipOut.putNextEntry(new ZipEntry(FILE_NAME));
                int temp = 0;
                while ((temp = input.read()) != -1) {
                    zipOut.write(temp);
                }
            }

            SoutUtil.betweenTimeMs(beginTime);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void zipFileBuffer() {
        File zipFile = new File(ZIP_FILE);
        try (ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(zipFile));
             BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(zipOut)) {
            //开始时间
            Instant beginTime = Instant.now();
            try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(FILE_PATH))) {
                zipOut.putNextEntry(new ZipEntry(FILE_NAME));
                int temp = 0;
                while ((temp = bufferedInputStream.read()) != -1) {
                    bufferedOutputStream.write(temp);
                }
            }

            SoutUtil.betweenTimeMs(beginTime);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void zipFileChannel() {
        //开始时间
        Instant beginTime = Instant.now();
        File zipFile = new File(ZIP_FILE);
        try (ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(zipFile));
             WritableByteChannel writableByteChannel = Channels.newChannel(zipOut)) {
            try (FileChannel fileChannel = new FileInputStream(FILE_PATH).getChannel()) {
                zipOut.putNextEntry(new ZipEntry( FILE_NAME));
                fileChannel.transferTo(0, 10993009, writableByteChannel);
            }
            SoutUtil.betweenTimeMs(beginTime);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void fileSize(){
        //开始时间
        Instant beginTime = Instant.now();
        System.out.println(new File(FILE_PATH).length());
        SoutUtil.betweenTimeMs(beginTime);
    }
}
