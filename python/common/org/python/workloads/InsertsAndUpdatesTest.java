package org.python.workloads;

import org.python.stdlib.collections.OrderedDict;
import org.python.types.Int;

public class InsertsAndUpdatesTest{

    public static void main(String[] args) {
        org.python.Object[] odArgs = {null};
        java.util.Map kwargs = new java.util.HashMap<java.lang.String, org.python.Object>();
        long start = System.nanoTime();
        OrderedDict first = new OrderedDict(odArgs, kwargs);
        OrderedDict second = new OrderedDict(odArgs, kwargs);

        for (int i = 0; i < 10000; i++) {
            first.__setitem__(org.python.types.Int.getInt(i), org.python.types.Int.getInt(i));
        }
        for (int j = 0; j < 10000; j++) {
            second.__setitem__(org.python.types.Int.getInt(j), org.python.types.Int.getInt(j));
            first.update(null, second);
        }

        //first.update(null, second);
        long end = System.nanoTime();
        System.out.println((end-start)/Math.pow(10, 9));
    }
}
