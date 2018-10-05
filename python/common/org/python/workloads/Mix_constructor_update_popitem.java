package org.python.workloads;

import org.python.stdlib.collections.OrderedDict;
import org.python.types.List;
import org.python.types.Str;
import java.util.*;


public class Mix_constructor_update_popitem {

    public static void main(String args[]){

        org.python.Object[] dictargs = {null};
        Map<String, org.python.Object> kwargs = new HashMap<String, org.python.Object>();
        int iterations = 600000;
        
        for(int i = 0; i < iterations; i++){
            OrderedDict dict = new OrderedDict(dictargs, kwargs);

            List tuple_list = new List();
            ArrayList<org.python.Object> tuple = new ArrayList<>(2);
            tuple.add(new Str("a"));
            tuple.add(org.python.types.Int.getInt(1));
            tuple_list.append(new org.python.types.Tuple(tuple));
            dict.update(tuple_list, null);

            tuple_list = new List();
            tuple = new ArrayList<>(2);
            tuple.add(new Str("b"));
            tuple.add(org.python.types.Int.getInt(2));
            tuple_list.append(new org.python.types.Tuple(tuple));
            dict.update(tuple_list, null);

            tuple_list = new List();
            tuple = new ArrayList<>(2);
            tuple.add(new Str("b"));
            tuple.add(org.python.types.Int.getInt(2));
            tuple_list.append(new org.python.types.Tuple(tuple));
            dict.update(tuple_list, null);

            dict.popitem();
        }
    }
}
