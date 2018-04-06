//  Class: Banner.java
//  Author: Gary R. Smith
//  Date Written: 3/2/2016

/*  Abstract: 
*/

package applets;

import java.awt.*;
import java.applet.Applet;


public class Banner extends Applet implements Runnable {
    //  Instance variables
    String message = "Eat at Joes! ";
    Thread th;
    boolean stop;
    int xPos;
    int yPos;
    
    //  Initialization
    public void init() {
        // Declartions
        th = null;
        xPos = 20;
        yPos = 80;
        
        //  Set the size of the window
        setSize(640,480);
    }
    
    //  Start
    public void start() {
        //  Create thread and start it.
        th = new Thread(this);
        stop = false;
        th.start();
    }

    //  Run method
    public void run() {
        //  Redisplay the banner
        while (true) {
            try {
                repaint();
                Thread.sleep(250);
                if (stop)
                    break;
            }
            catch (InterruptedException err)
            {}
        }
    }
    
    // Stop the banner.
    public void stop() {
        stop = true;
        th = null;
    }
    
    //  Display the banner
    public void paint(Graphics g) {
        //  Shifts the data 1 character to the left.
        char ch;
        ch = message.charAt(0);
        message = message.substring(1, message.length());
        message += ch;
        
        //  Sets font
        Font f = new Font("Comic Sans MS", Font.PLAIN, 20);
        g.setFont(f);
        g.drawString(message, 250, 30);  //  50, 30 is the x, y coordinates in pixels of the drawString object.
        g.drawString("They went > way!", xPos+=5, yPos);  //  Scrools banner
        if(xPos==450) {
            xPos = 20;
        }
    }
}
