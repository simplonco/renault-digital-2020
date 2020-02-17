package io.exercism;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

class Gigasecond {
    private final LocalDateTime moment;

    Gigasecond(LocalDate moment) {
        this.moment = moment.atTime(0, 0);
    }

    Gigasecond(LocalDateTime moment) {
        this.moment = moment;
    }

    LocalDateTime getDateTime() {
        return moment.plus(1_000_000_000, ChronoUnit.SECONDS);
    }

}
