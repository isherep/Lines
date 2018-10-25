import java.awt.*;
import java.io.*;
import java.util.*;
import java.io.FileNotFoundException;

/**
 * Creates array of lines type Line, using plain text file with information about lines slope, 
 * intercept and rgb values indicating color
 * 
 *
 * @author Iryna Sherepot
 * @version 07/31/18
 */
public class LineSet{
    // instance variables 
    private int numOfLines;
    Line[] LineArray;
    
    /**
     * Constructor for objects of class LineSet
     * It uses Scanner to read  the file  lines,  and uses results to create Line objects, and fills in the array
     * of Line object references.
     * @param File lineFile the plain text file in which each line represents information about each line , and first line indicates
     * number of lines on a first line
     */
    public LineSet(File lineFile) throws FileNotFoundException{ 
        if(lineFile == null){
            throw new FileNotFoundException("File refference cannot be null");
        }
        
        Scanner FileIn = new Scanner(lineFile);
        numOfLines = FileIn.nextInt();
        if(numOfLines < 2){
            throw new  IllegalStateException ("File has to have 2 and more lines");
        }
        LineArray = new Line[numOfLines];
         int lineNum = 0;
        while(FileIn.hasNext()){
            //first line of file indicates number of lines in file
            double slope       = FileIn.nextDouble();
            double intercept   = FileIn.nextDouble();
            int red            = FileIn.nextInt();
            int green          = FileIn.nextInt();
            int blue           = FileIn.nextInt();
            Color color        = new Color(red,  green, blue);
            Line fileLine      = new Line(slope, intercept, color);
            LineArray[lineNum] = fileLine;
            lineNum++;
        }
        FileIn.close();
    }
    //-----------------ACCESORS----------------
    /**
     * Counts amount of lines represented in file
     * @return    the number of lines file contains
     */
    public int lineCount()
    {
        // scan top number of lines from the file
        return numOfLines;
    }

    /**
     * Finds largest Y intercept in a array of Line objects
     * @return the max Y intercept
     */
    public double maxYIntercept(){
        double  maxYIntercept = this.LineArray[0].getIntercept();
        for (int i = 0; i < numOfLines; i++ ){
            if(LineArray[i].getIntercept() > maxYIntercept){
                maxYIntercept = LineArray[i].getIntercept();
            }
        }
        return maxYIntercept;
    }

    /**
     * Finds smallest Y intercept in a array of Line objects
     * @return the min Y intercept
     */
    public double minYIntercept(){
        double  minYIntercept = this.LineArray[0].getIntercept();
        for (int i = 0; i < numOfLines; i++){
            if(LineArray[i].getIntercept() < minYIntercept){
                minYIntercept = LineArray[i].getIntercept();
            }
        }
        return minYIntercept;
    }

    /**
     * Finds largest X intercept in a array of Line objects
     * @return the max X intercept
     */
    public double maxXIntercept(){
        double  maxXIntercept = this.LineArray[0].getXIntercept();
        for (int i = 0; i < numOfLines; i++){
            if(LineArray[i].getXIntercept() > maxXIntercept){
                maxXIntercept = LineArray[i].getXIntercept();
            }
        }
        return maxXIntercept;
    }

    /**
     * Finds smallest X intercept in a array of Line objects
     * @return the min X intercept
     */
    public double minXIntercept(){
        double  minXIntercept = this.LineArray[0].getXIntercept();
        for (int i = 0; i < numOfLines; i++){
            if(LineArray[i].getXIntercept() < minXIntercept){
                minXIntercept = LineArray[i].getXIntercept();
            }
        }
        return minXIntercept;
    }

    /**
     * Calculates average brighness of lines in a Lineset 
     * @return average line brightness in a set
     */
    public double avgBrightness(){
        double sumBrightness = 0.0;
        for ( int i = 0; i < numOfLines; i++){
            sumBrightness += LineArray[i].brightness();
        }
        return sumBrightness / numOfLines;
    }

    /**
     * Reaches and returns a line of given index from LineSet array
     * @param lineIndex the index of line in a array
     */
    public Line getLine(int lineIndex){
        return LineArray[lineIndex];
    }
    //==================OTHER METHODS====================
    /**
     * Sorts lines in a array by slope
     */
    public void sortBySlope(){
        for(int i = 1; i < LineArray.length; i++){
            Line temp = LineArray[i];
            int j;
            for (j = i - 1; j >= 0 && temp.getSlope() < (LineArray[j].getSlope()); j--){
                LineArray[j + 1] = LineArray[j];   
            }
            LineArray[j + 1]=temp;
        }
    }

    /**
     * Finds and returns the longest sequence of
     * non-decreasing values
     * @return the array of lines with non decreasing brightness values
     */
    public Line[] nonDecrBrightSeq() {
        int bestStart = 0;
        int bestLength = 1;
        int currentStart = 0;
        int currentLength = 1;
        int j;
        double prevValue = LineArray[0].brightness();
        double currentValue;
        while(currentStart + currentLength < LineArray.length){
            currentValue = LineArray[currentStart + currentLength].brightness();
            if(currentValue >= prevValue){
                currentLength += 1;
            } else{
                if(currentLength > bestLength){
                    bestStart = currentStart;
                    bestLength = currentLength;
                }
                currentStart = currentStart + currentLength;
                currentLength = 1;
            }
            prevValue = currentValue;
        }
        if(currentLength > bestLength){
            bestStart = currentStart;
            bestLength = currentLength;
        }

        Line[] NonDecBright = new Line[bestLength];

        for(int k = 0; k<bestLength; k++){
            NonDecBright[k] = LineArray[bestStart + k];
        }
        System.out.println(NonDecBright); 
        return NonDecBright;
    }
    /**
     * Returns a string representation of LineSet instance variables.
     * @return info String representation instance variables
     */
    public String toString(){
        String info = ""; 
        info += "Number of lines: "   + numOfLines + "\n";
        info += "The lines in an array are: " + Arrays.toString(LineArray);
        return info;
    }
public static void main(String[] args) throws FileNotFoundException{
     File lineFile = new File("lines.txt");
        LineSet MylineSet = new LineSet(lineFile);

        System.out.println(MylineSet);
}
}
