package javase.classinfo.reflect;

/**
 * @Author Vincent
 * @Date 2017/12/17 15:38
 */
public class User {
    private String id;

    private void say(String name) {
        System.out.println("say hello to " + name);
    }

    public String getId() {
        return id;
    }
}
