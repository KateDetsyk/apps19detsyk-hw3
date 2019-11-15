package ua.edu.ucu.smartarr;

// Base array for decorators
public class BaseArray implements SmartArray{

    private Object[] arr;

    public BaseArray(Object[] arr) {
        this.arr = new Object[arr.length];
        System.arraycopy(arr, 0, this.arr, 0, arr.length);
    }

    @Override
    public Object[] toArray() {
        return arr;
    }

    @Override
    public String operationDescription() {
        return "Base array for decorators";
    }

    @Override
    public int size() {
        int len = 0;
        Object[] arr = toArray();

        for (Object e: arr) {
            if (e != null) {
                len++;
            }
        }
        return len;
    }
}
