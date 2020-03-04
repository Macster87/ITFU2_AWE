package IBAN;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class IBANValidatorTestGB {

    // TRUE

    @Test
    public void Korrekt1() { assertTrue(IBANValidatorGB.isValid("GB82 WEST 1234 5698 7654 32")); }

    @Test
    public void Korrekt2() { assertTrue(IBANValidatorGB.isValid("GB29 NWBK 6016 1331 9268 19")); }

    // FALSE

    @Test
    public void false1() { assertFalse(IBANValidatorGB.isValid("DE1723456780123456789")); }

    @Test
    public void Bindestriche() { assertFalse(IBANValidatorGB.isValid("DE74 44010046 01744-36 462")); }

    //Fällt raus, weil ich kleinbuchstaben umwandel
    //@Test
    //public void false3() { assertFalse(IBANValidatorGB.isValid("de07123412341234123412")); }

    @Test
    public void false4() { assertFalse(IBANValidatorGB.isValid("DE98 7484 3087 9903 6894 16")); }

    @Test
    public void false5() { assertFalse(IBANValidatorGB.isValid("DE08123412341234123412")); }

    @Test
    public void BuchstabeInNummernteil() { assertFalse(IBANValidatorGB.isValid("DE241234567801234567B9")); }

    @Test
    public void FalschesLand() { assertFalse(IBANValidatorGB.isValid("GB061234567801234567B9")); }

    @Test
    public void False() { assertFalse(IBANValidatorGB.isValid("GB47 NWBK 6016 1331 9268 193")); }


}
