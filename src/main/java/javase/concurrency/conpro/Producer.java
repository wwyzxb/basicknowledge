package javase.concurrency.conpro;

public class Producer extends Thread {
    private Storage storage;
    private String name;

    public Producer(Storage storage, String name) {
        this.storage = storage;
        this.name=name;
    }

    public void producer() throws InterruptedException {
        storage.producer(name);
    }

    @Override
    public void run() {
        while (true) {
            try {
                this.producer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
