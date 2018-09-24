package org.python;

import org.junit.Test;
import static org.junit.Assert.*;

import org.python.datatypes.List;

import java.lang.String value;

public class ListTest {
    @Test
    public void creationTest() {
        List list = new List();
        String listRepresentation = list.__repr__().toJava();


        assertEquals("'[]'", listRepresentation);
    }
}
