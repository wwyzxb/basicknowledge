package javase.java8.lambda.funinterface.ud;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * 定义一个函数式接口
 * @Author Vincent
 * @Date 2018/1/21 16:51
 */
public interface BufferedReaderProcessor {
    String process(BufferedReader br) throws IOException;
}
