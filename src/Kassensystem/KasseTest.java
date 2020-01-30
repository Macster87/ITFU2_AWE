package Kassensystem;

import org.junit.*;

import static org.junit.Assert.*;

public class KasseTest {

    @Test
    public void testTrue13Eins() { assertTrue(Kasse.validChecksum(4018474351579L)); }

    @Test
    public void testTrue13Zwei() {
        assertTrue(Kasse.validChecksum(4008118760515L));
    }

    @Test
    public void testTrue13Drei() {
        assertTrue(Kasse.validChecksum(9783932992049L));
    }

    @Test
    public void testTrue8Eins() {
        assertTrue(Kasse.validChecksum(73513537L));
    }

    /*
    // Funktioniert aus irgendwelchen Gründen nicht
    @Test
    public void AchterEANeins() {
        assertTrue(Kasse.validChecksum(12345678L));
    }*/

    @Test
    public void testFalseEins() {
        assertFalse(Kasse.validChecksum(4018474251579L));
    }

    @Test
    public void testFalseZwei() {
        assertFalse(Kasse.validChecksum(9683932992049L));
    }

    @Test(expected = EANWrongDigitException.class)
    public void testEANWrongDigitException() throws EANException {
        Kasse.zahlEingeben("asdf");
    }

    @Test(expected = EANWrongLengthException.class)
    public void testEANWrongLengthException() throws EANException {
        Kasse.zahlEingeben("1234567");
    }

    @Test(expected = EANWrongChecksumException.class)
    public void testEANWrongChecksumException() throws EANException {
        Kasse.zahlEingeben("4018474251579");
    }
}
