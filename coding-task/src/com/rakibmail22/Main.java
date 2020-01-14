package com.rakibmail22;

import com.rakibmail22.datastructure.Queue;
import com.rakibmail22.datastructure.immutable.ImmutableQueue;

public class Main {

    public static void main(String[] args) {

        Queue<Integer> a = new ImmutableQueue<>();

        Queue<Integer> b = a.enQueue(1);
        Queue<Integer> c = b.enQueue(2);
        Queue<Integer> d = c.enQueue(3);

        while (!d.isEmpty()) {
            System.out.println(d.head());
            d = d.deQueue();
        }

        System.out.println("************");

        Queue<Integer> e = d.enQueue(4);
        Queue<Integer> f = e.enQueue(5);
        Queue<Integer> g = f.enQueue(6);

        while (!g.isEmpty()) {
            System.out.println(g.head());
            g = g.deQueue();
        }

        System.out.println(d.head());
    }
}
