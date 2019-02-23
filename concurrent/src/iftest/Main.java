package iftest;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.LongAdder;

public class Main {
    public static void main(String[] args) {
        ConcurrentHashMap<String, LongAdder> incr = new ConcurrentHashMap<>();
        HashMap<String, Long> map = new HashMap<>();
        Scanner in = new Scanner(System.in);
        int maxtimes = 3;
        int count = 0;
        do {
            System.out.println("please your word:");
            String word = in.nextLine();
            /**
             * put
             * putifAbsent
             * compute
             * computeIfAbsent  --  计算
             * computeIfPresent
             */
//            incr.putIfAbsent(word, new LongAdder());//如果不存在就新增进去
            incr.computeIfAbsent(word, k -> new LongAdder()).increment();//执行增加
            Long newValue = 1L;
//            incr.computeIfPresent(word,(k,v)-> incr.get(k) +v);
            count ++;
        } while (count<3);
        Set<Map.Entry<String,LongAdder>> entrySet = incr.entrySet();
        for (Map.Entry<String,LongAdder> entry : entrySet) {
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
    }
}
