package com.wuzheng.ffmpeg;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @ClassName: BaseFFmpegCliUtils
 * @Package com.wuzheng.ffmpeg
 * @Author WuZheng
 * @Date 2018/6/19 18:49
 * @Description: 创建FFmpeg原生命令行调用工具类
 */
public class BaseFFmpegCliUtils {
    private static final Logger logger = LoggerFactory.getLogger(BaseFFmpegCliUtils.class);
    private static final String FFMPEG_CLI_PATH;

    private BaseFFmpegCliUtils() {
    }

    static {
        InputStream inputStream = BaseFFmpegCliUtils.class.getClassLoader()
                .getResourceAsStream("ffmpeg.config.properties");
        Properties prop = new Properties();
        try {
            prop.load(inputStream);
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
        FFMPEG_CLI_PATH = prop.getProperty("ffmpeg.cli.path");
        File ffmpegCli = new File(FFMPEG_CLI_PATH);
        if (!ffmpegCli.isFile()) {
            logger.error("Fail to find ffmpeg command line!");
            throw new IllegalStateException();
        }
    }

    public static boolean execute(String... command) {
        ProcessBuilder processBuilder = new ProcessBuilder(command);
        return true;

    }
}
