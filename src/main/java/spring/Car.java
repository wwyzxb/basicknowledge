package spring;

/**
 * @Author: wuxiaobing
 * @Date 2018/3/2
 **/
public class Car {
    private String brand;
    private double price;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void init(){
        System.out.println("this is an init method...");
    }

    public void destroy(){
        System.out.println("this is an destroy method...");
    }
}
