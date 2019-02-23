package callabletest;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("main"+Thread.currentThread().getThreadGroup()+"--"
                +Thread.currentThread().getId()+"--"+Thread.currentThread().getName());

        Callable<Integer> callable = ()->{
//            System.out.println("Callable Interface test");

            Runnable r = () -> {
                System.out.println("runnable:"+Thread.currentThread().getThreadGroup()+"--"
                        +Thread.currentThread().getId()+"--"+Thread.currentThread().getName());

            };
            Thread minminThread = new Thread(r);
            minminThread.start();
            minminThread.join();
            return new Integer(1);
        };

        FutureTask oneTask = new FutureTask(callable);
        Thread thread = new Thread(oneTask);
        thread.start();
        thread.join();
        System.out.println("Callable:"+thread.getThreadGroup()+"--"+thread.getId()+"--"+thread.getName());
    }
}
