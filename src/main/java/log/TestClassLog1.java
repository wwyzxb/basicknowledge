package log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: wuxiaobing
 * @Date 2017/12/22
 **/
public class TestClassLog1 {
    //通过name对应不同的logger对象
    private static Logger logger= LoggerFactory.getLogger("TestClassLog1");
    public static void main(String[] args){
        logger.info("this is a class log test:print {}",TestClassLog1.class.getSimpleName());
    }
}
