package designpartten.decorate;

/**
 * @Author Vincent
 * @Date 2018/2/1 23:23
 */
public abstract class Beverage {
    String description = "Unknown Beverage";
    private double size;

    public String getDescription() {
        return description;
    }

    public abstract double cost();

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }
}
