import java.awt.*;
import java.lang.Math.*;
/**
 * Creates object linear line using slope, intercept and color.
 *
 * @author Iryna Sherepot
 * @version 7/28/18
 */
public class Line{
    // instance variables 
    private double slope;
    private double intercept;
    private Color  color;

    /**
     * Simple constructor for objects of class Line
     */
    public Line(){
        this(0.0, 0.0, Color.BLACK);
    }

    /**
     * Full constructor for Line
     * @param the slope of a line
     * @param the y intercept of a line
     * @param the color of line
     */
    public Line(double slope, double intercept, Color color){
        if(color == null){
            throw new IllegalArgumentException("Color cannot be null");
        }
        setSlope(slope);
        setInterept(intercept);
        setColor(color);
    }
    //===============ACCESSORS==================
    /**
     * Accesses slope field of line class
     * @return the slope of the line
     */
    public double getSlope(){
        return this.slope;
    }

    /**
     * Accesses intercept field of line class
     * @return the intercept of a line
     */
    public double getIntercept(){
        return this.intercept;
    }

    /**
     * Calclates X Intercept of line 
     * @return the X intercept of the line
     */
    public double getXIntercept(){
        return (-intercept) / slope;
    }

    /**
     * Accesses color field of line class
     * @return line color
     */
    public Color getColor(){
        return color;
    }

    /**
     * Calculates line brightness  based on the red, green, and blue components of a color. 
     * @return brightness value
     */
    public double brightness(){
        return Math.sqrt(0.241 * Math.pow(getColor().getRed(),  2) 
                        + 0.691 * Math.pow(getColor().getGreen(),2) 
                        + 0.068 * Math.pow(getColor().getBlue(), 2));
    }

    //===============MUTATORS=====================
    /**
     * Allows to set a line slope to a different value
     * @param double slope  the  slope of a line
     */
    public void setSlope(double slope){
        this.slope = slope;
    }    

    /**
     * Allows to set a line y intercept to a different value
     * @param double intercept  the  slope of a line
     */
    public void setInterept(double intercept){
        this.intercept = intercept;
    }

    /**
     * Allows to set a line color to a different value
     * @param java.awt.Color color of a line
     */
    public void setColor(Color color){
        if(color == null){
            throw new IllegalArgumentException("Color cannot be null");
        }
        this.color = color;
    }

    //===============OTHER METHODS==================
    /**
     * Finds intersect point of two lines
     * @param second line
     * @return the point where two lines intercept
     */
    public Point findIntersect(Line otherLine){
        if(otherLine.slope == this.slope){
            throw new IllegalArgumentException("Lines are paralel");
        }
        double xCoord = (otherLine.intercept - this.intercept) / (otherLine.slope - this.slope);
        double yCoord = this.slope * xCoord - this.intercept;
        Point interceptPoint = new Point(xCoord, yCoord);

        return interceptPoint;
    }

    /**
     * Returns a string representation of Line
     * @return String representation instance variables
     */
    public String toString(){
        String info = "";
        info += "\nLine slope is: "      +  this.slope + "\n";
        info += "Line intercept is: "    +  this.intercept + "\n";
        info += "Line color is: "        +  this.color + "\n";
        info += String.format("Line X intercept is: %5.2f%n" , this.getXIntercept());
        info += String.format("Line brightness is %5.2f%n%n",   this.brightness());

        return info;
    }

}