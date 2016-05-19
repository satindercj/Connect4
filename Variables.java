
/**
 * Abstract class Variables - write a description of the class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class Variables
{
    // instance variables - replace the example below with your own
    int[][] theArray;
    boolean end=false;
    boolean gameStart;
    
    public static final int BLANK = 0;
    public static final int RED = 1;
    public static final int BLACK = 2;

    public static final int MAXROW = 6; // 6 rows
    public static final int MAXCOL = 7; // 7 columns

    public static final String SPACE = "                  "; // 18 spaces

    int activeColour = RED;
}
