package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyPredicate;

// Tests every element and removes it if it doesn't satisfy MyPredicate
public class FilterDecorator extends SmartArrayDecorator {

    public FilterDecorator(SmartArray sa, MyPredicate pr) {
        super(sa);

        Object[] current = sa.toArray();
        Object[] result = new Object[sa.size()];
        int index = 0;
        for (Object elem: current) {
            if (pr.test(elem)) {
                result[index] = elem;
                index++;
            }
        }
        this.smartArray = new BaseArray(result);
    }

    @Override
    public Object[] toArray() {
        return smartArray.toArray();
    }

    @Override
    public String operationDescription() {
        return "Tests every element and removes it if it doesn't "
                + "satisfy MyPredicate";
    }

    @Override
    public int size() {
        return smartArray.size();
    }
}
