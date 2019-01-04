# Lines and More Lines

This is a coursework project from CSC 142 Class.

Project uses new concepts: reading data from a file and storing objects in an array.
This program has no user interface except for drawing panel output (in the extra credit portion) but will
certainly have unit tests that ensures all objects/methods are behaving as intended.


Using the input file with information about lines, create lines.

The input file will contain the following elements, in order:
• On the first line, an integer indicating how many Lines are represented in the file.
• One additional data line per Line, each having doubles representing slope and y intercept followed by
three integers representing the red, green, and blue components of the line’s color. The color
• Data elements are separated by spaces.
4.2 Example Contents
2
4.0 -2.0 240 56 33
1.0 5.0 0 200 175
The example file’s contents are interpreted as follows:
• There are two Lines represented in the file
• The first line’s equation is y = 4x – 2 and has color R=240, G=56, and B=33.
• The second line’s equation is y = x + 5 and has color R=0, G=200, B=175.

Line

Constructors
+Line()
+Line(slope : Double, intercept : Double,
color : Color)

Accessors
+getSlope() : Double
+getIntercept() : Double
+getXIntercept() : Double
+getColor() : Color
+brightness() : Double
+toString() : String

Mutators
+setSlope(slope : Double)
+setIntercept(intercept : Double)
+setColor(color : Color)
Other Methods
+findIntersect(otherLine : Line) : Point

LineSet

Constructors
+LineSet(File lineFile)
Accessors
+lineCount() : Integer
+maxYIntercept() : Double
+minYIntercept() : Double
+maxXIntercept() : Double
+minXIntercept() : Double
+avgBrightness() : Double
+getLine(lineIndex : Integer) : Line
+toString() : String
Mutators
(none)
Other Methods
+nonDecrBrightSeq() : Line[]
+sortBySlope()
+drawLines() (extra credit)

