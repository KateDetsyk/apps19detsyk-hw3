package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyComparator;

// Sorts elements using MyComparator to compare them
public class SortDecorator extends SmartArrayDecorator {

    public SortDecorator(SmartArray sa, MyComparator cmp) {
        super(sa);

        Object[] arr = sa.toArray();
        int n = sa.size();

        for (int i = 1; i < n; ++i) {
            Object value = arr[i];
            int position = i - 1;

            while (position >= 0 && cmp.compare(arr[position], value) > 0) {
                arr[position + 1] = arr[position];
                position = position - 1;
            }
            arr[position + 1] = value;
        }
        this.smartArray = new BaseArray(arr);
    }

    @Override
    public Object[] toArray() {
        return smartArray.toArray();
    }

    @Override
    public String operationDescription() {
        return "Sorts elements "
                + "using MyComparator to compare them";
    }

    @Override
    public int size() {
        return smartArray.size();
    }
}
