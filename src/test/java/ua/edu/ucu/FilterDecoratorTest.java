package ua.edu.ucu;
import org.junit.Before;
import org.junit.Test;
import ua.edu.ucu.functions.MyPredicate;
import ua.edu.ucu.smartarr.BaseArray;
import ua.edu.ucu.smartarr.FilterDecorator;
import ua.edu.ucu.smartarr.SmartArray;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class FilterDecoratorTest {

    private SmartArray arr;
    private Integer[] integers = {-1, 2, 0, 1, -5, 3};
    private MyPredicate pr = t -> ((Integer) t) > 0;

    @Before
    public void setUp() {
        arr = new BaseArray(integers);
        arr = new FilterDecorator(arr, pr);
    }

    @Test
    public void testToArray() {
        Object[] res = arr.toArray();
        Object[] exp = {2, 1, 3};

        assertArrayEquals(exp, res);
    }

    @Test
    public void testOperationDescription() {
        String d = arr.operationDescription();

        String expected = "Tests every element and removes it if it doesn't " +
                "satisfy MyPredicate";

        assertEquals(expected, d);
    }

    @Test
    public void testSize() {
        int act = arr.size();

        int exp = 3;

        assertEquals(act, exp);
    }
}
