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
    private String processFile() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(new File(ClassLoader.getSystemResource("data.txt").getFile())))) {
            return br.readLine();
        }
    }

    /**
     * 定义一个方法用来实现读取文件的逻辑
     *
     * @param processor
     * @return
     * @throws IOException
     */
    private String processFile(BufferedReaderProcessor processor) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(new File(ClassLoader.getSystemResource("data.txt").getFile())))) {
            /**具体的process方法交由运行时动态实现*/
            return processor.process(br);
        }
    }

    @Test
    public void testReadFile() throws IOException {
        String line = processFile();
        System.out.println(line);
    }

    /**
     * 使用Lambda表达式来进行函数式调用
     */
    @Test
    public void testReadFile1() throws IOException {
        String oneLine = processFile((BufferedReader br) -> br.readLine());
        System.out.println(oneLine);
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
