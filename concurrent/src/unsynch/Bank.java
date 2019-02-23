package unsynch;

import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bank {
    private final double[] accounts;

    private Lock bankLock = new ReentrantLock();

    private Condition sufficientFunds;

    public Bank(double[] accounts) {
        this.accounts = accounts;
    }

    public Bank(int n ,double initialBalance) {
        accounts = new double[n];
        Arrays.fill(accounts,initialBalance);
        sufficientFunds = bankLock.newCondition();
    }

    public void transfer(int from, int to, double amount) throws InterruptedException {

//        if(accounts[from] < amount) return;
//        System.out.print(Thread.currentThread());
//        accounts[from] -= amount;
//        System.out.printf("%10.2f from %d to %d", amount, from, to);
//        accounts[to] += amount;
//        System.out.printf("Total Balance : %10.2f%n",getTotalBalance());
        //ReentrantLock锁
        bankLock.lock();            //获取锁
        try {
//            if(accounts[from] < amount) return;
            while(accounts[from] < amount) sufficientFunds.await();//使用模板位在不满足什么条件是将该条件的所有线程阻塞
            System.out.print(Thread.currentThread());
            accounts[from] -= amount;
            System.out.printf("%10.2f from %d to %d", amount, from, to);
            accounts[to] += amount;
            System.out.printf("Total Balance : %10.2f%n",getTotalBalance());
            sufficientFunds.signalAll();                //接触该条件下的被阻塞的线程
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            bankLock.unlock();             //释放锁
        }
    }

    public double getTotalBalance() {
        double sum = 0;
        for (double account : accounts) {
            sum += account;
        }
        return sum;
    }

    public int size() {
        return accounts.length;
    }
}
