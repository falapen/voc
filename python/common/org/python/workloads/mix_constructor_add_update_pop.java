/* Benchmarking routing for OrderedDict by Mauro José Pappaterra */

package python.common.org.python.workloads;
import org.python.stdlib.collections.OrderedDict;
import org.python.types.Int;
import org.python.types.List;
import org.python.types.Str;
import java.util.concurrent.ThreadLocalRandom;

public class mix_constructor_add_update_pop {
    public static void main(String[] args) {

        int X = 10000; // number of Dictionaries to create
        int Y = 1000; // number of elements to populate the dictionaries with

        ArrayList<OrderedDict> dict_array = new ArrayList<OrderedDict>();

        long start = System.currentTimeMillis();
        long start_total = start;

        // Create  X number of dictionaries
        for(int i = 0; i < X; i++) {
            org.python.Object[] dictargs = {null};
            Map<String, org.python.Object> kwargs = new HashMap<String, org.python.Object>();
            OrderedDict dict = new OrderedDict(dictargs, kwargs);

            dict_array.add(dict);
        }

        System.out.println("Created " + X + " dictionaries in -> " + System.currentTimeMillis()- start); // stop clock, print time

        // Populate all X dictionaries with Y elements
        start = System.currentTimeMillis(); // start clock

        for(int i = 0; i < X; i++) {
            for(int j = 0; j < Y; j++) {
                dict_array[i].__setitem__(Int.getInt(j), "Hello");
            }
        }

        System.out.println("Populated all " + X + " dictionaries with " + Y + " elements each in -> " + System.currentTimeMillis()- start); // stop clock, print time

        // Update Y values in all X dictionaries
        start = System.currentTimeMillis(); // start clock

        for(int i = 0; i < X; i++) {
            for(int j = 0; j < Y; j++) {
                dict_array[i].__setitem__(Int.getInt(j), dict_array[i].__getitem__ (j) + " World");
            }
        }

        System.out.println("Updated all " + Y + " elements in " + X + " dictionaries in -> " + System.currentTimeMillis()- start); // stop clock, print time

        // Pop all Y elements in first half of X dictionaries (starting first)
        start = System.currentTimeMillis(); // start clock

        for(int i = 0; i < (X/2); i++) {
            for(int j = 0; j < Y; j++) {
                dict_array[i].popitem(org.python.types.Bool.FALSE);
            }
        }

        System.out.println("Popped all " + Y + " elements in fisrt half (" + (X/2) + ") dictionaries starting from first element in -> " + System.currentTimeMillis()- start); // stop clock, print time

        // Pop all Y elements in second half of X dictionaries (starting last)
        start = System.currentTimeMillis(); // start clock

        for(int i = (X/2); i < X; i++) {
            for(int j = 0; j < Y; j++) {
                dict_array[i].popitem(org.python.types.Bool.TRUE);
            }
        }

        System.out.println("Popped all " + Y + " elements in second half (" + (X/2) + ") dictionaries starting from last element in -> " + System.currentTimeMillis()- start); // stop clock, print time
        System.out.println("Total Time - > " + System.currentTimeMillis()- start); // stop clock, print time
    }
}
