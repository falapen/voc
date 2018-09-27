package org.python.tests;

import java.util.*;
import java.lang.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.python.Object;
import org.python.types.Dict;
import org.python.types.Int;

import org.python.stdlib.collections.OrderedDict;

import org.python.types.List;
import org.python.types.Str;

import java.util.ArrayList;

public class OrderedDictTest {

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

        //ArrayList from which a python-list is then made and inserted into tuple-list
        ArrayList<org.python.Object> list = new ArrayList<>(2);
        list.add(new Str("dd"));
        list.add(org.python.types.Int.getInt(44L));
        tuple_list.append(new org.python.types.List(list));

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

    @org.junit.jupiter.api.Test
    void testCreationTypeError() {
        //Third assertion
        //Python-List which will contain all tuples
        List tuple_list = new List();
        tuple_list.append((org.python.types.Int.getInt(12)));

        //args
        org.python.Object[] args2 = {tuple_list};
        //kwargs
        java.util.Map kwargs2 = new java.util.HashMap<java.lang.String, org.python.Object>();

        assertThrows(org.python.exceptions.TypeError.class, () -> {
            OrderedDict dict = new OrderedDict(args2, kwargs2);
        });
    }

    @org.junit.jupiter.api.Test
    void testCreationValueError() {
        //Third assertion
        //Python-List which will contain all tuples
        List tuple_list = new List();
        tuple_list.append((org.python.types.Int.getInt(12)));

        //args
        org.python.Object[] args2 = {new org.python.types.Str("asdf")};
        //kwargs
        java.util.Map kwargs2 = new java.util.HashMap<java.lang.String, org.python.Object>();

        assertThrows(org.python.exceptions.ValueError.class, () -> {
            OrderedDict dict = new OrderedDict(args2, kwargs2);
        });

        //Third assertion
        //Python-List which will contain all tuples
        tuple_list = new List();

        //ArrayList from which a tuple is then made and inserted into tuple-list
        ArrayList<org.python.Object> tuple = new ArrayList<>(2);
        tuple.add(new Str("a"));
        tuple.add(org.python.types.Int.getInt(1L));
        tuple.add(org.python.types.Int.getInt(2L));
        tuple_list.append(new org.python.types.Tuple(tuple));

        org.python.Object[] args3 = {tuple_list};
        //kwargs
        java.util.Map kwargs3 = new java.util.HashMap<java.lang.String, org.python.Object>();

        assertThrows(org.python.exceptions.ValueError.class, () -> {
            OrderedDict dict = new OrderedDict(args3, kwargs3);
        });


    }
    @org.junit.jupiter.api.Test
    void testCreationFromDict() {
        org.python.Object[] args = {null};
        java.util.Map kwargs = new java.util.HashMap<java.lang.String, org.python.Object>();
        OrderedDict dict = new OrderedDict(args, kwargs);

        org.python.Object[] args2 = {dict};
        java.util.Map kwargs2 = new java.util.HashMap<java.lang.String, org.python.Object>();
        OrderedDict dict2 = new OrderedDict(args2, kwargs2);
        assertEquals("OrderedDict()", dict2.__str__().toJava());
    }

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
    void setItemWithDictAsIterableTest() {
        org.python.Object[] args = {null};
        Map<String, org.python.Object> kwargs = new HashMap<String, org.python.Object>();
        OrderedDict odict = new OrderedDict(args, kwargs);

        kwargs.put("c", Int.getInt(3));
        Dict dict = new Dict(args, kwargs);
        odict.update(dict, null);
        kwargs.remove("c");
        assertEquals("OrderedDict([('c', 3)])", odict.__str__().toJava());

        kwargs.put("b", Int.getInt(2));
        dict = new Dict(args, kwargs);
        odict.update(dict, null);
        kwargs.remove("b");
        assertEquals("OrderedDict([('c', 3), ('b', 2)])", odict.__str__().toJava());

        kwargs.put("a", Int.getInt(1));
        dict = new Dict(args, kwargs);
        odict.update(dict, null);
        kwargs.remove("a");
        assertEquals("OrderedDict([('c', 3), ('b', 2), ('a', 1)])", odict.__str__().toJava());
    }

