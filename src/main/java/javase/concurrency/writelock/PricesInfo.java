package javase.concurrency.writelock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class PricesInfo {
	private double price1;
	private double price2;
	
	private ReadWriteLock lock;
	
	public PricesInfo(){
		//初始化
		price1=1.0;
		price2=2.0;
		lock=new ReentrantReadWriteLock();
	}

	/*获得价格的时候使用读锁来同步*/
	public double getPrice1() {
		lock.readLock().lock();
		double value=price1;
		lock.readLock().unlock();
		return value;
	}

	public double getPrice2() {
		lock.readLock().lock();
		double value=price2;
		lock.readLock().unlock();
		return value;
	}

	/*设值的时候使用写锁来同步*/
	public void setPrices(double price1, double price2) {
		lock.writeLock().lock();
		this.price1=price1;
		this.price2=price2;
		lock.writeLock().unlock();
	}
}
