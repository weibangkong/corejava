package executor.threadPool;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.io.File;
import java.util.Scanner;
import java.util.concurrent.*;

public class ThreadPoolTest {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            System.out.println("Enter the directory (e.g. /usr/local/jdk8.0/src):");
            String directory = in.nextLine();
            System.out.println("Enter the keyword (e.g. volatile):");
            String keyword = in.nextLine();

            ExecutorService pool = Executors.newCachedThreadPool();//获取线程池
            MatchCounter counter = new MatchCounter(new File(directory), keyword, pool);//创建任务
            Future<Integer> result = pool.submit(counter);//提交任务
            try {
                System.out.println(result.get()+" matching files.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            pool.shutdown();//关闭线程池
            int largestPoolSize = ((ThreadPoolExecutor) pool).getLargestPoolSize();
            System.out.println("largest pool size = " + largestPoolSize);
        }
    }
}
