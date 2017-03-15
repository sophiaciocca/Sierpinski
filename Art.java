/**********************************************
  * Name: Sophia Ciocca
  * PennKey: sciocca
  * Recitation: 211
  * 
  * Compilation: javac Art.java
  * Execution: java Art
  * 
  * Creates an interesting pattern. Squares on squares on squares creates
  * cool shapes, looooook
  *
  * 
  * % java Art 8
  * (creates a cool pattern. see for yourself)
  ***********************************************/

public class Art {
    public static void main(String[] args) {   

        //get command-line argument N
        int N = Integer.parseInt(args[0]);
        
        //call recursiveSquares (values below are for the first square)
        recursiveSquares(N, 0.5, 0.5, 0.125); 
        
    }
    
    
    //----------------------NON-MAIN FUNCTIONS----------------------//
    
  
 /*  
 * Name: recursiveSquares
 * What it does: Creates a sequence of recursive squares, recursing n times
 * PreCondition: the user has entered an N value >= 0
 * PostCondition: a sequence of recursive squares will be drawn  
 */  
   public static void recursiveSquares(int n, double x, double y, double r) {
        
        //base case
        if (n == 0) return;
        
        //recursively call itself 4 times w/ arguments n - 1 & r / 3
        //upper:
        recursiveSquares(n - 1, x, y + 2 * r, r / 2);
        //left:
        recursiveSquares(n - 1, x - 2 * r, y, r / 2);
        //right:
        recursiveSquares(n - 1, x + 2 * r, y, r / 2);
        //bottom:
        recursiveSquares(n - 1, x, y - 2 * r, r / 2);
        
        //draw it:
        StdDraw.filledSquare(x, y, r);
        
   }    
}