package javase.jvm.memory;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Vincent
 * @Date 2017/11/27 22:55
 */
public class HeapOOM {
    static class OOMObject {

    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        while (true) {
            list.add(new OOMObject());
        }
    }
}
