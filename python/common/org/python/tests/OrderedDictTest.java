package org.python.tests;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.python.Object;
import org.python.types.Dict;
import org.python.types.Int;

import org.python.stdlib.collections.OrderedDict;

class OrderedDictTest {

    @Test
    void setItemTest() {
        org.python.Object[] args = {null};
        Map<String, org.python.Object> kwargs = new HashMap<String, org.python.Object>();
        OrderedDict odict = new OrderedDict(args, kwargs);

        kwargs.put("c", Int.getInt(3));
        Dict dict = new Dict(args, kwargs);
        odict.update(null, dict);
        kwargs.remove("c");
        assertEquals("OrderedDict([('c', 3)])", odict.__str__().toJava());

        kwargs.put("b", Int.getInt(2));
        dict = new Dict(args, kwargs);
        odict.update(null, dict);
        kwargs.remove("b");
        assertEquals("OrderedDict([('c', 3), ('b', 2)])", odict.__str__().toJava());

        kwargs.put("a", Int.getInt(1));
        dict = new Dict(args, kwargs);
        odict.update(null, dict);
        kwargs.remove("a");
        assertEquals("OrderedDict([('c', 3), ('b', 2), ('a', 1)])", odict.__str__().toJava());
    }

    @Test
    void iterTest() {
        org.python.Object[] args = {null};
        Map<String, org.python.Object> kwargs = new HashMap<String, org.python.Object>();
        kwargs.put("c", Int.getInt(3));
        kwargs.put("b", Int.getInt(2));
        kwargs.put("a", Int.getInt(1));
        OrderedDict od = new OrderedDict(args, kwargs);
        List<String> chars = new ArrayList<String>(Arrays.asList("c", "b", "a"));
        Iterator<String> charsIter = chars.iterator();

        org.python.Object iter = od.__iter__();
        try {
            while (true) {
                assertEquals(charsIter.next(), iter.__next__().__str__().toJava());
            }
        } catch (org.python.exceptions.StopIteration | NoSuchElementException e) {
        }
    }

    @Test
    void reversedTest() {
        org.python.Object[] args = {null};
        Map<String, org.python.Object> kwargs = new HashMap<String, org.python.Object>();
        kwargs.put("c", Int.getInt(3));
        kwargs.put("b", Int.getInt(2));
        kwargs.put("a", Int.getInt(1));
        OrderedDict od = new OrderedDict(args, kwargs);
        List<String> chars = new ArrayList<String>(Arrays.asList("c", "b", "a"));
        Iterator<String> charsIter = chars.iterator();

        org.python.Object iter = od.__reversed__();
        try {
            while (true) {
                assertEquals(charsIter.next(), iter.__next__().__str__().toJava());
            }
        } catch (org.python.exceptions.StopIteration | NoSuchElementException e) {
        }
    }
}
