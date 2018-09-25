package org.python.tests;
import org.python.Object;
import org.python.stdlib.collections.OrderedDict;
import org.python.types.List;
import org.python.types.Str;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class OrderedDictTest {

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    void testCreation() {
        //First assertion
        org.python.Object[] args = {null};
        java.util.Map kwargs = new java.util.HashMap<java.lang.String, org.python.Object>();
        OrderedDict dict = new OrderedDict(args, kwargs);
        assertEquals("OrderedDict()", dict.__str__().toJava());

        //Second assertion
        kwargs.put("a", org.python.types.Int.getInt(1));
        dict = new OrderedDict(args, kwargs);
        assertEquals("OrderedDict([('a', 1)])", dict.__str__().toJava());

        //Third assertion
        //Python-List which will contain all tuples
        List tuple_list = new List();

        //ArrayList from which a tuple is then made and inserted into tuple-list
        ArrayList<org.python.Object> tuple = new ArrayList<>(2);
        tuple.add(new Str("a"));
        tuple.add(org.python.types.Int.getInt(1L));
        tuple_list.append(new org.python.types.Tuple(tuple));

        //ArrayList from which a tuple is then made and inserted into tuple-list
        tuple = new ArrayList<>(2);
        tuple.add(new Str("b"));
        tuple.add(org.python.types.Int.getInt(2L));
        tuple_list.append(new org.python.types.Tuple(tuple));

        //ArrayList from which a tuple is then made and inserted into tuple-list
        tuple = new ArrayList<>(2);
        tuple.add(new Str("c"));
        tuple.add(org.python.types.Int.getInt(3L));
        tuple_list.append(new org.python.types.Tuple(tuple));

        //ArrayList from which a tuple is then made and inserted into tuple-list
        tuple = new ArrayList<>(2);
        tuple.add(new Str("d"));
        tuple.add(org.python.types.Int.getInt(4L));
        tuple_list.append(new org.python.types.Tuple(tuple));

        //ArrayList from which a tuple is then made and inserted into tuple-list
        tuple = new ArrayList<>(2);
        tuple.add(new Str("e"));
        tuple.add(org.python.types.Int.getInt(5L));
        tuple_list.append(new org.python.types.Tuple(tuple));

        //ArrayList from which a tuple is then made and inserted into tuple-list
        tuple = new ArrayList<>(2);
        tuple.add(new Str("aa"));
        tuple.add(org.python.types.Int.getInt(11L));
        tuple_list.append(new org.python.types.Tuple(tuple));

        //ArrayList from which a tuple is then made and inserted into tuple-list
        tuple = new ArrayList<>(2);
        tuple.add(new Str("bb"));
        tuple.add(org.python.types.Int.getInt(22L));
        tuple_list.append(new org.python.types.Tuple(tuple));

        //ArrayList from which a tuple is then made and inserted into tuple-list
        tuple = new ArrayList<>(2);
        tuple.add(new Str("cc"));
        tuple.add(org.python.types.Int.getInt(33L));
        tuple_list.append(new org.python.types.Tuple(tuple));

        //ArrayList from which a tuple is then made and inserted into tuple-list
        tuple = new ArrayList<>(2);
        tuple.add(new Str("dd"));
        tuple.add(org.python.types.Int.getInt(44L));
        tuple_list.append(new org.python.types.Tuple(tuple));

        //ArrayList from which a tuple is then made and inserted into tuple-list
        tuple = new ArrayList<>(2);
        tuple.add(new Str("ee"));
        tuple.add(org.python.types.Int.getInt(55L));
        tuple_list.append(new org.python.types.Tuple(tuple));

        //args
        org.python.Object[] args2 = {tuple_list};
        //kwargs
        java.util.Map kwargs2 = new java.util.HashMap<java.lang.String, org.python.Object>();

        dict = new OrderedDict(args2, kwargs2);
        assertEquals("OrderedDict([('a', 1), ('b', 2), ('c', 3), ('d', 4), ('e', 5), ('aa', 11), ('bb', 22), ('cc', 33), ('dd', 44), ('ee', 55)])", dict.__str__().toJava());

    }
}
