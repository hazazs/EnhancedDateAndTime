package hazazs.utils.datetime;

class EnhancedDateTime extends EnhancedDate {
    
    private final Range hour;
    private final Range minute;
    private final Range second;
    
    protected EnhancedDateTime(int year, int month, int day, int hour, int minute, int second) {
        super(year, month, day);
        this.hour = new Range(hour, 0, 23);
        this.minute = new Range(minute, 0, 59);
        this.second = new Range(second, 0, 59);
    }
    
    int getHour() {
        return hour.getValue();
    }
    
    int getMinute() {
        return minute.getValue();
    }
    
    int getSecond() {
        return second.getValue();
    }
    
    protected void incrementSecond() {
        if (second.increment()) {
            if (minute.increment()) {
                if (hour.increment()) {
                    incrementDay();
                }
            }
        }
    }
    
    protected void decrementSecond() {
        if (second.decrement()) {
            if (minute.decrement()) {
                if (hour.decrement()) {
                    decrementDay();
                }
            }
        }
    }
    
}