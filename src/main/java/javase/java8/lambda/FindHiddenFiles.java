package javase.java8.lambda;

import org.junit.Test;

import java.io.File;
import java.io.FileFilter;

/**
 * @Author: wuxiaobing
 * @Date 2018/1/20
 **/
public class FindHiddenFiles {
    @Test
    public void testHiddenFiles(){
        /**
         * 使用了匿名内部类
         * */
        File[] hiddenFiles=new File(".").listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isHidden();
            }
        });

        for(File file:hiddenFiles){
            System.out.println(file.getName());
        }
    }

    @Test
    public void testHiddenFilesInJava8(){
        /**
         * File::isHidden创建了一个方法引用
         * */
        File[] hiddenFiles=new File(".").listFiles(File::isHidden);
        for(File file:hiddenFiles){
            System.out.println(file.getName());
        }
    }
}
