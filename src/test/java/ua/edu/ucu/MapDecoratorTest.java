package ua.edu.ucu;
import org.junit.Before;
import org.junit.Test;
import ua.edu.ucu.functions.MyFunction;
import ua.edu.ucu.smartarr.BaseArray;
import ua.edu.ucu.smartarr.MapDecorator;
import ua.edu.ucu.smartarr.SmartArray;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class MapDecoratorTest {

    private SmartArray arr;
    private Integer[] integers = {-1, 2, 0, 1, -5, 3};
    private MyFunction func = t -> 10 * ((Integer) t);

    @Before
    public void setUp() {
        arr = new BaseArray(integers);
        arr = new MapDecorator(arr, func);
    }

    @Test
    public void testToArray() {
        Object[] res = arr.toArray();
        Object[] exp = {-10, 20, 0, 10, -50, 30};

        assertArrayEquals(exp, res);
    }

    @Test
    public void testOperationDescription() {
        String d = arr.operationDescription();

        String expected = "Map every element to another object" +
                " using MyFunction";

        assertEquals(expected, d);
    }

    @Test
    public void testSize() {
        int act = arr.size();

        int exp = 6;

        assertEquals(act, exp);
    }
}