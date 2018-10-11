package python.common.org.python.workloads;

import org.python.stdlib.collections.OrderedDict;
import org.python.types.Int;
import java.util.concurrent.ThreadLocalRandom;


import java.util.*;

public class mix_copy_popitem_first_and_last {
    public static void main(String args[]) {

        int E = 100; //Number of elements to create in dictionary
        int D = 1000; // Number of dictionaries to create and pop

        long start = System.currentTimeMillis();

        org.python.Object[] dictargs = {null};
        Map<String, org.python.Object> kwargs = new HashMap<String, org.python.Object>();
        OrderedDict main_dict = new OrderedDict(dictargs, kwargs);

        for(int i = 0; i < E; i++) { //Populate main dictionary
            main_dict.__setitem__(Int.getInt(i), Int.getInt(i));
        }

        for(int j = 0; j < D; j++) { //Create new copy of main dictionary
            OrderedDict temp_dict = (OrderedDict) main_dict.copy(); //Create new copy of main dictionary
            for(int k = 0; k < E; k++) { //Pop all items in temp dictionary by chance
                int rnd = ThreadLocalRandom.current().nextInt(0, 1 + 1);

                if (rnd == 0) {
                    temp_dict.popitem(org.python.types.Bool.FALSE);
                }
                else {
                    temp_dict.popitem(org.python.types.Bool.TRUE);
                }
            }
            temp_dict.clear();
        }
        main_dict.clear();
        System.out.println(System.currentTimeMillis()-start + "ms");
    }
}
