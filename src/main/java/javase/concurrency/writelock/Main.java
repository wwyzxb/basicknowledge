package javase.concurrency.writelock;

public class Main {
    public static void main(String[] args){
        PricesInfo pricesInfo=new PricesInfo();
        Thread read = new Thread(new Reader(pricesInfo));
        Thread writer = new Thread(new Writer(pricesInfo));

        read.start();
        writer.start();
    }

}
