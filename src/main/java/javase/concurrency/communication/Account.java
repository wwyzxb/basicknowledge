package javase.thread.communication;

import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {
	//��ʽ����Lock����
	private final Lock lock = new ReentrantLock();
	//���ָ��Lock�����Ӧ����������
	private final Condition cond = lock.newCondition();
	
	private String accountNo;
	private double balance;
	//��ʶ�˻����Ƿ��Ѿ����ı�־
	private boolean flag = false;

	public Account() {
	}

	public Account(String accountNo, double balance) {
		this.accountNo = accountNo;
		this.balance = balance;
	}

	public double getBalance() {
		return this.balance;
	}
	
	public void draw(double drawAmount) {
		//����
		lock.lock();
		try {
			//����˻���û�д����̵߳ȴ�
			if (!flag) {
				cond.await();
			} else {
				//ִ��ȡǮ����
				System.out.println(Thread.currentThread().getName() + "ȡǮ��"
						+ drawAmount);
				balance -= drawAmount;
				System.out.println("�˻����Ϊ��" + balance);
				flag=false;
				//����Lock����������߳�
				cond.signalAll();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			lock.unlock();
		}
	}
	
	public void deposit(double depositAmount) {
		lock.lock();
		try {
			//����˻����Ѿ���������̵߳ȴ�
			if(flag){
				cond.await();
			}else {
				//ִ�д�����
				System.out.println(Thread.currentThread().getName()+"��"+depositAmount);
				balance+=depositAmount;
				System.out.println("�˻����Ϊ��"+balance);
				flag=true;
				cond.signalAll();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			lock.unlock();
		}
	}
}
