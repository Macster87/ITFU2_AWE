import org.junit.*;

import static org.junit.Assert.*;


public class MyLinkedListTest {

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

//
	@Test
    public void testNew() {
        MyLinkedList mll = new MyLinkedList();
        assertNotNull(mll);
    }

	@Test
    public void testNewAndSize() {
        MyLinkedList mll = new MyLinkedList();
        assertEquals(0, mll.size());
    }

	@Test
    public void testAdd1() {
        MyLinkedList mll = new MyLinkedList();
        mll.add("eins");
        assertEquals(1, mll.size());
    }

	@Test
    public void testAdd2() {
        MyLinkedList mll = new MyLinkedList();
        mll.add("eins");
        assertEquals(1, mll.size());
        mll.add("zwei");
        assertEquals(2, mll.size());
    }

	@Test
    public void testGet1() {
        MyLinkedList mll = new MyLinkedList();
        mll.add("eins");
        String res = mll.get(0);
        assertEquals("eins", res);
    }

	@Test
    public void testGet2() {
        MyLinkedList mll = new MyLinkedList();
        mll.add("eins");
        mll.add("zwei");
        String res = mll.get(1);
        assertEquals("zwei", res);
    }

	@Test
    public void testGet3() {
        MyLinkedList mll = new MyLinkedList();
        mll.add("eins");
        mll.add("zwei");
        mll.add("drei");
        String res = mll.get(0);
        assertEquals("eins", res);
        res = mll.get(1);
        assertEquals("zwei", res);
        res = mll.get(2);
        assertEquals("drei", res);
    }


	@Test
    public void testAdd10() {
        MyLinkedList mll = new MyLinkedList();
        for (int i=0;i<10;i++) {
            String s = String.format("Element%02d", i);
            mll.add(s);
            assertEquals(i+1, mll.size());
            assertEquals(s,mll.get(i));
        }
    }

	@Test
    public void testAddAtIndex() {
        MyLinkedList mll = new MyLinkedList();
        mll.add("eins");
        mll.add("zwei");
        mll.add("drei");
        mll.add(1, "einsA");
        String res = mll.get(0);
        assertEquals("eins", res);
        res = mll.get(1);
        assertEquals("einsA", res);
        res = mll.get(2);
        assertEquals("zwei", res);
    }

	@Test
    public void testAddAtIndex0() {
        MyLinkedList mll = new MyLinkedList();
        mll.add("eins");
        mll.add("zwei");
        mll.add("drei");
        mll.add(0, "null");
        String res = mll.get(0);
        assertEquals("null", res);
        res = mll.get(1);
        assertEquals("eins", res);
        res = mll.get(2);
        assertEquals("zwei", res);
        assertEquals(4, mll.size());
    }

	@Test
    public void testRemoveHead() {
        MyLinkedList mll = new MyLinkedList();
        mll.add("eins");
        mll.add("zwei");
        mll.add("drei");
        assertTrue(mll.remove("eins"));
        String res = mll.get(0);
        assertEquals("zwei", res);
        assertEquals(2, mll.size());
        assertFalse(mll.contains("eins"));
    }

	@Test
    public void testRemoveTail() {
        MyLinkedList mll = new MyLinkedList();
        mll.add("eins");
        mll.add("zwei");
        mll.add("drei");
        mll.remove("drei");
        String res = mll.get(1);
        assertEquals("zwei", res);
        assertEquals(2, mll.size());
    }

	@Test
    public void testRemoveIndex1() {
        MyLinkedList mll = new MyLinkedList();
        mll.add("eins");
        mll.add("zwei");
        mll.add("drei");
        String res = mll.remove(1);
        assertEquals("zwei", res);
        res = mll.get(0);
        assertEquals("eins", res);
        res = mll.get(1);
        assertEquals("drei", res);
        assertEquals(2, mll.size());
    }

   	@Test
    public void testRemoveNone() {
        MyLinkedList mll = new MyLinkedList();
        mll.add("eins");
        mll.add("zwei");
        mll.add("drei");
        boolean res = mll.remove("zwei");
        assertTrue(res); 
        res = mll.remove("zwei");
        assertFalse(res);
    }

	@Test
    public void testRemoveIndex0() {
        MyLinkedList mll = new MyLinkedList();
        mll.add("eins");
        mll.add("zwei");
        mll.add("drei");
        String res = mll.remove(0);
        assertEquals("eins", res);
        res = mll.get(0);
        assertEquals("zwei", res);
        res = mll.get(1);
        assertEquals("drei", res);
        assertEquals(2, mll.size());
    }

	@Test
    public void testRemoveIndexLast() {
        MyLinkedList mll = new MyLinkedList();
        mll.add("eins");
        mll.add("zwei");
        mll.add("drei");
        String res = mll.remove(mll.size() - 1);
        assertEquals("drei", res);
        assertFalse(mll.contains("drei"));
        res = mll.get(0);
        assertEquals("eins", res);
        res = mll.get(1);
        assertEquals("zwei", res);
        assertEquals(2, mll.size());
    }

