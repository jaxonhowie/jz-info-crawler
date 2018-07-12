package org.jz.utils;

import java.util.Random;
import java.util.UUID;

/**
 * @author Hongyi Zheng
 * @date 2018/7/12
 */
public class RandomUtils {

    private static Random rd = new Random();

    public static Long getLongKey(){
        return rd.nextLong();
    }

    public static String genUUID(){
        UUID uuid = UUID.randomUUID();
        String str = uuid.toString();
        int p = 0;
        int j = 0;
        char[] buf = new char[32];
        while (p < str.length()) {
            char c = str.charAt(p);
            p += 1;
            if (c == '-') {
                continue;
            }
            buf[j] = c;
            j += 1;
        }
        return new String(buf);
    }
}
