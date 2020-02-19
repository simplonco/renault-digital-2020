package io.exercism;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

class Meetup {

    private final int month;
    private final int year;

    public Meetup(int month, int year) {
        this.month = month;
        this.year = year;
    }

    public LocalDate day(DayOfWeek dayOfWeek, MeetupSchedule meetupSchedule) {
        LocalDate currentDate = LocalDate.of(year, month, 1);
        List<LocalDate> meetupDates = new ArrayList<>();
        for (int day = 1; day <= currentDate.lengthOfMonth(); day++) {
            currentDate = LocalDate.of(year, month, day);
            if (currentDate.getDayOfWeek().equals(dayOfWeek)) {
                meetupDates.add(currentDate);
            }
        }
        switch (meetupSchedule) {
            case FIRST:
                return meetupDates.get(0);
            case SECOND:
                return meetupDates.get(1);
            case THIRD:
                return meetupDates.get(2);
            case FOURTH:
                return meetupDates.get(3);
            case LAST:
                return meetupDates.get(meetupDates.size() - 1);
            case TEENTH:
                for (LocalDate meetupDate : meetupDates) {
                    if (meetupDate.getDayOfMonth() >= 13 && meetupDate.getDayOfMonth() <= 19) {
                        return meetupDate;
                    }
                }
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + meetupSchedule);
        }
        return null;
    }

    enum MeetupSchedule {
        FIRST,
        SECOND,
        THIRD,
        FOURTH,
        LAST,
        TEENTH
    }

}


