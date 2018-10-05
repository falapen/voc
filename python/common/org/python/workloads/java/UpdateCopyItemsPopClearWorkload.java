package org.python.workloads.java;

import org.python.types.Bool;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.concurrent.ThreadLocalRandom;

public class UpdateCopyItemsPopClearWorkload {
    public static void main(String[] args) {
        long start = System.nanoTime();

        org.python.stdlib.collections.OrderedDict orderedDict = new org.python.stdlib.collections.OrderedDict(new org.python.Object[]{null} , new java.util.HashMap<java.lang.String, org.python.Object>());

        java.util.List<org.python.Object> _names = Arrays.asList(new org.python.types.Str("Harry"), new org.python.types.Str("Ross"),
            new org.python.types.Str("Bruce"), new org.python.types.Str("Cook"), new org.python.types.Str("Carolyn"),
            new org.python.types.Str("Morgan"), new org.python.types.Str("Albert"), new org.python.types.Str("Walker"),
            new org.python.types.Str("Randy"), new org.python.types.Str("Reed"), new org.python.types.Str("Larry"),
            new org.python.types.Str("Barnes"), new org.python.types.Str("Lois"), new org.python.types.Str("Wilson"),
            new org.python.types.Str("Jesse"), new org.python.types.Str("Campbell"), new org.python.types.Str("Ernest"),
            new org.python.types.Str("Rogers"), new org.python.types.Str("Theresa"), new org.python.types.Str("Patterson"),
            new org.python.types.Str("Henry"), new org.python.types.Str("Simmons"), new org.python.types.Str("Michelle"),
            new org.python.types.Str("Perry"), new org.python.types.Str("Frank"), new org.python.types.Str("Butler"));
        org.python.types.List names = new org.python.types.List(_names);


        for (int i = 0; i < 10000; i++) {
            org.python.Object name = names.__getitem__(org.python.types.Int.getInt(ThreadLocalRandom.current().nextInt(0, 25 + 1)));
            org.python.Object score = orderedDict.get(name, null);
            if (score == org.python.types.NoneType.NONE) {
                orderedDict.__setitem__(name, org.python.types.Int.getInt(1));
            } else {
                orderedDict.__setitem__(name, score.__add__(org.python.types.Int.getInt(1)));
            }
        }

        org.python.types.List dicts = new org.python.types.List();
        for (int i = 0; i < 10000; i++) {
            dicts.append(orderedDict.copy());
        }

        for (int i = 0; i < 10; i++) {
            org.python.Object dictIter = dicts.__iter__();
            try {
                while (true) {
                    org.python.stdlib.collections.OrderedDict d = (org.python.stdlib.collections.OrderedDict) dictIter.__next__();
                    org.python.types.Int multiply = org.python.types.Int.getInt(10);

                    org.python.types.Iterator itemsIter = (org.python.types.Iterator) d.items().__iter__();
                    try {
                        while (true) {
                            org.python.Object keyValue = itemsIter.__next__();
                            org.python.Object k = keyValue.__getitem__(org.python.types.Int.getInt(0));
                            org.python.Object v = keyValue.__getitem__(org.python.types.Int.getInt(1));
                            d.__setitem__(k, v.__mul__(multiply));

                            if (multiply.value > 1) {
                                multiply.__sub__(org.python.types.Int.getInt(1));
                            }

                            if (org.python.types.Int.getInt(ThreadLocalRandom.current().nextInt(0, 1 + 1))
                                .__mod__(org.python.types.Int.getInt(2))
                                .__eq__(org.python.types.Int.getInt(0)) == Bool.TRUE) {
                                d.popitem(Bool.TRUE);
                            } else {
                                d.popitem(Bool.FALSE);
                            }
                        }
                    } catch (org.python.exceptions.StopIteration | NoSuchElementException e) {
                    }
                }
            } catch (org.python.exceptions.StopIteration | NoSuchElementException e) {
            }
        }



        org.python.Object dictIter = dicts.__iter__();
        try {
            while (true) {
                org.python.stdlib.collections.OrderedDict d = (org.python.stdlib.collections.OrderedDict) dictIter.__next__();
                d.clear();
            }
        } catch (org.python.exceptions.StopIteration | NoSuchElementException e) {
        }

        long end = System.nanoTime();
        System.out.println((end-start)/1000000000.0);
    }
}
