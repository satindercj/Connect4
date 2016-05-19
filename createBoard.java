import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JFrame;
/**
 * This class creates an two-demensional array waiting for user input based on what which column
 * the user chooses in the game
 * 
 * @Satinderjit S. Dhaliwal
 * @2016 School Year Project
 */
public class createBoard extends Variables
{
    // instance variables - replace the example below with your own
    /**
     * Constructor for objects of class Initialize
     */
    public createBoard()
    {
        // initialise instance variables
        super();
       
        theArray=new int[MAXROW][MAXCOL];
        
        for (int row = 0; row < MAXROW; row++){
            for (int col = 0; col < MAXCOL; col++){
                theArray[row][col] = BLANK;
                
            }
        }
        
        gameStart = false;
    } // initialize
}
