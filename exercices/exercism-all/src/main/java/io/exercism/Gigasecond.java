package io.exercism;

import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {

    private LocalDateTime localDateTime;

    // overload
    Gigasecond(LocalDate localDate) {
        this.localDateTime = localDate.atTime(0, 0, 0);
    }

    // overload
    Gigasecond(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    LocalDateTime getDateTime() {
        return localDateTime.plusSeconds(1_000_000_000);
    }

}
