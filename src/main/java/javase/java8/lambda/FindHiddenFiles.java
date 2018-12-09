package javase.java8.lambda;

import com.google.common.io.ByteStreams;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.junit.Test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.StreamingOutput;
import java.io.*;

/**
 * @Author: wuxiaobing
 * @Date 2018/1/20
 **/
public class FindHiddenFiles {
    /**示例1：
     *
     */
    @Test
    public void testHiddenFiles() {
        File targetFile = new File("c:\\");
        //找出C盘中的隐藏文件夹
        File[] hiddenFiles = targetFile.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isHidden();
            }
        });
        for (File file : hiddenFiles) {
            System.out.println(file.getName());
        }
    }

    @Test
    public void testHiddenFilesInJava8_1() {
        File targetFile = new File("c:\\");
        //第一部分：File为借口方法中的入参
        //第二部分：isHidden为File中定义的方法
        File[] hiddenFiles = targetFile.listFiles(File::isHidden);
        for (File file : hiddenFiles) {
            System.out.println(file.getName());
        }
    }

    @Test
    public void testHiddenFilesInJava8_2() {
        File targetFile = new File("c:\\");
        //第一部分：为接口方法中的参数
        //第二部分：为方法体
        File[] hiddenFiles = targetFile.listFiles((File pathname) -> pathname.isHidden());
        for (File file : hiddenFiles) {
            System.out.println(file.getName());
        }
    }

    /**
     * 示例2
     */
    public void writeToResponse(HttpServletRequest request, HttpServletResponse response) throws IOException {
        InputStream input = new FileInputStream(new File("C:\\"));
        StreamingOutput streamingOutput = new StreamingOutput() {
            @Override
            public void write(OutputStream outputStream) throws IOException, WebApplicationException {
                try {
                    ByteStreams.copy(input, outputStream);
                } finally {
                    outputStream.flush();
                    outputStream.close();
                    if (input != null) {
                        input.close();
                    }
                }
            }
        };
        streamingOutput.write(response.getOutputStream());
    }

    public void writeToResponseInLambda(HttpServletRequest request, HttpServletResponse response) throws IOException {
        InputStream input = new FileInputStream(new File("C:\\"));
        //第一部分：
        //第二部分：
        StreamingOutput streamingOutput = (OutputStream outputStream) -> writeTo(input, outputStream);
        streamingOutput.write(response.getOutputStream());
    }

    public void writeTo(InputStream input, OutputStream outputStream) throws IOException {
        try {
            ByteStreams.copy(input, outputStream);
        } finally {
            outputStream.flush();
            outputStream.close();
            if (input != null) {
                input.close();
            }
        }
    }

}
