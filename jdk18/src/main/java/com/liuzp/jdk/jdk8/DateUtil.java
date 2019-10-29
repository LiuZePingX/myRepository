package com.liuzp.jdk.jdk8;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * liuzp
 * jsk1.8新特性之时间类的处理
 */
public class DateUtil {

    public static void main(String[] args) {
        //获取当前时间
        Instant time = Instant.now();
        System.out.println(time);

        // 旧日期转为新日期  ofEpochMilli
        Instant newTime = Instant.ofEpochMilli(new Date().getTime());
        System.out.println(newTime);

        //LocalDate 获取不带时区的时间
        LocalDate date = LocalDate.now();//不带时分秒
        LocalDateTime localTime = LocalDateTime.now().minusDays(2);// 带上时分秒 将当前时间减去两天
        //LocalDateTime.of() 构造一个指定日期的对象
        System.out.println(date);
        System.out.println(localTime);

        // LocalTime
    }
}
