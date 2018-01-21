package javase.java8.lambda.funinterface.ud;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @Author Vincent
 * @Date 2018/1/21 16:54
 */
public class ReaderProcess {
    /**
     * 定义一个方法用来处理函数式接口中的抽象方法
     *
     * @param processor
     * @return
     * @throws IOException
     */
    private String processFile(BufferedReaderProcessor processor) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(new File("E:\\code\\IdeaProjects\\basicknowledge\\src\\main\\resources\\log4j.properties")))) {
            return processor.process(br);
        }
    }

    @Test
    public void testReadOneLine() throws IOException {
        /**
         * 使用Lambda表达式来进行函数式调用
         */
        String oneLine = processFile((BufferedReader br) -> br.readLine());
        System.out.println(oneLine);
    }

    @Test
    public void testReadTwoLine() throws IOException {
        String twoLine = processFile((BufferedReader br) -> br.readLine() + "\r\n" + br.readLine());
        System.out.println(twoLine);
    }

    @Test
    public void testReadOneLine1() throws IOException {
        BufferedReaderProcessor processor = new BufferedReaderProcessor() {
            @Override
            public String process(BufferedReader br) throws IOException {
                return br.readLine();
            }
        };
        /**
         * processor::process进行函数式调用
         */
        String oneLine = processFile(processor::process);
        System.out.println(oneLine);
    }
}
