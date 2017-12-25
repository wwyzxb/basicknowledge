package reflect;

/**
 * @Author: wuxiaobing
 * @Date 2017/12/25
 **/
public class ClassType {

    public String publicVal1;
    public String publicVal2;
    private String privateVal1;
    private String privateVal2;

    public ClassType() {

    }

    public ClassType(String val1, String val2, String val3) {
        this.publicVal1 = val1;
        this.publicVal2 = val2;
        this.privateVal1 = val3;
    }

    private ClassType(String val1, String val2, String val3, String val4) {
        this(val1, val2, val3);
        this.privateVal2 = val4;
    }

    public void publicMethod1() {

    }

    public void publicMethod2() {

    }

    private void privateMethod1() {

    }

    private void privateMethod2() {

    }

}
