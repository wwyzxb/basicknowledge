package javase.concurrency.conpro;

public class Consumer extends Thread {
    private Storage storage;
    private String name;

    public Consumer(Storage storage, String name) {
        this.storage = storage;
        this.name=name;
    }

    public void consumer() throws InterruptedException {
        storage.consumer(name);
    }

    @Override
    public void run() {
        while (true) {
            try {
                this.consumer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
