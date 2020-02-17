package io.exercism;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class DnDCharacterTest {

    private DnDCharacter dndCharacter = new DnDCharacter();

    @Disabled("Remove to run test")
    @Test
    public void testAbilityModifierForScore3IsNegative4() {
        Assertions.assertEquals(-4, dndCharacter.modifier(3));
    }

    @Disabled("Remove to run test")
    @Test
    public void testAbilityModifierForScore4IsNegative3() {
        Assertions.assertEquals(-3, dndCharacter.modifier(4));
    }

    @Disabled("Remove to run test")
    @Test
    public void testAbilityModifierForScore5IsNegative3() {
        Assertions.assertEquals(-3, dndCharacter.modifier(5));
    }

    @Disabled("Remove to run test")
    @Test
    public void testAbilityModifierForScore6IsNegative2() {
        Assertions.assertEquals(-2, dndCharacter.modifier(6));
    }

    @Disabled("Remove to run test")
    @Test
    public void testAbilityModifierForScore7IsNegative2() {
        Assertions.assertEquals(-2, dndCharacter.modifier(7));
    }

    @Disabled("Remove to run test")
    @Test
    public void testAbilityModifierForScore8IsNegative1() {
        Assertions.assertEquals(-1, dndCharacter.modifier(8));
    }

    @Disabled("Remove to run test")
    @Test
    public void testAbilityModifierForScore9IsNegative1() {
        Assertions.assertEquals(-1, dndCharacter.modifier(9));
    }

    @Disabled("Remove to run test")
    @Test
    public void testAbilityModifierForScore10Is0() {
        Assertions.assertEquals(0, dndCharacter.modifier(10));
    }

    @Disabled("Remove to run test")
    @Test
    public void testAbilityModifierForScore11Is0() {
        Assertions.assertEquals(0, dndCharacter.modifier(11));
    }

    @Disabled("Remove to run test")
    @Test
    public void testAbilityModifierForScore12Is1() {
        Assertions.assertEquals(1, dndCharacter.modifier(12));
    }

    @Disabled("Remove to run test")
    @Test
    public void testAbilityModifierForScore13Is1() {
        Assertions.assertEquals(1, dndCharacter.modifier(13));
    }

    @Disabled("Remove to run test")
    @Test
    public void testAbilityModifierForScore14Is2() {
        Assertions.assertEquals(2, dndCharacter.modifier(14));
    }

    @Disabled("Remove to run test")
    @Test
    public void testAbilityModifierForScore15Is2() {
        Assertions.assertEquals(2, dndCharacter.modifier(15));
    }

    @Disabled("Remove to run test")
    @Test
    public void testAbilityModifierForScore16Is3() {
        Assertions.assertEquals(3, dndCharacter.modifier(16));
    }

    @Disabled("Remove to run test")
    @Test
    public void testAbilityModifierForScore17Is3() {
        Assertions.assertEquals(3, dndCharacter.modifier(17));
    }

    @Disabled("Remove to run test")
    @Test
    public void testAbilityModifierForScore18Is4() {
        Assertions.assertEquals(4, dndCharacter.modifier(18));
    }

    @Disabled("Remove to run test")
    @Test
    public void testRandomAbilityIsWithinRange() {
        int score = dndCharacter.ability();
        Assertions.assertTrue(score > 2 && score < 19);
    }

    @Disabled("Remove to run test")
    @Test
    public void testRandomCharacterIsValid() {
        for (int i = 0; i < 1000; i++) {
            DnDCharacter character = new DnDCharacter();
            Assertions.assertTrue(character.getStrength() > 2 && character.getStrength() < 19);
            Assertions.assertTrue(character.getDexterity() > 2 && character.getDexterity() < 19);
            Assertions.assertTrue(character.getConstitution() > 2 && character.getConstitution() < 19);
            Assertions.assertTrue(character.getIntelligence() > 2 && character.getIntelligence() < 19);
            Assertions.assertTrue(character.getWisdom() > 2 && character.getWisdom() < 19);
            Assertions.assertTrue(character.getCharisma() > 2 && character.getCharisma() < 19);
            Assertions.assertEquals(character.getHitpoints(),
                    10 + character.modifier(character.getConstitution()));
        }
    }

    @Disabled("Remove to run test")
    @Test
    public void testEachAbilityIsOnlyCalculatedOnce() {
        Assertions.assertEquals(dndCharacter.getStrength(), dndCharacter.getStrength());
    }

}
