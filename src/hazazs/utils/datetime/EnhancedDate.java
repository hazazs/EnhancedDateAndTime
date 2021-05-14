package hazazs.utils.datetime;

class EnhancedDate {

    private int year;
    private final Range month;
    private Range day;

    protected EnhancedDate(int year, int month, int day) {
        this.year = year;
        this.month = new Range(month, 1, 12);
        this.day = new Range(day, 1, lastDayOfMonth());
    }

    int getYear() {
        return year;
    }

    int getMonth() {
        return month.getValue();
    }

    int getDay() {
        return day.getValue();
    }
    
    protected void incrementDay() {
        if (day.increment()) {
            if (month.increment()) {
                year++;
            }
            day = new Range(1, 1, lastDayOfMonth());
        }
    }
    
    protected void decrementDay() {
        if (day.decrement()) {
            if (month.decrement()) {
                year--;
            }
            day = new Range(lastDayOfMonth(), 1, lastDayOfMonth());
        }
    }

    private int lastDayOfMonth() {
        return switch (getMonth()) {
            case 1, 3, 5, 7, 8, 10, 12 -> 31;
            case 4, 6, 9, 11 -> 30;
            case 2 -> isLeapYear() ? 29 : 28;
            default -> throw new IllegalArgumentException();
        };
    }
    
    private boolean isLeapYear() {
        return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
    }
    
}