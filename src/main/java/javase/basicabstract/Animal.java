package javase.basicabstract;

public abstract class Animal {
    /**
     * 父类的构造器会首先初始化
     */
    public Animal() {
        System.out.println("Animal constructor...");
    }

    /**
     * 1.抽象方法不能有方法体;
     * 2.抽象方法必须定义在抽象类或接口中.
     */
    public abstract void voice();

    /**
     * 抽象类可以包含普通方法
     */
    public void breath() {
        System.out.println("Animal is breathing...");
    }
}
