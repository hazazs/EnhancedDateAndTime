package hazazs.utils.datetime;

class Range {

    private int value;
    private final int minValue;
    private final int maxValue;

    Range(int value, int minValue, int maxValue) {
        this.value = value;
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    Range(int minValue, int maxValue) {
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    int getValue() {
        return value;
    }

    boolean increment() {
        boolean isOverFlown = false;
        value++;
        if (isOverFlowing()) {
            value = minValue;
            isOverFlown = true;
        }
        return isOverFlown;
    }

    boolean decrement() {
        boolean isUnderFlown = false;
        value--;
        if (isUnderFlowing()) {
            value = maxValue;
            isUnderFlown = true;
        }
        return isUnderFlown;
    }

    private boolean isOverFlowing() {
        return value > maxValue;
    }

    private boolean isUnderFlowing() {
        return value < minValue;
    }

}