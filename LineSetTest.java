import java.util.*;
import java.io.*;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.awt.*;

/**
 * The test class LineSetTest.
 *
 * @author  Iryna
 * @version 8/28/18
 */
public class LineSetTest{
    /**
     * Default constructor for test class LineSetTest
     */
    public LineSetTest(){
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
     * Tests full construtor of object LineSet
     */
    @Test
    public void testFullConstructor() throws FileNotFoundException {

        File lineFile = new File("lines.txt");
        LineSet MylineSet = new LineSet(lineFile);

        assertEquals(4,     MylineSet.lineCount());
        assertEquals(5.0,   MylineSet.maxYIntercept(), 2);
        assertEquals(-2.0,  MylineSet.minYIntercept(), 2);
        assertEquals(0.5,   MylineSet.maxXIntercept(), 2);
        assertEquals(-5.0,  MylineSet.minXIntercept(), 2);
        assertEquals(163.59,MylineSet.avgBrightness(), 2);
        System.out.println(MylineSet);

    }

    /**
    * Tests construtor preconditions
    */
    @Test(expected = IllegalStateException.class)
    public void testConstrPrecond() throws FileNotFoundException{
        File    lineFile  = new File("lines1.txt");
        LineSet MylineSet = new LineSet(lineFile);
        assertEquals(1, MylineSet.lineCount());
    }

    /** 
     * Tests getLine() method.
     */
    @Test
    public void testGetLine() throws FileNotFoundException{
        File lineFile = new File("lines.txt");
        LineSet MylineSet = new LineSet(lineFile); 

        assertEquals(4.0,   MylineSet.getLine(0).getSlope(),     2);
        assertEquals(-2.0,  MylineSet.getLine(0).getIntercept(), 2);
        Color testColor = new Color(240, 56,33);
        assertEquals(testColor, MylineSet.getLine(0).getColor());
        assertEquals(240,       MylineSet.getLine(0).getColor().getRed());
        assertEquals(56,        MylineSet.getLine(0).getColor().getGreen());
        assertEquals(33,        MylineSet.getLine(0).getColor().getBlue());
    }

    /**
     * Tests sorting by the slope.
     */
    @Test
    public void testSortBySlope() throws FileNotFoundException{
        //testing first original file
        File    lineFile = new File("lines.txt");
        LineSet MylineSet = new LineSet(lineFile); 

        MylineSet.sortBySlope();
        assertEquals(1.0, MylineSet.LineArray[0].getSlope(),2);
        assertEquals(2.0, MylineSet.LineArray[1].getSlope(),2);
        assertEquals(3.0, MylineSet.LineArray[2].getSlope(),2);
        assertEquals(4.0, MylineSet.LineArray[3].getSlope(),2);

        //testing worst case scenario file
        File    lineFileWorst = new File("lines_worst.txt");
        LineSet MylineSetWorst = new LineSet(lineFileWorst); 

        MylineSetWorst.sortBySlope();
        assertEquals(0.5, MylineSetWorst.LineArray[0].getSlope(),2);
        assertEquals(2.9, MylineSetWorst.LineArray[1].getSlope(),2);
        assertEquals(3.0, MylineSetWorst.LineArray[2].getSlope(),2);
        assertEquals(5.1, MylineSetWorst.LineArray[3].getSlope(),2);
        assertEquals(6.0, MylineSetWorst.LineArray[4].getSlope(),2);
        assertEquals(7.2, MylineSetWorst.LineArray[5].getSlope(),2);
        assertEquals(8.0, MylineSetWorst.LineArray[6].getSlope(),2);
        assertEquals(10.5,MylineSetWorst.LineArray[7].getSlope(),2);
    }

    /**
     * Tests n onDecrBrightness() method
     */
    @Test
    public void testNonDecrBrightness() throws FileNotFoundException{
        File lineFile =     new File("lines_brightness1.txt");
        LineSet MylineSet = new LineSet(lineFile); 
        Line[] NonDecBright = MylineSet.nonDecrBrightSeq();
        assertEquals(0.0,NonDecBright[0].brightness(), 2);

        File lineFile1 =     new File("lines.txt");
        LineSet MylineSet1 = new LineSet(lineFile1); 
        Line[] NonDecBright1 = MylineSet1.nonDecrBrightSeq();
        assertEquals(126.97,NonDecBright1[0].brightness(), 2);
    }
    
}
