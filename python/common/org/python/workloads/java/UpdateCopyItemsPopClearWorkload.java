package org.python.workloads.java;

import org.python.stdlib.collections.OrderedDict;
import org.python.types.Bool;
import org.python.types.Dict;
import org.python.types.Int;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.concurrent.ThreadLocalRandom;

public class UpdateCopyItemsPopClearWorkload {
    public static void main(String[] args) {
        long start = System.nanoTime();
        int counter = 0;

        OrderedDict orderedDict = new OrderedDict(new org.python.Object[]{null} , new java.util.HashMap<java.lang.String, org.python.Object>());

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
                java.util.Map kwargs = new java.util.HashMap<org.python.Object, org.python.Object>();
                kwargs.put(name.toString(), Int.getInt(1));
                Dict updateDict = new Dict(new org.python.Object[]{null} , kwargs);
                orderedDict.update(null, updateDict);
            } else {
                java.util.Map kwargs = new java.util.HashMap<org.python.Object, org.python.Object>();
                kwargs.put(name.toString(), score.__add__(org.python.types.Int.getInt(1)));
                Dict updateDict = new Dict(new org.python.Object[]{null} , kwargs);
                orderedDict.update(null, updateDict);
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
                    OrderedDict d = (OrderedDict) dictIter.__next__();
                    Int multiply = Int.getInt(10);

                    org.python.Object items = d.items();
                    org.python.Object itemsIter = items.__iter__();
                    try {
                        while (true) {
                            org.python.Object keyValue = itemsIter.__next__();
                            org.python.Object k = keyValue.__getitem__(org.python.types.Int.getInt(0));
                            org.python.Object v = keyValue.__getitem__(org.python.types.Int.getInt(1));
                            java.util.Map kwargs = new java.util.HashMap<org.python.Object, org.python.Object>();
                            kwargs.put(k.toString(), v.__mul__(multiply));
                            Dict updateDict = new Dict(new org.python.Object[]{null} , kwargs);
                            d.update(null, updateDict);
                            counter++;
                            if (multiply.value > 1) {
                                multiply = (Int) multiply.__sub__(org.python.types.Int.getInt(1));
                            } else {
                                break;
                            }
                        }
                    } catch (org.python.exceptions.StopIteration | NoSuchElementException e) {
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
        System.out.println(counter);
    }
}