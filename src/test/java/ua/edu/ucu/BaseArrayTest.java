package ua.edu.ucu;

import org.junit.Before;
import org.junit.Test;
import ua.edu.ucu.smartarr.BaseArray;
import ua.edu.ucu.smartarr.SmartArray;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class BaseArrayTest {

    private SmartArray arr;
    private Integer[] integers = {-1, 2, 0, 1, -5, 3};

    @Before
    public void setUp() {
        arr = new BaseArray(integers);
    }

    @Test
    public void testToArray() {
        Object[] res = arr.toArray();

        assertArrayEquals(integers, res);
    }

    @Test
    public void testOperationDescription() {
        String d = arr.operationDescription();

        String expected = "Base array for decorators";

        assertEquals(expected, d);
    }

    @Test
    public void testSize() {
        int act = arr.size();

        int exp = 6;

        assertEquals(act, exp);
    }
}
