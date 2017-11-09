package common.utils;

import java.text.SimpleDateFormat;
import java.util.TimeZone;

/**
 * @Author: wuxiaobing
 * @Date 2017/11/9
 **/
public class DateUtils {
    /**
     * 将秒转换成"时:分:秒"
     *
     * @param second
     * @return
     */
    public static String convertSecondToHHmmss(int second) {
        long ms = second * 1000;
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        //设置时区，跳过此步骤会默认设置为"GMT+08:00" 得到的结果会多出来8个小时
        format.setTimeZone(TimeZone.getTimeZone("GMT+00:00"));
        return format.format(ms);
    }

    public static void main(String[] args) {
        System.out.println(convertSecondToHHmmss(76));
    }
}
