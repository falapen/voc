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

import org.python.types.List;
import org.python.types.Str;

import java.util.ArrayList;

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
    void setItemWrongSizedPairs() {
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
}
