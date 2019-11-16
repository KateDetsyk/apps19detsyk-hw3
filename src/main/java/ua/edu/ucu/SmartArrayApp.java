package ua.edu.ucu;

import java.util.Arrays;
import ua.edu.ucu.functions.MyComparator;
import ua.edu.ucu.functions.MyFunction;
import ua.edu.ucu.functions.MyPredicate;
import ua.edu.ucu.smartarr.BaseArray;
import ua.edu.ucu.smartarr.DistinctDecorator;
import ua.edu.ucu.smartarr.FilterDecorator;
import ua.edu.ucu.smartarr.MapDecorator;
import ua.edu.ucu.smartarr.SmartArray;
import ua.edu.ucu.smartarr.SortDecorator;

public class SmartArrayApp {

    public static Integer[]
            filterPositiveIntegersSortAndMultiplyBy2(Integer[] integers) {
                
        MyPredicate pr = new MyPredicate() {
            @Override
            public boolean test(Object t) {
                return ((Integer) t) > 0;
            }
        };

        MyComparator cmp = new MyComparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((Integer) o1) - ((Integer) o2);
            }
        };

        MyFunction func = new MyFunction() {
            @Override
            public Object apply(Object t) {
                return 2 * ((Integer) t);
            }
        };

        // Input: [-1, 2, 0, 1, -5, 3]
        SmartArray sa = new BaseArray(integers);

        sa = new FilterDecorator(sa, pr); // Result: [2, 1, 3];
        sa = new SortDecorator(sa, cmp); // Result: [1, 2, 3]
        sa = new MapDecorator(sa, func); // Result: [2, 4, 6]

        Object[] result = sa.toArray();
        return Arrays.copyOf(result, result.length, Integer[].class);
    }

    public static String[]
            findDistinctStudentNamesFrom2ndYearWithGPAgt4AndOrderedBySurname(
                    Student[] students) {

        MyComparator cmp = (one, two) -> {
            char[] nameOne = ((Student) one).getSurname().toCharArray();
            char[] nameTwo = ((Student) two).getSurname().toCharArray();

            if (nameOne.length == nameTwo.length) {
                int len = nameOne.length;

                for (int i = 0; i < len; i++) {
                    if (nameOne[i] != nameTwo[i]) {
                        return (int) nameOne[i] - (int) nameTwo[i];
                    }
                }
                return 0;
            }
            return nameOne.length - nameTwo.length;
        };

        final int GPAA = 4;
        final int YEAR = 2;
        MyPredicate pr = t -> ((Student) t).getYear() == YEAR
                && ((Student) t).getGPA() >= GPAA;

        SmartArray st = new BaseArray(students);
        st = new DistinctDecorator(st);
        st = new FilterDecorator(st, pr);
        st = new SortDecorator(st, cmp);

        String[] result = new String[st.size()];

        for (int i = 0; i < st.size(); i++) {
            result[i] = ((Student) st.toArray()[i]).getSurname() + " "
                    + ((Student) st.toArray()[i]).getName();
        }

        return result;
    }
}
