package countWorkingDays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String start = reader.readLine();
        String end = reader.readLine();

        Calendar startDate = Calendar.getInstance();
        startDate.setTime(new SimpleDateFormat("dd-MM-yyyy").parse(start));
        Calendar endDate = Calendar.getInstance();
        endDate.setTime(new SimpleDateFormat("dd-MM-yyyy").parse(end));
        endDate.add(Calendar.DATE, 1);
        Date[] holidays = new Date[] {
                new SimpleDateFormat("dd-MM").parse("01-01"),
                new SimpleDateFormat("dd-MM").parse("03-03"),
                new SimpleDateFormat("dd-MM").parse("01-05"),
                new SimpleDateFormat("dd-MM").parse("06-05"),
                new SimpleDateFormat("dd-MM").parse("24-05"),
                new SimpleDateFormat("dd-MM").parse("06-09"),
                new SimpleDateFormat("dd-MM").parse("22-09"),
                new SimpleDateFormat("dd-MM").parse("01-11"),
                new SimpleDateFormat("dd-MM").parse("24-12"),
                new SimpleDateFormat("dd-MM").parse("25-12"),
                new SimpleDateFormat("dd-MM").parse("26-12"),
        };

        int counter = 0;

        for (Date date = startDate.getTime(); startDate.before(endDate); startDate.add(Calendar.DATE, 1),
                date = startDate.getTime()) {
            boolean isHoliday = false;
            for (Date holiday : holidays) {
                Calendar currentHoliday = Calendar.getInstance();
                currentHoliday.setTime(holiday);

                if (startDate.get(Calendar.MONTH) == currentHoliday.get(Calendar.MONTH)
                        && startDate.get(Calendar.DAY_OF_MONTH) == currentHoliday.get(Calendar.DAY_OF_MONTH)
                        || startDate.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY
                        || startDate.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
                    isHoliday = true;
                    break;
                }
            }

            if (!isHoliday) {
                counter++;
            }
        }

        System.out.println(counter);
    }
}
