package javase.basicabstract;

import org.apache.log4j.Logger;

public class MainTest {
    private static Logger logger=Logger.getLogger(MainTest.class);
    public static void main(String[] args) {
        Animal cat = new Cat();
        cat.breath();
        cat.voice();
        System.out.println("-------------");
        Animal dog = new Dog();
        dog.breath();
        dog.voice();
        System.out.println("-------------");
        Animal animal = new Animal() {
            @Override
            public void voice() {
                System.out.println("Animal voice...");
            }
        };
        animal.voice();
        logger.info("Animal voice...");
    }
}
