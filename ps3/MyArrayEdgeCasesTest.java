import static org.junit.Assert.*;
import org.junit.Test;

public class MyArrayEdgeCasesTest {

    @Test
    public void testComputeStatistics() {
        MyArray arr = new MyArray(new int[]{10, 20, 30, 40});
        assertEquals(100, arr.getSum());
        assertEquals(10, arr.getMin());
        assertEquals(40, arr.getMax());
        assertEquals(25.0, arr.getAvg(), 0.001);
    }

    @Test
    public void testInsertElementEdgeCases() {
        MyArray arr = new MyArray(new int[]{12, 15, 20});
        assertTrue(arr.insertElement(10, 0));  // Insert at start
        assertTrue(arr.insertElement(25, arr.getArr().length - 1)); // Insert at end
        assertFalse(arr.insertElement(30, -1)); // Invalid position
        assertFalse(arr.insertElement(35, arr.getArr().length + 1)); // Out of bounds
    }

    @Test
    public void testRemoveElementEdgeCases() {
        MyArray arr = new MyArray(new int[]{10, 20, 30, 40});
        assertEquals(10, arr.removeElement(0)); // Remove first
        assertEquals(40, arr.removeElement(arr.getArr().length - 1)); // Remove last
        assertEquals(-1, arr.removeElement(-1)); // Invalid position
        assertEquals(-1, arr.removeElement(arr.getArr().length)); // Out of bounds
    }

    @Test
    public void testGrowArrayEdgeCases() {
        MyArray arr = new MyArray(2);
        assertFalse(arr.growArray(0)); // Should return false
        assertFalse(arr.growArray(-5)); // Should return false
        assertTrue(arr.growArray(5)); // Should succeed
    }

    @Test
    public void testNumOccurrencesEdgeCases() {
        MyArray arr = new MyArray(new int[]{10, 20, 20, 30});
        assertEquals(2, arr.numOccurences(20)); // Multiple occurrences
        assertEquals(0, arr.numOccurences(50)); // Non-existent element
    }

    @Test
    public void testComputeHistogramEdgeCases() {
        MyArray emptyArr = new MyArray();
        assertEquals("", emptyArr.computeHistogram()); // Empty case

        MyArray arr = new MyArray(new int[]{5});
        assertEquals("*****\n", arr.computeHistogram()); // Single element
    }
}
