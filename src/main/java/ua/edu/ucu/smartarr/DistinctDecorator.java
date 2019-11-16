package ua.edu.ucu.smartarr;

// Remove duplicates from SmartArray. Use method equals() to compare objects
public class DistinctDecorator extends SmartArrayDecorator {

    public DistinctDecorator(SmartArray smartArray) {
        super(smartArray);
        Object[] current = smartArray.toArray();

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

        this.smartArray = new BaseArray(result);
    }

    @Override
    public Object[] toArray() {
        return smartArray.toArray();
    }

    @Override
    public String operationDescription() {
        return "Remove duplicates from SmartArray. "
                + "Use method equals() to compare objects";
    }

    @Override
    public int size() {
        return smartArray.size();
    }
}
