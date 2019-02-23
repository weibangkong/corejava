package blockingQueue;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueTest {

    private static final int FILE_QUEUE_SIZE = 10;
    private static final int SEARCH_THREADS = 100;
    private static final File DUMMY = new File("");
    private static final BlockingQueue<File> queue = new ArrayBlockingQueue<>(FILE_QUEUE_SIZE);

    public static void main(String[] args) {
        try(Scanner in = new Scanner(System.in)){
            System.out.println("Enter base directory (e.g. /opt/jdk1.8.0/src):");
            String directory = in.nextLine();
            System.out.println("Enter keyword (e.g. volatile):'");
            String keyword = in.nextLine();
            System.out.println(directory+":"+keyword);
            Runnable enumrate = () ->{
                try {
                    enumrate(new File(directory));
                    queue.put(DUMMY);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };

            new Thread(enumrate).start();
            for (int i = 0; i < SEARCH_THREADS; i++) {
                Runnable searcher = () ->{
                    try{
                        boolean done = false;
                        while (!done) {
                            File file = queue.take();
                            if (file == DUMMY) {
                                queue.put(file);
                                done = true;
                            }else {
                                search(file,keyword);
                            }
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                };
                new Thread(searcher).start();
            }
        }
    }

    public static void enumrate(File directory) throws InterruptedException {
        File[] files = directory.listFiles();
        for (File file : files) {
            if(file.isDirectory()) enumrate(file);
            else queue.put(file);
        }
    }

    public static void search(File file,String keyword) {
        try (Scanner in = new Scanner(file,"UTF-8")){//自动资源管理，要求对象实现AutoCloseable
            int lineNumber = 0;
            while (in.hasNext()) {
                lineNumber++;
                String line = in.nextLine();
                if(line.contains(keyword)) System.out.printf("%s:%d:%s%n",file.getPath(),lineNumber,line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
