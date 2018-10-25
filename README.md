# Lines

The input file will contain the following elements, in order:
• On the first line, an integer indicating how many Lines are represented in the file.
• One additional data line per Line, each having doubles representing slope and y intercept followed by
three integers representing the red, green, and blue components of the line’s color. The color
elements are in the range of 0 to 255.
• Data elements are separated by spaces.
4.2 Example Contents
2
4.0 -2.0 240 56 33
1.0 5.0 0 200 175
The example file’s contents are interpreted as follows:
• There are two Lines represented in the file
• The first line’s equation is y = 4x – 2 and has color R=240, G=56, and B=33.
• The second line’s equation is y = x + 5 and has color R=0, G=200, B=175.
4.3 Notes
• Create the file in notepad or in another text editor.
• If you rely on text files for testing (this is expected), don’t forget to include them in your submission.
• You are not responsible for bad data; if the file isn’t created correctly and it blows up your program,
that’s okay for now.

 UML Class Diagrams for the classes you are to create. Create exactly these methods, with exactly
the parameters and return types shown. See the next page for other important notes.:

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

