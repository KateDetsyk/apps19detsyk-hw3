package ua.edu.ucu.smartarr;

import java.util.Objects;

// Remove duplicates from SmartArray. Use method equals() to compare objects
public class DistinctDecorator extends SmartArrayDecorator{

    public DistinctDecorator(SmartArray smartArray) {
        super(smartArray);
        Object[] current = smartArray.toArray();

//        int len = smartArray.size();
//
//        for (int i = 0; i < len; i++) {
//            for (int j = i + 1; j < len; j++) {
//                if (current[i].equals(current[j])) {
//                    int temp = j;
//                    for (int c = j+1; c < len; c++) {
//                        current[temp] = current[c];
//                        temp++;
//                    }
//                    len -= 1;
//                    j -= 1;
//                }
//            }
//        }
//        Object[] result = new Object[len];
//        System.arraycopy(current, 0, result, 0, len);
        Object[] result = removeEquals(current);

        this.smartArray = new BaseArray(result);
    }

    private Object[] removeEquals(Object[] current) {
        int len = smartArray.size();

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (current[i].equals(current[j])) {
                    int temp = j;
                    for (int c = j+1; c < len; c++) {
                        current[temp] = current[c];
                        temp++;
                    }
                    len -= 1;
                    j -= 1;
                }
            }
        }
        Object[] result = new Object[len];
        System.arraycopy(current, 0, result, 0, len);
        return result;
    }

    @Override
    public Object[] toArray() {
        return smartArray.toArray();
    }

    @Override
    public String operationDescription() {
        return "Remove duplicates from SmartArray. Use method equals() to compare objects";
    }

    @Override
    public int size() {
        return smartArray.size();
    }
}
