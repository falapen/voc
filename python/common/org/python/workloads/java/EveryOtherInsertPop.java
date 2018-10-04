package org.python.workloads.java;

import org.python.Object;
import org.python.stdlib.collections.OrderedDict;
import org.python.types.List;
import org.python.types.Str;
import org.python.types.Int;

import java.util.ArrayList;

public class EveryOtherInsertPop {
    public static void main(String args[]) {
        test();
    }

    private static void test() {
        org.python.Object[] args = {null};
        java.util.Map kwargs = new java.util.HashMap<org.python.Object, org.python.Object>();
        long start = System.nanoTime();
        OrderedDict  dict = new OrderedDict(args, kwargs);


        ArrayList<Object> tuple = new ArrayList<>(2);
        tuple.add(new Str("a"));
        tuple.add(org.python.types.Int.getInt(1L));
        //tuple_list.append(new org.python.types.Tuple(tuple));
        //Second assertion
        for (int i = 0; i < 10000000; i++) {
            if (i % 2 == 0) dict.__setitem__(org.python.types.Int.getInt(i), org.python.types.Int.getInt(i));
            if (i % 2 == 1) dict.popitem();
        }
        long end = System.nanoTime();
        System.out.println((end-start)/1000000000);

    }
}
