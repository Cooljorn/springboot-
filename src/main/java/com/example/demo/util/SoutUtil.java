package com.example.demo.util;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class SoutUtil {
    public static void betweenTimeMs(Instant beginTime){
        // 纳秒值：ChronoUnit.NANOS.between(now, Instant.now());
        long used = ChronoUnit.MILLIS.between(beginTime, Instant.now());
        System.out.println("方法用时："+used+"ms");
    }
}
