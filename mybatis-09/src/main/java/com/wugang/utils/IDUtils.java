package com.wugang.utils;

import org.junit.Test;

import java.util.UUID;

/**
 * @author wugang
 * @date 2022/4/16 15:02
 */
public class IDUtils {
    /**
     * 获取一个ID
     *
     * @return
     */
    public static String getId() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    @Test
    public void test(){
        System.out.println(getId());
    }
}
