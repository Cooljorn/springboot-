package com.example.demo.test;

import com.example.demo.util.SoutUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipTest {
    public static String ZIP_FILE = "";
    public static String JPG_FILE = "";
    public static String FILE_NAME = "";
    public static String SUFFIX_FILE = "";
    public static long FILE_SIZE = 10;

    public static void zipFileNoBuffer() {

        File zipFile = new File(ZIP_FILE);
        try (ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(zipFile))) {
            //开始时间
            Instant beginTime = Instant.now();

            for (int i = 0; i < 10; i++) {
                try (InputStream input = new FileInputStream(JPG_FILE)) {
                    zipOut.putNextEntry(new ZipEntry(FILE_NAME + i));
                    int temp = 0;
                    while ((temp = input.read()) != -1) {
                        zipOut.write(temp);
                    }
                }
            }
            SoutUtil.betweenTimeMs(beginTime);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void zipFileChannel() {
        //开始时间
        Instant beginTime = Instant.now();
        File zipFile = new File(ZIP_FILE);
        try (ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(zipFile));
             WritableByteChannel writableByteChannel = Channels.newChannel(zipOut)) {
            for (int i = 0; i < 10; i++) {
                try (FileChannel fileChannel = new FileInputStream(JPG_FILE).getChannel()) {
                    zipOut.putNextEntry(new ZipEntry(i + SUFFIX_FILE));
                    fileChannel.transferTo(0, FILE_SIZE, writableByteChannel);
                }
            }
            SoutUtil.betweenTimeMs(beginTime);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
