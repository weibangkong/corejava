package com.kwb.day16;

import java.time.LocalDate;

public class PairTest {
    public static void main(String[] args) {
        Manager ceo = new Manager("Hello", 80000, LocalDate.of(2018, 12 - 1, 10), 200000);
        Manager cef = new Manager("World", 70000, LocalDate.of(2018, 12 - 1, 12), 180000);
        Pair<Manager> buddies = new Pair(ceo, cef);
//        printBuddies(buddies);

        ceo.setBonus(1000000);
        cef.setBonus(800000);
        Manager[] managers = {ceo, cef};

        Pair<Employee> result = new Pair<>();
//        minmaxBonus(managers,result);
        System.out.println("first:"+result.getFirst().getName()+",second:"+result.getSecond().getName());
//        maxminBonus(managers,result);
        System.out.println("first:"+result.getFirst().getName()+",second:"+result.getSecond().getName());
    }

    public static void printBuddies(Pair<? extends Employee> pair) {
        Employee first = pair.getFirst();
        Employee second = pair.getSecond();
        System.out.println(first.getName() + " and " + second.getName() + " are buddies");
    }

    public static void minmaxBonus(Manager[] a, Pair<? super Manager> pair) {
        if(a.length == 0) return;
        Manager max = a[0];
        Manager min = a[0];
        for (int i = 0; i < a.length; i++) {
            if(max.getBonus() < a[i].getBonus()) max = a[i];
            if(min.getBonus() > a[i].getBonus()) min = a[i];
        }
        pair.setFirst(min);
        pair.setSecond(max);
    }

    public static <T> void maxminBonus(Manager[] a, Pair<? super Manager> pair) {
        minmaxBonus(a, pair);
        PairAlg.swap(pair);
    }
}
