package ua.edu.ucu.smartarr;

// Base array for decorators
public class BaseArray implements SmartArray {

    private Object[] arr;

    public BaseArray(Object[] arr) {
        this.arr = new Object[arr.length];
        System.arraycopy(arr, 0, this.arr, 0, arr.length);
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size()];
        int index = 0;

        Object[] current = arr;
        for (Object elem: current) {
            if (elem == null) {
                break;
            }
            array[index] = elem;
            index++;
        }
        return array;
    }

    @Override
    public String operationDescription() {
        return "Base array for decorators";
    }

    @Override
    public int size() {
        int len = 0;
        Object[] array = arr;

        for (Object e: array) {
            if (e != null) {
                len++;
            }
        }
        return len;
    }
}
