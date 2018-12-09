package javase.concurrency.conpro;

public class Main {
    public static void main(String[] args) {
        Storage storage = new Storage();
        Consumer consumer = new Consumer(storage, "cosumer1");
        Producer producer = new Producer(storage, "producer1");
        consumer.start();
        producer.start();

    }
}
