package javase.concurrency.conpro;

import java.util.LinkedList;

public class Storage {
    private int MAX_SIZE = 100;
    LinkedList<Object> list = new LinkedList<>();

    public void consumer(String name) throws InterruptedException {
        synchronized (list) {
            while (list.size() == 0) {
                System.out.println("【消费者】：" + name + "不能消费,因为当前库存为" + list.size());
                list.wait();
            }
            list.remove();
            System.out.println("【消费者】：" + name + "消费，当前库存为" + list.size());
            list.notifyAll();
        }
    }

    public void producer(String name) throws InterruptedException {
        synchronized (list) {
            while (list.size() == MAX_SIZE) {
                System.out.println("【生产者】" + name + "不能生产,因为当前库存为" + list.size());
                list.wait();
            }
            list.add(new Object());
            System.out.println("【生产者】：" + name + "生产，当前库存为" + list.size());
            list.notifyAll();
        }
    }
}
