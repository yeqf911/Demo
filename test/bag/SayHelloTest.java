package bag;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by yeqf on 5/15/15.
 */
public class SayHelloTest {
    private SayHello sayHello;

    @Before
    public void setUp() throws Exception {
        sayHello = new SayHello();
    }

    @Test
    public void testSay() throws Exception {
        assertEquals("Hello",sayHello.say());
        System.out.println("tongguo");
    }
}