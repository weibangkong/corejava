package atomicLogTest;


import java.util.concurrent.atomic.AtomicLong;

public class main {
    public static void main(String[] args) {
        AtomicLong largest = new AtomicLong(1900);
        System.out.println(largest.get());
    }
}
