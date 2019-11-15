package ua.edu.ucu;

import java.util.Arrays;
import ua.edu.ucu.functions.MyComparator;
import ua.edu.ucu.functions.MyFunction;
import ua.edu.ucu.functions.MyPredicate;
import ua.edu.ucu.smartarr.*;

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

        // Alternative
//        sa = new MapDecorator(
//                    new SortDecorator(
//                        new FilterDecorator(sa, pr),
//                    cmp),
//                func);
        Object[] result = sa.toArray();
        return Arrays.copyOf(result, result.length, Integer[].class);
    }

    public static String[]
            findDistinctStudentNamesFrom2ndYearWithGPAgt4AndOrderedBySurname(Student[] students) {

        MyComparator cmp = (o1, o2) -> {
            char[] name1 = ((Student)o1).getSurname().toCharArray();
            char[] name2 = ((Student)o2).getSurname().toCharArray();

            if (name1.length == name2.length) {
                int len = name1.length;

                for (int i = 0; i < len; i++) {
                    if (name1[i] != name2[i]) {
                        return (int) name1[i] - (int) name2[i];
                    }
                }
                return 0;
            }
            return name1.length - name2.length;
        };

        MyPredicate pr = t -> ((Student)t).getYear() == 2 && ((Student)t).getGPA() >= 4;

        SmartArray st = new BaseArray(students);

        st = new DistinctDecorator(st);
        st = new FilterDecorator(st, pr);
        st = new SortDecorator(st, cmp);


        // Hint: to convert Object[] to String[] - use the following code
        String[] result = new String[st.size()];

        for (int i = 0; i < st.size(); i++) {
            result[i] = ((Student)st.toArray()[i]).getSurname() + " " +
                    ((Student)st.toArray()[i]).getName();
        }

        return result;
    }
}
