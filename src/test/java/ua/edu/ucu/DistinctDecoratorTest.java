package ua.edu.ucu;
import org.junit.Before;
import org.junit.Test;
import ua.edu.ucu.smartarr.BaseArray;
import ua.edu.ucu.smartarr.DistinctDecorator;
import ua.edu.ucu.smartarr.SmartArray;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class DistinctDecoratorTest {

    private SmartArray arr;
    private Integer[] integers = {1, 2, 2, 1, 3, 3};

    @Before
    public void setUp() {
        arr = new BaseArray(integers);
        arr = new DistinctDecorator(arr);
    }

    @Test
    public void testToArray() {
        Object[] res = arr.toArray();
        Object[] exp = {1, 2, 3};

        assertArrayEquals(exp, res);
    }

    @Test
    public void testOperationDescription() {
        String d = arr.operationDescription();

        String expected = "Remove duplicates from SmartArray. "
                + "Use method equals() to compare objects";

        assertEquals(expected, d);
    }

    @Test
    public void testSize() {
        int act = arr.size();

        int exp = 3;

        assertEquals(act, exp);
    }
}
