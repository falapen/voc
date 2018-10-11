package org.python.workloads;

import org.python.stdlib.collections.OrderedDict;
import org.python.types.Int;
import java.util.*;

public class MixPopitemCopyClear {

    public static void main(String args[]){

        org.python.Object[] dictargs = {null};
        Map<String, org.python.Object> kwargs = new HashMap<String, org.python.Object>();
        long startTime = System.currentTimeMillis();
        OrderedDict dict = new OrderedDict(dictargs, kwargs);
        int iterations = 1500000;

        for(int i = 0; i < iterations; i++) {
            dict.__setitem__(Int.getInt(i), Int.getInt(i));
            if(i % 5 == 0){
                dict.popitem();
            }
            if(i % 10 == 0){
                dict.copy();
            }
            if(i % 15 == 0){
                dict.clear();
            }
        }
        long finishTime = System.currentTimeMillis();
        System.out.println(finishTime-startTime);

    }

}
