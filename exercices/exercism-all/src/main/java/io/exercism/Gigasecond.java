package io.exercism;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static java.time.temporal.ChronoUnit.SECONDS;

class Gigasecond {

    private LocalDateTime moment;

    Gigasecond(LocalDate moment) {
        this.moment = moment.atTime(0, 0);
    }

    Gigasecond(LocalDateTime moment) {
        this.moment = moment;
    }

    LocalDateTime getDateTime() {
        return moment.plus(1_000_000_000, SECONDS);
    }

}