	@Test
    public void testContains() {
        MyLinkedList mll = new MyLinkedList();
        mll.add("eins");
        assertTrue(mll.contains("eins"));
        assertFalse(mll.contains("zwei"));
        mll.add("zwei");
        assertTrue(mll.contains("eins"));
        assertTrue(mll.contains("zwei"));
        assertFalse(mll.contains("drei"));
        mll.add("drei");
        assertTrue(mll.contains("eins"));
        assertTrue(mll.contains("zwei"));
        assertTrue(mll.contains("drei"));
        assertFalse(mll.contains("vier"));
    }

    @Test
    public void testContains2() {
        MyLinkedList mll = new MyLinkedList();
        String s = "ei";
        s += "ns";
        mll.add("eins");
        assertTrue(mll.contains("eins"));
        assertFalse(mll.contains("zwei"));
     }

	@Test
    public void testClearAndAdd() {
        MyLinkedList mll = new MyLinkedList();
        mll.add("eins");
        assertTrue(mll.contains("eins"));
        assertFalse(mll.contains("zwei"));
        mll.clear();
        assertFalse(mll.contains("eins"));
        assertEquals(0, mll.size());
        mll.add("eins");
        assertTrue(mll.contains("eins"));
    }

@Test
    public void testSet1() {
        MyLinkedList mll = new MyLinkedList();
        mll.add("eins");
        mll.add("zweiAlt");
        mll.add("drei");
        String res = mll.set(1, "zweiNeu");
        assertEquals("zweiAlt", res);
        res = mll.get(0);
        assertEquals("eins", res);
        res = mll.get(1);
        assertEquals("zweiNeu", res);
        res = mll.get(2);
        assertEquals("drei", res);
        assertEquals(3, mll.size());
    }
    
   


	@Test
    public void testIndexOf() {
        MyLinkedList mll = new MyLinkedList();
        mll.add("eins");
        mll.add("zwei");
        mll.add("drei");
        mll.add("eins");
        assertEquals(0, mll.indexOf("eins"));
        assertEquals(1, mll.indexOf("zwei"));
        assertEquals(2, mll.indexOf("drei"));
        assertEquals(-1, mll.indexOf("vier"));
    }

	@Test
    public void testLastIndexOf() {
        MyLinkedList mll = new MyLinkedList();
        mll.add("eins");
        mll.add("zwei");
        mll.add("drei");
        mll.add("eins");
        assertEquals(3, mll.lastIndexOf("eins"));
        assertEquals(1, mll.lastIndexOf("zwei"));
        assertEquals(2, mll.lastIndexOf("drei"));
        assertEquals(-1, mll.lastIndexOf("vier"));
    }

	@Test
    public void testManyOperations() {
        MyLinkedList mll = new MyLinkedList();
        for (int i = 0; i < 1000; i++) {
            String s = "test" + i;
            mll.add(s);
            assertTrue(mll.contains(s));
            assertEquals(1 + i, mll.size());
        }
        for (int i = 0; i < 1000; i += 2) {
            String s = "test" + i;
            mll.remove(s);
            assertFalse(mll.contains(s));
            assertEquals(999 - i / 2, mll.size());
        }
        assertEquals(500, mll.size());
        for (int i = 0; i < 1000; i += 2) {
            String s = "toast" + i;
            mll.add(i, s);
            assertTrue(mll.contains(s));
            assertEquals(501 + i / 2, mll.size());
        }
        for (int i = 0; i < 1000; i++) {
            String res = mll.get(i);
            if (i % 2 == 0) {
                assertEquals("toast" + i, res);
            } else {
                assertEquals("test" + i, res);
            }
        }

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddAtIndex10() {
        MyLinkedList mll = new MyLinkedList();
        mll.add("eins");
        mll.add("zwei");
        mll.add("drei");
        mll.add(10, "zehn");
        mll.add(3, "zehn");
        String res = mll.get(0);
        assertEquals("eins", res);
        res = mll.get(1);
        assertEquals("einsA", res);
        res = mll.get(2);
        assertEquals("zwei", res);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSet10() {
        MyLinkedList mll = new MyLinkedList();
        mll.add("eins");
        mll.add("zwei");
        mll.add("drei");
        String res = mll.set(10, "zehn");
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSet3() {
        MyLinkedList mll = new MyLinkedList();
        mll.add("eins");
        mll.add("zwei");
        mll.add("drei");
        String res = mll.set(3, "zehn");
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemove10() {
        MyLinkedList mll = new MyLinkedList();
        mll.add("eins");
        mll.add("zwei");
        mll.add("drei");
        mll.remove(10);
    }
}
