package IBAN;

import org.junit.*;
import static org.junit.Assert.*;

public class IBANValidatorTestDE {

    @Test
    public void Korrekt1() { assertTrue(IBANValidatorDE.isValid("DE74 4401 0046 0174 4364 62")); }

    @Test
    public void Korrekt2() { assertTrue(IBANValidatorDE.isValid("DE07123412341234123412")); }

    @Test
    public void Korrekt3() { assertTrue(IBANValidatorDE.isValid("DE58 1234 5678 0123 4567 89")); }

    // FALSE

    @Test
    public void false1() { assertFalse(IBANValidatorDE.isValid("DE1723456780123456789")); }

    @Test
    public void Bindestriche() { assertFalse(IBANValidatorDE.isValid("DE74 44010046 01744-36 462")); }

    //Fällt raus, weil ich kleinbuchstaben umwandel
    //@Test
    //public void false3() { assertFalse(IBANValidatorDE.isValid("de07123412341234123412")); }

    @Test
    public void false4() { assertFalse(IBANValidatorDE.isValid("DE98 7484 3087 9903 6894 16")); }

    @Test
    public void false5() { assertFalse(IBANValidatorDE.isValid("DE08123412341234123412")); }

    @Test
    public void BuchstabeInNummernteil() { assertFalse(IBANValidatorDE.isValid("DE241234567801234567B9")); }

    @Test
    public void FalschesLand() { assertFalse(IBANValidatorDE.isValid("GB061234567801234567B9")); }

}
