package org.python.workloads;

import org.python.stdlib.collections.OrderedDict;
import org.python.types.Int;

public class InsertsAndUpdatesTest{

    @org.junit.jupiter.api.Test
    void testInsertAndUpdates() {
        org.python.Object[] args = {null};
        java.util.Map kwargs = new java.util.HashMap<java.lang.String, org.python.Object>();
        long start = System.nanoTime();
        OrderedDict first = new OrderedDict(args, kwargs);
        OrderedDict second = new OrderedDict(args, kwargs);

        for (int i = 0; i < 100000; i++) {
            first.__setitem__(org.python.types.Int.getInt(i), org.python.types.Int.getInt(i));
        }

        for (int j = 0; j < 100000; j++) {
            second.__setitem__(org.python.types.Int.getInt(j), org.python.types.Int.getInt(j));
        }
        first.update(null, second);
        long end = System.nanoTime();
        System.out.println((end-start)/Math.pow(10, 9));
    }
}