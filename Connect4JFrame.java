import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JFrame;
/**
 * This class would focus establishing the Connect 4 JFrame, setting up the actionPanel, Working
 * the menu bar, and putting down the disk in each position.
 * 
 * @Satinderjit S. Dhaliwal
 * @2016 School Year Project
 */

class Connect4JFrame extends JFrame  implements ActionListener {

    private Button btn1, btn2, btn3, btn4, btn5, btn6, btn7;
    private Label lblSpacer;
    MenuItem newMI, exitMI, redMI, blackMI;
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
    int height = 1024;
    int width = 768;

    public Connect4JFrame() {
        MenuBar mbar = new MenuBar();
        Menu fileMenu = new Menu("File");
        newMI = new MenuItem("New");
        newMI.addActionListener(this);
        fileMenu.add(newMI);
        exitMI = new MenuItem("Exit");
        exitMI.addActionListener(this);
        fileMenu.add(exitMI);
        mbar.add(fileMenu);
        Menu optMenu = new Menu("Options");
        redMI = new MenuItem("Red starts");
        redMI.addActionListener(this);
        optMenu.add(redMI);
        blackMI = new MenuItem("Black starts");
        blackMI.addActionListener(this);
        optMenu.add(blackMI);
        mbar.add(optMenu);
        setMenuBar(mbar);
        // Set to a reasonable size.
        
        Integer myValue = new Integer(height);
        int value = myValue.intValue();
        Integer twoValue = new Integer(width);
        double secValue = twoValue.doubleValue();
        int value2 = (int) secValue;
        setSize(value, value2);

        
        
        
        
        // Build control Panel.
        Panel cPanel = new Panel();
        
        
        cPanel.setBackground(new Color(128, 0, 255));
        
        btn1 = new Button("1");
        btn1.addActionListener(this);
        cPanel.add(btn1);
        btn1.setBackground(new Color(0, 255, 0));
        lblSpacer = new Label(SPACE);
        cPanel.add(lblSpacer);

        btn2 = new Button("2");
        btn2.addActionListener(this);
        cPanel.add(btn2);
        btn2.setBackground(new Color(0, 255, 0));
        lblSpacer = new Label(SPACE);
        cPanel.add(lblSpacer);

        btn3 = new Button("3");
        btn3.addActionListener(this);
        cPanel.add(btn3);
        btn3.setBackground(new Color(0, 255, 0));
        lblSpacer = new Label(SPACE);
        cPanel.add(lblSpacer);

        btn4 = new Button("4");
        btn4.addActionListener(this);
        cPanel.add(btn4);
        btn4.setBackground(new Color(0, 255, 0));
        lblSpacer = new Label(SPACE);
        cPanel.add(lblSpacer);

        btn5 = new Button("5");
        btn5.addActionListener(this);
        cPanel.add(btn5);
        btn5.setBackground(new Color(0, 255, 0));
        lblSpacer = new Label(SPACE);
        cPanel.add(lblSpacer);

        btn6 = new Button("6");
        btn6.addActionListener(this);
        cPanel.add(btn6);
        btn6.setBackground(new Color(0, 255, 0));
        lblSpacer = new Label(SPACE);
        cPanel.add(lblSpacer);

        btn7 = new Button("7");
        btn7.addActionListener(this);
        cPanel.add(btn7);
        btn7.setBackground(new Color(0, 255, 0));
        add(cPanel, BorderLayout.NORTH);
        initialize();
        
        
        
    } // Connect4
    
    public void initialize() {
        theArray=new int[MAXROW][MAXCOL];
        
        for (int row = 0; row < MAXROW; row++){
            for (int col = 0; col < MAXCOL; col++){
                theArray[row][col]=BLANK;
                
            }
        }
        
        gameStart=false;
    } // initialize
    
