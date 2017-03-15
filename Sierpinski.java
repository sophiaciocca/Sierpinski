/**********************************************
  * Name: Sophia Ciocca
  * PennKey: sciocca
  * Recitation: 211
  * 
  * Compilation: javac Sierpinksi.java
  * Execution: java Sierpinski
  * 
  * Creates a Sierpinski triangle of order N and size 0.5.
  * 
  * % java Sierpinksi 3
  * [draws Sierpinski triangle of order 3]
  ***********************************************/

public class Sierpinski {
    public static void main(String[] args) {   

        //get command-line argument N
        int N = Integer.parseInt(args[0]);
        
        //call sierpinski
        sierpinski(N, 0.5, 0.5, 0);
        
    }
     
    //----------------------NON-MAIN FUNCTIONS----------------------//
    
/*  
 * Name: singleTriangle
 * What it does: Creates a single triangle with its bottom vertex at (0, 0)
 * PreCondition: the user has entered an N value >= 0
 * PostCondition: A single triangle will be created
 */  
    public static void singleTriangle(double sideLength, double bottomVertexX, 
                                      double bottomVertexY) {
        
        //make arrays of triangle's vertex coordinates
        double[] xCoords = { bottomVertexX,
            bottomVertexX - 0.5 * sideLength,
            0.5 * sideLength + bottomVertexX };
        
        double[] yCoords = { bottomVertexY, 
            bottomVertexY + Math.sqrt(0.75) * sideLength,
            bottomVertexY + Math.sqrt(0.75) * sideLength };
        
        //use StdDraw.filledPolygon() to draw a filled equilateral triangle
        StdDraw.filledPolygon(xCoords, yCoords);
    }    
    
/*  
 * Name: sierpinski
 * What it does: Recursively calls itself to create recursive triangles
 * PreCondition: the user has entered an N value >= 0
 * PostCondition: a sequence of recursive triangles will be drawn 
 */  
    public static void sierpinski(int n, double size, double x, double y) {
        
        //base case
        if (n == 0) return;
        
        //recursively call itself 3 times w/ arguments n-1 & size / 2
        //upper:
        sierpinski(n - 1, size / 2, x, y + Math.sqrt(0.75) * size);
        //left:
        sierpinski(n - 1, size / 2, x - size / 2, y);
        //right:
        sierpinski(n - 1, size / 2, x + size / 2, y);
        
        //draw it:
        singleTriangle(size, x, y);
        
    }    
}