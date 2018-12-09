package log;

import org.apache.log4j.Logger;

/**
 * @Author: wuxiaobing
 * @Date 2017/12/21
 **/
public class Log4jTest {
    private static Logger logger = Logger.getLogger(Log4jTest.class);

    public static void test() {
        logger.info("this is a log4j info udclassloader...");
    }

    public static void main(String[] args) {
        test();
    }



}
