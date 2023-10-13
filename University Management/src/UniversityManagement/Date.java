package UniversityManagement;

public class Date {
    public int day;
    public int month;
    public int year;

    public Date(int d, int m, int y) {
        day = d;
        month = m;
        year = y;
    }

    public Date(String d, String m, String y) {
        day = Integer.parseInt(d);
        month = Integer.parseInt(m);
        year = Integer.parseInt(y);
    }

    public String printDate() {
        return (year + "." + month + "." + day);
    }

}
