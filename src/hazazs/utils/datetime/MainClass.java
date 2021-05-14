package hazazs.utils.datetime;

public class MainClass {
    public static void main(String[] args) {
        EnhancedDateTimeWithFractionalSeconds enh = new EnhancedDateTimeWithFractionalSeconds(2021, 12, 31, 23, 56, 43, 614521);
        for (int i = 0; i < 1_000_000; i++) {
            System.out.printf("%4d.%02d.%02d. %02d:%02d:%02d.%06d%n", enh.getYear(), enh.getMonth(), enh.getDay(), enh.getHour(), enh.getMinute(), enh.getSecond(), enh.getMillisecond());
            enh.incrementMillisecond();
        }
    }
}