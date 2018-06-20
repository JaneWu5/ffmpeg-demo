package com.wuzheng.ffmpeg.exception.constants;

/**
 * @ClassName: ErrorCodeEnum
 * @Package com.wuzheng.ffmpeg.exception.constant
 * @Author WuZheng
 * @Date 2018/6/20 10:28
 * @Description: 错误码定义
 */
public enum ErrorCodeEnum {
    FILE_PATH_ERROR(1001, "找不到路径：ffmpeg路径有误！");

    ErrorCodeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private int code;
    private String msg;

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
