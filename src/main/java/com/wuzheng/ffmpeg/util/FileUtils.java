package com.wuzheng.ffmpeg.util;

import java.io.File;

/**
 * @ClassName: FileUtils
 * @Package com.wuzheng.ffmpeg.util
 * @Author WuZheng
 * @Date 2018/6/20 10:10
 * @Description: 文件相关的工具类
 */
public class FileUtils {
    private FileUtils() {
    }

    public static boolean checkFile(String path) {
        if (path == null) {
            return false;
        }
        File file = new File(path);
        return file.isFile();
    }
}
