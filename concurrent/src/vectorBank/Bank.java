package vectorBank;

import java.util.Arrays;
import java.util.Vector;

public class Bank {

    private final Vector<Double> accounts;

    public Bank(int n, double initialBalance){
        accounts = new Vector<>(n);
        for (int i = 0; i < n; i++) {
            accounts.set(i, initialBalance);
        }
    }

    public void trantsfer(Vector<Double> accounts, int from, int to, int amount) {
        accounts.set(from, accounts.get(from) - amount);
        accounts.set(to, accounts.get(to) + amount);
        System.out.printf("%10.2f from %d to %d",amount,from,to);
    }

    public double getTotalBalance() {
        double sum = 0;
        for (Double account : accounts) {
            sum += account;
        }
        return sum;
    }

    public int size() {
        return accounts.size();
    }
}
