package bag;

import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by yeqf on 5/15/15.
 */
public class MBagTest {

    @Before
    public void setUp() throws Exception {
        System.out.println("This is Before...");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("This is after...");
    }

    @Ignore
    //@Test
    public void test1() {
        System.out.println("this is test1");
    }

    @Test
    public void test2() {
        System.out.println("Hello ...");
    }
}