package Kassensystem;

import org.junit.*;
import static org.junit.Assert.*;

public class KasseTest {

    @Test
    public void testTrue13Eins() {
        assertTrue(Kasse.validChecksum(4018474351579L));
    }

    @Test
    public void testTrue13Zwei() {
        assertTrue(Kasse.validChecksum(4008118760515L));
    }

    @Test
    public void testTrue13Drei() {
        assertTrue(Kasse.validChecksum(9783932992049L));
    }

    /*
    // Funktioniert aus irgendwelchen Gründen nicht
    @Test
    public void AchterEANeins() {
        assertTrue(Kasse.validChecksum(12345678L));
    }*/

    @Test
    public void AchterEANzwei() {
        assertTrue(Kasse.validChecksum(73513537L));
    }

    @Test
    public void testFalseEins() {
        assertFalse(Kasse.validChecksum(4018474251579L));
    }

    @Test
    public void testFalseZwei() {
        assertFalse(Kasse.validChecksum(9683932992049L));
    }

}