    @Test
    void setItemWithTupleAsIterableTest() {
        org.python.Object[] args = {null};
        Map<String, org.python.Object> kwargs = new HashMap<String, org.python.Object>();
        OrderedDict odict = new OrderedDict(args, kwargs);

        List tuple_list = new List();
        ArrayList<org.python.Object> tuple = new ArrayList<>(2);
        tuple.add(new Str("c"));
        tuple.add(org.python.types.Int.getInt(3));
        tuple_list.append(new org.python.types.Tuple(tuple));
        odict.update(tuple_list, null);
        assertEquals("OrderedDict([('c', 3)])", odict.__str__().toJava());

        tuple = new ArrayList<>(2);
        tuple.add(new Str("b"));
        tuple.add(org.python.types.Int.getInt(2));
        tuple_list.append(new org.python.types.Tuple(tuple));
        odict.update(tuple_list, null);
        assertEquals("OrderedDict([('c', 3), ('b', 2)])", odict.__str__().toJava());

        tuple = new ArrayList<>(2);
        tuple.add(new Str("a"));
        tuple.add(org.python.types.Int.getInt(1));
        tuple_list.append(new org.python.types.Tuple(tuple));
        odict.update(tuple_list, null);
        assertEquals("OrderedDict([('c', 3), ('b', 2), ('a', 1)])", odict.__str__().toJava());
    }

    @Test
    void setItemWithListAsIterableTest() {
        org.python.Object[] args = {null};
        Map<String, org.python.Object> kwargs = new HashMap<String, org.python.Object>();
        OrderedDict odict = new OrderedDict(args, kwargs);

        List list_of_lists = new List();
        ArrayList<org.python.Object> list = new ArrayList<>(2);
        list.add(new Str("c"));
        list.add(org.python.types.Int.getInt(3));
        list_of_lists.append(new org.python.types.List(list));
        odict.update(list_of_lists, null);
        assertEquals("OrderedDict([('c', 3)])", odict.__str__().toJava());

        list = new ArrayList<>(2);
        list.add(new Str("b"));
        list.add(org.python.types.Int.getInt(2));
        list_of_lists.append(new org.python.types.List(list));
        odict.update(list_of_lists, null);
        assertEquals("OrderedDict([('c', 3), ('b', 2)])", odict.__str__().toJava());

        list = new ArrayList<>(2);
        list.add(new Str("a"));
        list.add(org.python.types.Int.getInt(1));
        list_of_lists.append(new org.python.types.List(list));
        odict.update(list_of_lists, null);
        assertEquals("OrderedDict([('c', 3), ('b', 2), ('a', 1)])", odict.__str__().toJava());
    }

    @Test
    void setItemWrongSizedPairsTest() {
        org.python.Object[] args = {null};
        Map<String, org.python.Object> kwargs = new HashMap<String, org.python.Object>();
        OrderedDict odict = new OrderedDict(args, kwargs);

        List list_of_lists = new List();
        ArrayList<org.python.Object> list = new ArrayList<>(3);
        list.add(new Str("c"));
        list.add(org.python.types.Int.getInt(3));
        list.add(org.python.types.Int.getInt(123));
        list_of_lists.append(new org.python.types.List(list));
        assertThrows(org.python.exceptions.ValueError.class, () -> {
            odict.update(list_of_lists, null);
        });

        List tuple_list = new List();
        ArrayList<org.python.Object> tuple = new ArrayList<>(1);
        tuple.add(new Str("c"));
        tuple_list.append(new org.python.types.Tuple(tuple));
        assertThrows(org.python.exceptions.ValueError.class, () -> {
            odict.update(tuple_list, null);
        });
    }

    @Test
    void setItemStrAsIterableTest() {
        org.python.Object[] args = {null};
        Map<String, org.python.Object> kwargs = new HashMap<String, org.python.Object>();
        OrderedDict odict = new OrderedDict(args, kwargs);

        List list = new List();
        list.append(new Str("c"));
        assertThrows(org.python.exceptions.ValueError.class, () -> {
            odict.update(list, null);
        });
    }

    @Test
    void setItemObjectAsIterableTest() {
        org.python.Object[] args = {null};
        Map<String, org.python.Object> kwargs = new HashMap<String, org.python.Object>();
        OrderedDict odict = new OrderedDict(args, kwargs);

        List list = new List();
        list.append(Int.getInt(1));
        assertThrows(org.python.exceptions.TypeError.class, () -> {
            odict.update(list, null);
        });
    }

    @Test
    void iterTest() {
        org.python.Object[] args = {null};
        Map<String, org.python.Object> kwargs = new HashMap<String, org.python.Object>();
        kwargs.put("c", Int.getInt(3));
        kwargs.put("b", Int.getInt(2));
        kwargs.put("a", Int.getInt(1));
        OrderedDict od = new OrderedDict(args, kwargs);
        java.util.List<String> chars = new ArrayList<String>(Arrays.asList("a", "b", "c"));

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
        java.util.List<String> chars = new ArrayList<String>(Arrays.asList("c", "b", "a"));
        Iterator<String> charsIter = chars.iterator();

        org.python.Object iter = od.__reversed__();
        try {
            while (true) {
                assertEquals(charsIter.next(), iter.__next__().__str__().toJava());
            }
        } catch (org.python.exceptions.StopIteration | NoSuchElementException e) {
        }
    }

