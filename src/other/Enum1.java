package other;


public class Enum1 {
    Weekdays weekday;
    public Enum1(Weekdays weekday) {
        this.weekday = weekday;
    }

    void getDay(){
        System.out.println(weekday.today());
    }

    public static void main(String[] args) {
        Enum1 enum1 = new Enum1(Weekdays.SATURDAY);
        enum1.getDay();

//        int[] res = new int[5];
//        res[1] = 2;
    }

    @Override
    public String toString() {
        return "Enum1{" +
                "weekday=" + weekday +
                '}';
    }
}

enum Weekdays {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY("demalys na"), SUNDAY("demalys na");

    String mood;

    Weekdays(String mood) {
        this.mood = mood;
    }

    Weekdays() {
    }

    public String today(){
        return this.toString()+" "+ mood;
    }
}
