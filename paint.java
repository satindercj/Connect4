import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 * This class using the Connect4JFrame creates the acutal Connect4 Board game and works with the
 * action Panel to color in the disks
 * 
 * @Satinderjit S. Dhaliwal
 * @2016 School Project
 */
class paint extends Connect4JFrame
{
    // instance variables - replace the example below with your own

    /**
     * Constructor for objects of class paint
     */
    public paint(Graphics g)
    {
        // initialise instance variables
        super();
      
        // Set to a reasonable size.
        setSize(1024, 768);
        
        g.setColor(new Color(0, 153, 255));
        g.fillRect(0, 0, super.getWidth(), super.getHeight());
        
        g.setColor(new Color(252, 245, 3));
        g.fillRect(110, 50, 100+100*super.MAXCOL, 100+100*super.MAXROW);
      
        
        for (int row=0; row < super.MAXROW; row++){
            for (int col=0; col < super.MAXCOL; col++) {
                if (theArray[row][col] == super.BLANK){ 
                    g.setColor(new Color(210, 210, 210));
                }
                
                if (theArray[row][col]== super.RED){
                    g.setColor(Color.RED);
                }
                
                if (theArray[row][col]== super.BLACK) {
                    g.setColor(Color.BLACK);
                }
                
                g.fillOval(160+100*col, 100+100*row, 100, 100);
                
                
            }
        }    
        
        //check4Win(g);
    } // paint
}
