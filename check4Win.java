import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JFrame;

/**
 * This class checks the array 'theArray' to see if there is a four in a row in either the horizontal,
 * diagonal, and vertical directions and sends a call to the class displayWinner if there is.
 * 
 * @Satinderjit S. Dhaliwal 
 * @2016 School Project
 */
 abstract class check4Win extends Variables implements classNames
{
    // instance variables - replace the example below with your own

    /**
     * Constructor for objects of class check4Win
     */
    public check4Win(Graphics g)
    {
        // initialise instance variables
        super();
        // see if there are 4 disks in a row: horizontal, vertical or diagonal
        
        // horizontal rows
        for (int row = 0; row < super.MAXROW; row++) {
            for (int col = 0; col < super.MAXCOL-3; col++) {
                int curr = super.theArray[row][col];
                if (curr>0 && curr == super.theArray[row][col+1] && curr == super.theArray[row][col+2] && curr == super.theArray[row][col+3]) {
                    displayWinner(g, super.theArray[row][col]);
                }
            }
        }
        
        // vertical columns
        for (int col = 0; col < super.MAXCOL; col++) {
            for (int row = 0; row < super.MAXROW-3; row++) {
                int curr = super.theArray[row][col];
                if (curr > 0 && curr == super.theArray[row+1][col] && curr == super.theArray[row+2][col] && curr == super.theArray[row+3][col]){
                    displayWinner(g, super.theArray[row][col]);
                }
            }
        }
        
        // diagonal lower left to upper right
        for (int row = 0; row < super.MAXROW-3; row++) {
            for (int col = 0; col < super.MAXCOL-3; col++) {
                int curr = super.theArray[row][col];
                if (curr > 0 && curr == super.theArray[row+1][col+1] && curr == super.theArray[row+2][col+2] && curr == super.theArray[row+3][col+3]){
                    displayWinner(g, super.theArray[row][col]);
                }
            }
        }
        
        // diagonal upper left to lower right
        for (int row = super.MAXROW-1; row >= 3; row--) {
            for (int col = 0; col < super.MAXCOL-3; col++) {
                int curr = super.theArray[row][col];
                
                if (curr>0 && curr == super.theArray[row-1][col+1] && curr == super.theArray[row-2][col+2] && curr == super.theArray[row-3][col+3]){
                    displayWinner(g, super.theArray[row][col]);
                }
            }
        } 
    }// end check4
    

    public void displayWinner(Graphics g, int n)
    {
        g.setColor(new Color(128, 0, 255));
        g.setFont(new Font("Courier", Font.BOLD, 100));
        
        if (n != RED)
            g.drawString("Black wins!", 270, 400);
        else
            g.drawString("Red wins!", 270, 400);
            
        super.end=true;
    }
    
    
}
