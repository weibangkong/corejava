package iftest;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.LongAdder;

public class MainTest {
    public static void main(String[] args) {
        Map<String, LongAdder> words = new HashMap<>();
        System.out.println(new LongAdder());
        words.computeIfAbsent("english",k->new LongAdder()).increment();
    }
}