    //
    public void paint(Graphics g) {
        
        g.setColor(new Color(0, 153, 255));
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        
        g.setColor(new Color(252, 245, 3));
        g.fillRect(110, 50, 100+100*MAXCOL, 100+100*MAXROW);
      
        
        for (int row=0; row < MAXROW; row++){
            for (int col=0; col < MAXCOL; col++) {
                if (theArray[row][col] == BLANK) g.setColor(new Color(210, 210, 210));
                
                if (theArray[row][col]==RED) g.setColor(Color.RED);
                
                if (theArray[row][col]==BLACK) g.setColor(Color.BLACK);
                g.fillOval(160+100*col, 100+100*row, 100, 100);
                
                
            }
        }    
        
        check4(g);
    } // paint
            
     public void check4(Graphics g) {
        // see if there are 4 disks in a row: horizontal, vertical or diagonal
        
        // horizontal rows
        for (int row = 0; row < MAXROW; row++) {
            for (int col = 0; col < MAXCOL-3; col++) {
                int curr = theArray[row][col];
                if (curr>0 && curr == theArray[row][col+1] && curr == theArray[row][col+2] && curr == theArray[row][col+3]) {
                    displayWinner(g, theArray[row][col]);
                }
            }
        }
        
        // vertical columns
        for (int col = 0; col < MAXCOL; col++) {
            for (int row = 0; row < MAXROW-3; row++) {
                int curr = theArray[row][col];
                if (curr > 0 && curr == theArray[row+1][col] && curr == theArray[row+2][col] && curr == theArray[row+3][col]){
                    displayWinner(g, theArray[row][col]);
                }
            }
        }
        
        // diagonal lower left to upper right
        for (int row = 0; row < MAXROW-3; row++) {
            for (int col = 0; col < MAXCOL-3; col++) {
                int curr = theArray[row][col];
                if (curr > 0 && curr == theArray[row+1][col+1] && curr == theArray[row+2][col+2] && curr == theArray[row+3][col+3]){
                    displayWinner(g, theArray[row][col]);
                }
            }
        }
        
        // diagonal upper left to lower right
        for (int row = MAXROW-1; row >= 3; row--) {
            for (int col = 0; col < MAXCOL-3; col++) {
                int curr = theArray[row][col];
                
                if (curr>0 && curr == theArray[row-1][col+1] && curr == theArray[row-2][col+2] && curr == theArray[row-3][col+3]){
                    displayWinner(g, theArray[row][col]);
                }
            }
        } 
    }// end check4
  
    
    public void displayWinner(Graphics g, int n) {
        g.setColor(new Color(128, 0, 255));
        g.setFont(new Font("Courier", Font.BOLD, 100));
        
        if (n != RED){
            g.drawString("Black wins!", 270, 400);
        }
        else{
            g.drawString("Red wins!", 270, 400);
        }
        
        end = true;
    }
    
    
    public void putDisk(int n) {
        // put a disk on top of column n
        
        
        // if game is won, do nothing
        if (end){
            return;
        }
        
        gameStart = true;
        int row;
        n--;
        
        for (row = 0; row < MAXROW; row++){
            if (theArray[row][n] > 0){
                break;
            }
        }
        
        if (row > 0) {
            theArray[--row][n] = activeColour;
            
            if (activeColour == RED){
                activeColour = BLACK;
            }
            else{
                activeColour = RED;
            }
            repaint();
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn1)
            putDisk(1);
        else if (e.getSource() == btn2)
            putDisk(2);
        else if (e.getSource() == btn3)
            putDisk(3);
        else if (e.getSource() == btn4)
            putDisk(4);
        else if (e.getSource() == btn5)
            putDisk(5);  
        else if (e.getSource() == btn6)
            putDisk(6);
        else if (e.getSource() == btn7)
            putDisk(7);
        else if (e.getSource() == newMI) {
            end=false;
            initialize();
            repaint();
            activeColour = RED;
        } 
        else if (e.getSource() == exitMI) {
            System.exit(0);
        } 
        else if (e.getSource() == redMI) {
            // don't change colour to play in middle of game
            if (!gameStart){ 
              activeColour = RED;
            }
        }
        else if (e.getSource() == blackMI) {
            if (!gameStart){ 
             activeColour = BLACK;
            }
        }
    } // end ActionPerformed

} // class