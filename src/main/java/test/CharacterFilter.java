package test;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: wuxiaobing
 * @Date 2018/3/7
 **/
@Slf4j
public class CharacterFilter {
    private void filterTabInContext(Map<String, String> context) {
        for (String key : context.keySet()) {
            context.put(key, filterTab(context.get(key)));
        }
    }

    private String filterTab(String value) {
        if (value != null && value.contains("\t")) {
            value = value.replaceAll("\t", "    ");
        }
        return value;
    }

    private void readFileToContext(Map<String, String> context) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(new File("C:\\test.txt")));
            String line = reader.readLine();
            while (line != null) {
                String[] pair = line.split(" ");
                if (pair.length == 2) {
                    context.put(pair[0], pair[1]);
                }
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            log.error("the given read file is not exist", e);
            System.exit(0);
        } catch (IOException e) {
            log.error("read error", e);
            System.exit(0);
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                log.error("reader closed error", e);
                System.exit(0);
            }
        }
    }

    public void writeContextToFile(Map<String, String> context) {
        try {
            OutputStream os = new FileOutputStream(new File("C:\\result.txt"));
            for (String key : context.keySet()) {
                String line = key + " " + context.get(key) + "\r\n";
                os.write(line.getBytes());
            }
            os.flush();
            os.close();
        } catch (FileNotFoundException e) {
            log.error("the given write file is not exist", e);
            System.exit(0);
        } catch (IOException e) {
            log.error("write error", e);
            System.exit(0);
        }
    }

    @Test
    public void testFilter() {
        Map<String, String> context = new HashMap<>();
        readFileToContext(context);
        System.out.println(context);
        filterTabInContext(context);
        System.out.println(context);
        writeContextToFile(context);
    }
}
