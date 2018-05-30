package utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * @Author: wuxiaobing
 * @Date 2018/5/15
 **/
public class test {

    public static void main(String[] args) throws UnsupportedEncodingException {
        String sql="INSERT OVERWRITE TABLE cn_nubia_browser.wxb_test SELECT xcontext['loc_city'] AS name, count(DISTINCT xcontext['imei']) AS num FROM cn_nubia_browser.profile WHERE appid = '7f20555fecf84a469f506053fea77f22' AND xcontext['loc_country'] like '%中国%' GROUP BY xcontext['loc_city'];";
        String encodeSql=URLEncoder.encode(sql,"UTF-8");
        String decodeSql=URLDecoder.decode(encodeSql,"UTF-8");
        System.out.println(decodeSql);

    }
}
