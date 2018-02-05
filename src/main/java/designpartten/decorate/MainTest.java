package designpartten.decorate;

/**
 * @Author Vincent
 * @Date 2018/2/1 23:33
 */
public class MainTest {
    public static void main(String[] args){
        HouseBlend houseBlend=new HouseBlend();
        Mocha mocha=new Mocha(houseBlend);
        Soy soy=new Soy(mocha);

        System.out.println(soy.getDescription());
        System.out.println(soy.cost());

    }
}
