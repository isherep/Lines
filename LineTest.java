
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.awt.*;

/**
 * The test class LineTest.
 *
 * @author  Iryna Sherepot
 * @version 7/28/18
 */
public class LineTest{
    /**
     * Default constructor for test class LineTest
     */
    public LineTest(){
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp(){
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown(){
    }

    /**
     * Tests full constructor of object Line
     */
    @Test
    public void testFullConstructor(){
        Line testLine = new Line(1.0,1.0, Color.BLACK);
        assertEquals(1.0,           testLine.getSlope(),     2);
        assertEquals(1.0,           testLine.getIntercept(), 2);
        assertEquals(-1.0,          testLine.getXIntercept(),2);
        //BLACK is rgb(0,0,0)
        assertEquals( 0.0,          testLine.brightness(),   2);
        assertEquals(Color.BLACK,   testLine.getColor());

    }

    /**
     * Tests mutators
     */
    @Test
    public void testSetMethods(){
        Line testLine = new Line(1.0, 1.0, Color.BLACK);

        testLine.setSlope(2.0);
        testLine.setInterept(2.0);
        testLine.setColor(Color.RED);
        assertEquals(2.0, testLine.getSlope(),      2);
        assertEquals(2.0, testLine.getIntercept(),  2);
        assertEquals(Color.RED, testLine.getColor()); 
    }

    /**
     * Tests findIntersect() method
     */
    @Test
    public void testFindIntersect(){
        Line testLine  = new Line(1.0, 5.0, Color.RED);
        Line testLine1 = new Line(2.0,- 1.0, Color.RED);
        assertEquals(-6.0,  testLine1.findIntersect(testLine).getX(), 2);
        assertEquals(-11.0, testLine1.findIntersect(testLine).getY(), 2);
    }

}
