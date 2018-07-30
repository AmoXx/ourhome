package com.xinlizz.oh.utils;

import java.util.Base64;

/**
 * PasswordEnOrDescUtil 密码加密解密工具 
 *
 * @Author: xinlizz
 * @Date: 2018/7/14
 */
public class PasswordEnOrDescUtil {

    /**
     * 加密
     *
     * @author xinlizz
     * @Date 2018/7/14
     * @Param [password]
     * @return java.lang.String
     */
    public static String encodePassword(String password) {
        byte[] bytes = Base64.getEncoder().encode(password.getBytes());
        return new String(bytes);
    }

    /**
     * 解密
     *
     * @author xinlizz
     * @Date 2018/7/14
     * @Param [password]
     * @return java.lang.String
     */
    public static String decodePassword(String password) {
        byte[] bytes = Base64.getDecoder().decode(password.getBytes());
        return new String(bytes);
    }

    public static void main(String[] args) {
        System.out.println(encodePassword("zxc"));
        System.out.println(decodePassword("enhj"));
    }
}
