package io.exercism;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class SpaceAgeTest {

    private static final double MAXIMUM_DELTA = 1E-02;

    @Disabled("Remove to run test")
    @Test
    public void ageOnEarth() {
        SpaceAge age = new SpaceAge(1000000000);

        Assertions.assertEquals(31.69, age.onEarth(), MAXIMUM_DELTA);
    }

    @Disabled("Remove to run test")
    @Test
    public void ageOnMercury() {
        SpaceAge age = new SpaceAge(2134835688);

        Assertions.assertEquals(280.88, age.onMercury(), MAXIMUM_DELTA);
    }

    @Disabled("Remove to run test")
    @Test
    public void ageOnVenus() {
        SpaceAge age = new SpaceAge(189839836);

        Assertions.assertEquals(9.78, age.onVenus(), MAXIMUM_DELTA);
    }

    @Disabled("Remove to run test")
    @Test
    public void ageOnMars() {
        SpaceAge age = new SpaceAge(2129871239L);

        Assertions.assertEquals(35.88, age.onMars(), MAXIMUM_DELTA);
    }

    @Disabled("Remove to run test")
    @Test
    public void ageOnJupiter() {
        SpaceAge age = new SpaceAge(901876382);

        Assertions.assertEquals(2.41, age.onJupiter(), MAXIMUM_DELTA);
    }

    @Disabled("Remove to run test")
    @Test
    public void ageOnSaturn() {
        SpaceAge age = new SpaceAge(2000000000L);

        Assertions.assertEquals(2.15, age.onSaturn(), MAXIMUM_DELTA);
    }

    @Disabled("Remove to run test")
    @Test
    public void ageOnUranus() {
        SpaceAge age = new SpaceAge(1210123456L);

        Assertions.assertEquals(0.46, age.onUranus(), MAXIMUM_DELTA);
    }

    @Disabled("Remove to run test")
    @Test
    public void ageOnNeptune() {
        SpaceAge age = new SpaceAge(1821023456L);

        Assertions.assertEquals(0.35, age.onNeptune(), MAXIMUM_DELTA);
    }
}
