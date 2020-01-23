package KassensystemKotlin

import org.junit.Assert
import org.junit.Test

class KasseTest {
    @Test
    fun testTrue13Eins() {
        Assert.assertTrue(validChecksum(4018474351579L))
    }

    @Test
    fun testTrue13Zwei() {
        Assert.assertTrue(validChecksum(4008118760515L))
    }

    @Test
    fun testTrue13Drei() {
        Assert.assertTrue(validChecksum(9783932992049L))
    }

    /*
    // Funktioniert aus irgendwelchen Gründen nicht
    @Test
    public void AchterEANeins() {
        assertTrue(validChecksum(12345678L));
    }*/
    @Test
    fun AchterEANzwei() {
        Assert.assertTrue(validChecksum(73513537L))
    }

    @Test
    fun testFalseEins() {
        Assert.assertFalse(validChecksum(4018474251579L))
    }

    @Test
    fun testFalseZwei() {
        Assert.assertFalse(validChecksum(9683932992049L))
    }
}