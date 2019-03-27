import static org.junit.Assert.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Ignore;

/**
 * @author Arthur
 */
public class MyArrayListTest {

    public MyArrayListTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testNew() {
        MyArrayList<String> mal = new MyArrayList<>();
        assertNotNull(mal);
    }

    @Test
    public void testNewAndSize() {
        MyArrayList<String> mal = new MyArrayList<String>();
        assertEquals(0, mal.size());
    }

    @Test
    public void testAdd1() {
        MyArrayList mal = new MyArrayList<String>();
        mal.add("eins");
        assertEquals(1, mal.size());
    }

    @Test
    public void testAdd2() {
        MyArrayList mal = new MyArrayList<String>();
        mal.add("eins");
        assertEquals(1, mal.size());
        mal.add("zwei");
        assertEquals(2, mal.size());
    }

    @Test
    public void testGet1() {
        MyArrayList<String> mal = new MyArrayList<>();
        mal.add("eins");
        String res = mal.get(0);
        assertEquals("eins", res);
    }

    @Test
    public void testGet2() {
        MyArrayList<String> mal = new MyArrayList<>();
        mal.add("eins");
        mal.add("zwei");
        String res = mal.get(1);
        assertEquals("zwei", res);
    }

    @Test
    public void testGet3() {
        MyArrayList<String> mal = new MyArrayList<>();
        mal.add("eins");
        mal.add("zwei");
        mal.add("drei");
        String res = mal.get(0);
        assertEquals("eins", res);
        res = mal.get(1);
        assertEquals("zwei", res);
        res = mal.get(2);
        assertEquals("drei", res);
    }

    @Test
    public void testAddAtIndex() {
        MyArrayList<String> mal = new MyArrayList<>();
        mal.add("eins");
        mal.add("zwei");
        mal.add("drei");
        mal.add(1, "einsA");
        String res = mal.get(0);
        assertEquals("eins", res);
        res = mal.get(1);
        assertEquals("einsA", res);
        res = mal.get(2);
        assertEquals("zwei", res);
    }

    @Test
    public void testAddAtIndex0() {
        MyArrayList<String> mal = new MyArrayList<>();
        mal.add("eins");
        mal.add("zwei");
        mal.add("drei");
        mal.add(0, "null");
        String res = mal.get(0);
        assertEquals("null", res);
        res = mal.get(1);
        assertEquals("eins", res);
        res = mal.get(2);
        assertEquals("zwei", res);
        assertEquals(4, mal.size());
    }

    @Test
    public void testRemoveHead() {
        MyArrayList<String> mal = new MyArrayList<>();
        mal.add("eins");
        mal.add("zwei");
        mal.add("drei");
        assertTrue(mal.remove("eins"));
        String res = mal.get(0);
        assertEquals("zwei", res);
        assertEquals(2, mal.size());
        assertFalse(mal.contains("eins"));
    }

    @Test
    public void testRemoveTail() {
        MyArrayList<String> mal = new MyArrayList<>();
        mal.add("eins");
        mal.add("zwei");
        mal.add("drei");
        mal.remove("drei");
        String res = mal.get(1);
        assertEquals("zwei", res);
        assertEquals(2, mal.size());
    }

    @Test
    public void testRemoveIndex1() {
        MyArrayList<String> mal = new MyArrayList<>();
        mal.add("eins");
        mal.add("zwei");
        mal.add("drei");
        String res = mal.remove(1);
        assertEquals("zwei", res);
        res = mal.get(0);
        assertEquals("eins", res);
        res = mal.get(1);
        assertEquals("drei", res);
        assertEquals(2, mal.size());
    }

    @Test
    public void testRemoveNone() {
        MyArrayList<String> mal = new MyArrayList<>();
        mal.add("eins");
        mal.add("zwei");
        mal.add("drei");
        boolean res = mal.remove("zwei");
        assertTrue(res);
        res = mal.remove("zwei");
        assertFalse(res);
    }

