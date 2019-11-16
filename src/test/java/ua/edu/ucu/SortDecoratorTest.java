package ua.edu.ucu;
import org.junit.Before;
import org.junit.Test;
import ua.edu.ucu.functions.MyComparator;
import ua.edu.ucu.smartarr.BaseArray;
import ua.edu.ucu.smartarr.SmartArray;
import ua.edu.ucu.smartarr.SortDecorator;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class SortDecoratorTest {

    private SmartArray arr;
    private Integer[] integers = {-1, 2, 0, 1, -5, 3};
    private MyComparator cmp = (o1, o2) -> ((Integer) o1) - ((Integer) o2);

    @Before
    public void setUp() {
        arr = new BaseArray(integers);
        arr = new SortDecorator(arr, cmp);
    }

    @Test
    public void testToArray() {
        Object[] res = arr.toArray();
        Object[] exp = {-5, -1, 0, 1, 2, 3};

        assertArrayEquals(exp, res);
    }

    @Test
    public void testOperationDescription() {
        String d = arr.operationDescription();

        String expected = "Sorts elements " +
                "using MyComparator to compare them";

        assertEquals(expected, d);
    }

    @Test
    public void testSize() {
        int act = arr.size();

        int exp = 6;

        assertEquals(act, exp);
    }
}