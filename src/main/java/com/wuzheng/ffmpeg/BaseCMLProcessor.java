package com.wuzheng.ffmpeg;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * @ClassName: BaseCMLProcessor
 * @Package com.wuzheng.ffmpeg
 * @Author WuZheng
 * @Date 2018/6/19 18:49
 * @Description: 创建FFmpeg原生命令行调用工具类
 */
public class BaseCMLProcessor {
    private static final Logger logger = LoggerFactory.getLogger(BaseCMLProcessor.class);

    /**
     * 处理命令行
     *
     * @param command
     * @return exitCode
     * @throws IOException
     * @throws InterruptedException
     */
    public static int process(List<String> command) throws IOException, InterruptedException {

        ProcessBuilder processBuilder = new ProcessBuilder(command);
        Process videoProcess = processBuilder.redirectErrorStream(true).start();
        BufferedReader br = new BufferedReader(new InputStreamReader(videoProcess.getInputStream()));
        String readLine;
        while (null != (readLine = br.readLine())) {
            logger.info(readLine);
        }
        return videoProcess.waitFor();
    }
}
