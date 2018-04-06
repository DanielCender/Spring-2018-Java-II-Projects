//  Class: SimpleApplet.java
//  Author: Gary R. Smith
//  Date Written: 3/2/2016

/*  Abstract: Creates a simple Applet.  */
package applets;

import java.awt.*;
import java.applet.Applet;

public class SimpleApplet extends Applet {

    public void paint(Graphics g) {
        //  Display a message in the applet window
        //  20,20 is the x, y coordinates in pixels of the drawString object.
        g.drawString("Java applets are easy!", 20, 20);
    }
}
