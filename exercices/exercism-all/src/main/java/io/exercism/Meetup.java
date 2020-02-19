package io.exercism;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

import static java.util.stream.Collectors.toList;

class Meetup {

    private static final List<Integer> TEENTH_DAY_OF_MONTH = List.of(13, 14, 15, 16, 17, 18, 19);

    private final LocalDate referenceDate;

    public Meetup(int month, int year) {
        this.referenceDate = LocalDate.of(year, month, 1);
    }

    public LocalDate day(DayOfWeek dayOfWeek, MeetupSchedule meetupSchedule) {
        List<LocalDate> meetups = referenceDate
                .datesUntil(referenceDate.plusMonths(1))
                .filter(date -> date.getDayOfWeek().equals(dayOfWeek))
                .collect(toList());
        switch (meetupSchedule) {
            case FIRST:
                return meetups.get(0);
            case SECOND:
                return meetups.get(1);
            case THIRD:
                return meetups.get(2);
            case FOURTH:
                return meetups.get(3);
            case LAST:
                return meetups.get(meetups.size() - 1);
            case TEENTH:
                return meetups.stream()
                        .filter(meetup -> TEENTH_DAY_OF_MONTH.contains(meetup.getDayOfMonth()))
                        .findAny()
                        .orElseThrow(IllegalArgumentException::new);
            default:
                throw new IllegalStateException("Unexpected value: " + meetupSchedule);
        }
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


