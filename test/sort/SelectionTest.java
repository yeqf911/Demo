package sort;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by yeqf on 5/16/15.
 *
 */
public class SelectionTest {

    @Test
    public void testSort() throws Exception {
        Integer[] a = new Integer[5];
        a[0] = 6;
        a[1] = 3;
        a[2] = 1;
        a[3] = 7;
        a[4] = 4;
        Selection.sort(a);
        assertEquals(true,Insertion.isSorted(a));
    }
}