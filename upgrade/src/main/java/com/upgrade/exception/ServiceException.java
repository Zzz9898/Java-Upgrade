package com.upgrade.exception;

/**
 * @Author zhangjiaw
 * @Date 2022/5/24 22:03
 */
public class ServiceException extends RuntimeException{
    public ServiceException(String s) {
        super(s);
    }
}
