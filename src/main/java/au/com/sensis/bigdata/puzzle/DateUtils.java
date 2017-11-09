package au.com.sensis.bigdata.puzzle;

import org.apache.commons.lang3.time.DateFormatUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DateUtils {

    public static final String COMPRESSED_YEAR_MONTH_DAY = "yyyyMMdd";
    public static final String COMPRESSED_YEAR_MONTH = "yyyyMM";

    public static int getFirstDayOfMonth(Integer yearMonthToProcess) {
        try {
            Date d = new SimpleDateFormat(COMPRESSED_YEAR_MONTH).parse(
                    String.valueOf(yearMonthToProcess)
            );
            return
                    new Integer(
                            new SimpleDateFormat(COMPRESSED_YEAR_MONTH_DAY).format(d)
                    );
        } catch (ParseException pe) {
            throw new RuntimeException(pe.getMessage(), pe);
        }
    }

    public static int getLastDayOfMonth(Integer yearMonthToProcess) {
        try {
            Date d = new SimpleDateFormat(COMPRESSED_YEAR_MONTH).parse(
                    String.valueOf(yearMonthToProcess)
            );
            d = org.apache.commons.lang.time.DateUtils.addMonths(d, 1);
            d = org.apache.commons.lang.time.DateUtils.addMilliseconds(d, -1);
            return
                    new Integer(
                            new SimpleDateFormat(COMPRESSED_YEAR_MONTH_DAY).format(d)
                    );
        } catch (ParseException pe) {
            throw new RuntimeException(pe.getMessage(), pe);
        }
    }

    public static long getDaysInBetween(Integer dateInt) {
        SimpleDateFormat format = new SimpleDateFormat(COMPRESSED_YEAR_MONTH_DAY);

        Date start = null;
        try {
            start = format.parse(String.valueOf(dateInt));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return TimeUnit.DAYS.convert(new Date().getTime() - start.getTime(), TimeUnit.MILLISECONDS);
    }

    public static void main(String[] args) {

        int d = Integer.valueOf(DateFormatUtils.format(new Date(), COMPRESSED_YEAR_MONTH_DAY));
        System.out.println("Today: " + d);

        d = Integer.valueOf(DateFormatUtils.format(new Date(), COMPRESSED_YEAR_MONTH));
        System.out.println("This month: " + d);

        d = Integer.valueOf(DateFormatUtils.format(org.apache.commons.lang.time.DateUtils.addDays(new Date(), -7),
                COMPRESSED_YEAR_MONTH_DAY));
        System.out.println("7 days ago: " + d);

        d = Integer.valueOf(DateFormatUtils.format(org.apache.commons.lang.time.DateUtils.addMonths(new Date(), -1),
                COMPRESSED_YEAR_MONTH));
        System.out.println("Last month: " + d);

        System.out.println("Last month first day: " + getFirstDayOfMonth(d));
        System.out.println("Last month last day: " + getLastDayOfMonth(d));

        // how many days before today
        System.out.println("How many days before today? " + getDaysInBetween(20171107));

    }
}
