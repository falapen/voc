package org.python.workloads;

import org.python.stdlib.collections.OrderedDict;
import org.python.types.Int;

public class PopitemZerothItemTest {

    public static void main(String[] x) {
        org.python.Object[] args = {null};
        java.util.Map kwargs = new java.util.HashMap<java.lang.String, org.python.Object>();
        long start = System.nanoTime();
        OrderedDict orderedDict = new OrderedDict(args, kwargs);

        for (int i=0; i<50000; i++) {
            orderedDict.__setitem__(org.python.types.Int.getInt(i), org.python.types.Int.getInt(i));
        }

        for (int i=0; i<50000; i++) {
            orderedDict.popitem(org.python.types.Bool.getBool(false));
        }

        long end = System.nanoTime();
        System.out.println((end-start)/Math.pow(10, 9));
    }
}
