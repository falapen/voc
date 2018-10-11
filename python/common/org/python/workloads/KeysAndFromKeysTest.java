package org.python.workloads;

import org.python.stdlib.collections.OrderedDict;
import org.python.types.Int;

import java.util.ArrayList;
import java.util.List;

public class KeysAndFromKeysTest {

    public static void main(String[] x) {
        List<org.python.Object> odKeys = new ArrayList<org.python.Object>();
        List<org.python.Object> odList = new ArrayList<org.python.Object>();

        org.python.Object[] args = {null};
        java.util.Map kwargs = new java.util.HashMap<java.lang.String, org.python.Object>();
        long start = System.nanoTime();
        OrderedDict orderedDict = new OrderedDict(args, kwargs);
        OrderedDict updateDict;

        for (int i=0; i<10000; i++) {
            kwargs.put(String.valueOf(i), Int.getInt(i));
            updateDict = new OrderedDict(args, kwargs);
            orderedDict.update(null, updateDict);
            kwargs.remove(String.valueOf(i));
        }

        for (int i=0; i<10000; i++) {
            odKeys.add(orderedDict.keys());
        }

        for (int i=0; i<10000; i++) {
            odList.add(OrderedDict.fromkeys(odKeys.get(i), null));
        }
        long end = System.nanoTime();
        System.out.println((end-start)/Math.pow(10, 9));
    }
}
