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

        for (int k = 0; k < 150; k++){
            for (int i = 0; i < 10000; i++) {
                org.python.types.Dict kwargs2 = new org.python.types.Dict();
                kwargs2.__setitem__(org.python.types.Int.getInt(i), org.python.types.Int.getInt(i));
                dict.update(null, kwargs2);
            }
            for (int i = 0; i < 10000; i++) {
                dict.popitem();
            }
        }
        long end = System.nanoTime();
        System.out.println((end-start)/1000000000.0);

    }
}
