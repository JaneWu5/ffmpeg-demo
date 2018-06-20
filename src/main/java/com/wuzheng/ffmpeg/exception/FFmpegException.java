package com.wuzheng.ffmpeg.exception;

import com.wuzheng.ffmpeg.exception.constants.ErrorCodeEnum;

/**
 * @ClassName: FFmpegException
 * @Package com.wuzheng.ffmpeg.exception
 * @Author WuZheng
 * @Date 2018/6/20 10:26
 * @Description: 和FFMpeg的处理相关的Exception
 */
public class FFmpegException extends RuntimeException {
    public FFmpegException() {
        super();
    }

    public FFmpegException(String message) {
        super(message);
    }

    public FFmpegException(String message, Throwable cause) {
        super(message, cause);
    }

    public FFmpegException(ErrorCodeEnum errorCodeEnum) {
        super(errorCodeEnum.getMsg());
    }

    public FFmpegException(ErrorCodeEnum errorCodeEnum, Throwable cause) {
        super(errorCodeEnum.getMsg(), cause);
    }
}
