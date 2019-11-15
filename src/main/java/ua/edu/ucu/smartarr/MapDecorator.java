package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyFunction;

// Map every element to another object using MyFunction
public class MapDecorator extends SmartArrayDecorator{

    public MapDecorator(SmartArray smartArray, MyFunction func) {
        super(smartArray);

        Object[] current = smartArray.toArray();
        int len = smartArray.size();
        Object[] result = new Object[len];

        for (int i = 0; i < len; i++) {
            result[i] = func.apply(current[i]);
        }

        this.smartArray = new BaseArray(result);
    }

    @Override
    public Object[] toArray() {
        return smartArray.toArray();
    }

    @Override
    public String operationDescription() {
        return "Map every element to another object using MyFunction";
    }

    @Override
    public int size() {
        return smartArray.size();
    }
}
