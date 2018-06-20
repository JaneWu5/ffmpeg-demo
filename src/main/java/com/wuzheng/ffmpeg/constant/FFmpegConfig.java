package com.wuzheng.ffmpeg.constant;

import com.wuzheng.ffmpeg.BaseCMLProcessor;
import com.wuzheng.ffmpeg.exception.FFmpegException;
import com.wuzheng.ffmpeg.exception.constants.ErrorCodeEnum;
import com.wuzheng.ffmpeg.util.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @ClassName: FFmpegConfig
 * @Package com.wuzheng.ffmpeg.constant
 * @Author WuZheng
 * @Date 2018/6/20 14:31
 * @Description: 读取FFmpeg相关配置
 */
public class FFmpegConfig {
    private static final Logger logger = LoggerFactory.getLogger(FFmpegConfig.class);
    public static final String FFMPEG_CML_PATH;

    static {
        InputStream inputStream = BaseCMLProcessor.class.getClassLoader()
                .getResourceAsStream("ffmpeg.config.properties");
        Properties prop = new Properties();
        try {
            prop.load(inputStream);
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
        FFMPEG_CML_PATH = prop.getProperty("ffmpeg.cli.path");
        if (!FileUtils.checkFile(FFMPEG_CML_PATH)) {
            logger.error("Fail to find ffmpeg command line!");
            throw new FFmpegException(ErrorCodeEnum.FILE_PATH_ERROR);
        }
    }
}
