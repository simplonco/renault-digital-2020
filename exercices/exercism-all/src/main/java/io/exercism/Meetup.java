package io.exercism;

import java.time.DayOfWeek;
import java.time.LocalDate;

class Meetup {

    public Meetup(int month, int year) {
    }

    public LocalDate day(DayOfWeek dayOfWeek, MeetupSchedule meetupSchedule) {
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