    @Test
    void copyTest() {
        org.python.Object[] args = {null};
        Map<String, org.python.Object> kwargs = new HashMap<String, org.python.Object>();
        kwargs.put("c", Int.getInt(3));
        kwargs.put("b", Int.getInt(2));
        kwargs.put("a", Int.getInt(1));
        OrderedDict od1 = new OrderedDict(args, kwargs);
        OrderedDict od2 = (org.python.stdlib.collections.OrderedDict) od1.copy();
        assertEquals(od1.toString(), od2.toString());

        kwargs.put("d", Int.getInt(4));
        od1 = new OrderedDict(args, kwargs);
        assertNotEquals(od1.toString(), od2.toString());

    }

    @Test
    void popTest() {
        org.python.Object[] args = {null};
        Map<String, org.python.Object> kwargs = new HashMap<String, org.python.Object>();
        kwargs.put("c", Int.getInt(3));
        kwargs.put("b", Int.getInt(2));
        kwargs.put("a", Int.getInt(1));
        OrderedDict od1 = new OrderedDict(args, kwargs);

        org.python.Object removedValue = od1.pop(new Str("c") , null);
        org.python.Object notRemovedValue = od1.pop(new Str("d"), Int.getInt(4));
        assertEquals(removedValue,Int.getInt(3));
        assertEquals(notRemovedValue,Int.getInt(4));

    }

    @Test
    void popItemTest() {
        org.python.Object[] args = {null};
        Map<String, org.python.Object> kwargs = new HashMap<String, org.python.Object>();
        kwargs.put("c", Int.getInt(3));
        kwargs.put("b", Int.getInt(2));
        kwargs.put("a", Int.getInt(1));
        OrderedDict od1 = new OrderedDict(args, kwargs);

        org.python.Object removedTuple;
        org.python.types.Tuple expectedTuple;

        //Pop last
        removedTuple = od1.popitem();
        expectedTuple = new org.python.types.Tuple(new ArrayList<>(Arrays.asList(new Str("c"),Int.getInt(3))));
        assertEquals(removedTuple, expectedTuple);

        //Pop first
        removedTuple = od1.popitem(org.python.types.Bool.FALSE);
        expectedTuple = new org.python.types.Tuple(new ArrayList<>(Arrays.asList(new Str("a"),Int.getInt(1))));
        assertEquals(removedTuple, expectedTuple);

        //Pop last item
        removedTuple = od1.popitem();
        expectedTuple = new org.python.types.Tuple(new ArrayList<>(Arrays.asList(new Str("b"),Int.getInt(2))));
        assertEquals(removedTuple, expectedTuple);

        //Pop empty List
        try {
            removedTuple = od1.popitem();
        } catch(org.python.exceptions.KeyError e) {
            assertEquals("'dictionary is empty'", e.getMessage());
        }


    }



    @Test
    void clearTest() {
        org.python.Object[] args = {null};
        Map<String, org.python.Object> kwargs = new HashMap<String, org.python.Object>();
        kwargs.put("c", Int.getInt(3));
        kwargs.put("b", Int.getInt(2));
        kwargs.put("a", Int.getInt(1));
        OrderedDict od1 = new OrderedDict(args, kwargs);

        kwargs.clear();
        od1 = new OrderedDict(args, kwargs);
        assertEquals("OrderedDict()", od1.__str__().toJava());
    }


    @Test
    void eqTest() {
        org.python.Object[] args = {null};
        org.python.Object[] args2 = {null};
        Map<String, org.python.Object> kwargs = new HashMap<String, org.python.Object>();
        Map<String, org.python.Object> kwargs2 = new HashMap<String, org.python.Object>();
        kwargs.put("a", Int.getInt(1));
        kwargs.put("b", Int.getInt(2));
        kwargs.put("aa", Int.getInt(3));
        kwargs2.put("a", Int.getInt(1));
        kwargs2.put("aa", Int.getInt(3));
        kwargs2.put("b", Int.getInt(2));
        OrderedDict od1 = new OrderedDict(args, kwargs);
        OrderedDict od2 = new OrderedDict(args2, kwargs2);

        assertEquals(od1, od2);

    }

    @Test
    void fromKeysTest() {
        org.python.Object[] args = {null};
        Map<String, org.python.Object> kwargs = new HashMap<String, org.python.Object>();
        /*hello*/


    }

    @Test
    void delItemTest() {
        org.python.Object[] args = {null};
        Map<String, org.python.Object> kwargs = new HashMap<String, org.python.Object>();
        kwargs.put("c", Int.getInt(3));
        kwargs.put("b", Int.getInt(2));
        kwargs.put("a", Int.getInt(1));

        kwargs.remove("a");
        OrderedDict od1 = new OrderedDict(args, kwargs);
        assertEquals("OrderedDict([('b', 2), ('c', 3)])", od1.__str__().toJava());

    }

}


