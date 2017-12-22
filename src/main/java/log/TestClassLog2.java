package log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: wuxiaobing
 * @Date 2017/12/22
 **/
public class TestClassLog2 {
    private static Logger logger= LoggerFactory.getLogger("TestClassLog2");
    public static void main(String[] args){
        logger.info("this is a class log test:print {}",TestClassLog2.class.getSimpleName());
    }
}
