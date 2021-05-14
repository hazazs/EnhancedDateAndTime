package hazazs.utils.datetime;

class EnhancedDateTimeWithFractionalSeconds extends EnhancedDateTime {
    
    private final Range millisecond;
    
    EnhancedDateTimeWithFractionalSeconds(int year, int month, int day, int hour, int minute, int second, int millisecond) {
        super(year, month, day, hour, minute, second);
        this.millisecond = new Range(millisecond, 0, 999_999);
    }
    
    int getMillisecond() {
        return millisecond.getValue();
    }
    
    void incrementMillisecond() {
        if (millisecond.increment()) {
            incrementSecond();
        }
    }
    
    void decrementMillisecond() {
        if (millisecond.decrement()) {
            decrementSecond();
        }
    }
    
}