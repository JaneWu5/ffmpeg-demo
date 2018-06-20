package com.wuzheng.ffmpeg;

import com.wuzheng.ffmpeg.constant.FFmpegConfig;
import com.wuzheng.ffmpeg.exception.FFmpegException;
import com.wuzheng.ffmpeg.exception.constants.ErrorCodeEnum;
import com.wuzheng.ffmpeg.util.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: FFmpegMediaFormatConverter
 * @Package com.wuzheng.ffmpeg
 * @Author WuZheng
 * @Date 2018/6/20 11:18
 * @Description: 媒体格式转换工具类
 */
public class FFmpegMediaFormatConverter {
    private static final Logger logger = LoggerFactory.getLogger(FFmpegMediaFormatConverter.class);


    public static int convert(String inputPath, String outputPath) throws IOException, InterruptedException {
        if (!FileUtils.checkFile(inputPath) || outputPath == null) {
            logger.error("Wrong file path: " + inputPath + " or " + outputPath);
            throw new FFmpegException(ErrorCodeEnum.FILE_PATH_ERROR);
        }
        List<String> command = new ArrayList<>();
        command.add(FFmpegConfig.FFMPEG_CML_PATH);
        command.add("-i");
        command.add(inputPath);
        command.add(outputPath);
        return BaseCMLProcessor.process(command);
    }
}
