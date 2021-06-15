import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Provide a unified interface to a set of interfaces in a subsystem. Facade defines a higher-level interface that makes the subsystem easier to use.
 */
public class FacadePattern {
    public static void main(String[] args){

        UserFriendlyDate d = new UserFriendlyDate("1980-08-20");
        System.out.println("Date : "+d);
        d.addDays(20);
        System.out.println("20 jours après : "+d);
    }
}

// Façade
class UserFriendlyDate {
    GregorianCalendar gcal;

    public UserFriendlyDate(String isodate_ymd) {
        String[] a = isodate_ymd.split("-");
        gcal = new GregorianCalendar(Integer.parseInt(a[0]),
                Integer.parseInt(a[1])-1 /* !!! */, Integer.parseInt(a[2]));
    }

    public void addDays(int days) {
        gcal.add(Calendar.DAY_OF_MONTH, days);
    }

    public String toString() {
        return String.format("%1$tY-%1$tm-%1$td", gcal);
    }
}
