import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JFrame;

/**
 * This class is the constructor that connects all the other classes
 * 
 * @Satinderjit S. Dhaliwal
 * @2016 Project
 */
public class Connect4
{
    /**
    *   Program:    Connect 4
    *   Author: Satinderjit
    *   Period: 1
    */  

    public static void main(String[] args) {
        Connect4JFrame frame = new Connect4JFrame();
        //Initialize arr = new Initialize();
        //createBoard body = new createBoard(g);
        //check4Win winner = new check4Win(g);
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }      

}