    @Test
    public void testRemoveIndex0() {
        MyArrayList<String> mal = new MyArrayList<>();
        mal.add("eins");
        mal.add("zwei");
        mal.add("drei");
        String res = mal.remove(0);
        assertEquals("eins", res);
        res = mal.get(0);
        assertEquals("zwei", res);
        res = mal.get(1);
        assertEquals("drei", res);
        assertEquals(2, mal.size());
    }

    @Test
    public void testRemoveIndexLast() {
        MyArrayList<String> mal = new MyArrayList<>();
        mal.add("eins");
        mal.add("zwei");
        mal.add("drei");
        String res = mal.remove(mal.size() - 1);
        assertEquals("drei", res);
        assertFalse(mal.contains("drei"));
        res = mal.get(0);
        assertEquals("eins", res);
        res = mal.get(1);
        assertEquals("zwei", res);
        assertEquals(2, mal.size());
    }

    @Test
    public void testContains() {
        MyArrayList<String> mal = new MyArrayList<>();
        mal.add("eins");
        assertTrue(mal.contains("eins"));
        assertFalse(mal.contains("zwei"));
        mal.add("zwei");
        assertTrue(mal.contains("eins"));
        assertTrue(mal.contains("zwei"));
        assertFalse(mal.contains("drei"));
        mal.add("drei");
        assertTrue(mal.contains("eins"));
        assertTrue(mal.contains("zwei"));
        assertTrue(mal.contains("drei"));
        assertFalse(mal.contains("vier"));
    }

    @Test
    public void testClearAndAdd() {
        MyArrayList<String> mal = new MyArrayList<>();
        mal.add("eins");
        assertTrue(mal.contains("eins"));
        assertFalse(mal.contains("zwei"));
        mal.clear();
        assertFalse(mal.contains("eins"));
        assertEquals(0, mal.size());
        mal.add("eins");
        assertTrue(mal.contains("eins"));
    }

    @Test
    public void testSet1() {
        MyArrayList<String> mal = new MyArrayList<>();
        mal.add("eins");
        mal.add("zwei");
        mal.add("drei");
        String res = mal.set(1, "zweiNeu");
        assertEquals("zwei", res);
        res = mal.get(0);
        assertEquals("eins", res);
        res = mal.get(1);
        assertEquals("zweiNeu", res);
        res = mal.get(2);
        assertEquals("drei", res);
        assertEquals(3, mal.size());
    }

    @Test
    public void testIndexOf() {
        MyArrayList<String> mal = new MyArrayList<>();
        mal.add("eins");
        mal.add("zwei");
        mal.add("drei");
        mal.add("eins");
        assertEquals(0, mal.indexOf("eins"));
        assertEquals(1, mal.indexOf("zwei"));
        assertEquals(2, mal.indexOf("drei"));
        assertEquals(-1, mal.indexOf("vier"));
    }

    @Test
    public void testLastIndexOf() {
        MyArrayList<String> mal = new MyArrayList<>();
        mal.add("eins");
        mal.add("zwei");
        mal.add("drei");
        mal.add("eins");
        assertEquals(3, mal.lastIndexOf("eins"));
        assertEquals(1, mal.lastIndexOf("zwei"));
        assertEquals(2, mal.lastIndexOf("drei"));
        assertEquals(-1, mal.lastIndexOf("vier"));
    }

    @Test
    public void testManyOperations() {
        MyArrayList<String> mal = new MyArrayList<>();
        for (int i = 0; i < 1000; i++) {
            String s = "test" + i;
            mal.add(s);
            assertTrue(mal.contains(s));
            assertEquals(1 + i, mal.size());
        }
        for (int i = 0; i < 1000; i += 2) {
            String s = "test" + i;
            mal.remove(s);
            assertFalse(mal.contains(s));
            assertEquals(999 - i / 2, mal.size());
        }
        assertEquals(500, mal.size());
        for (int i = 0; i < 1000; i += 2) {
            String s = "toast" + i;
            mal.add(i, s);
            assertTrue(mal.contains(s));
            assertEquals(501 + i / 2, mal.size());
        }
        for (int i = 0; i < 1000; i++) {
            String res = mal.get(i);
            if (i % 2 == 0) {
                assertEquals("toast" + i, res);
            } else {
                assertEquals("test" + i, res);
            }
        }

    }
}
