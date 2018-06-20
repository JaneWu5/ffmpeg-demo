package com.wuzheng;

import com.wuzheng.ffmpeg.FFmpegMediaFormatConverter;

import java.io.IOException;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws IOException, InterruptedException {
        FFmpegMediaFormatConverter.convert("/Users/wuzheng/Desktop/bootstrap.mp4",
                "/Users/wuzheng/Desktop/bootstrap.avi");
    }
}
