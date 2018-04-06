//  Class: MousingAround.java
//  Author: Gary R. Smith
//  Date Written: 3/2/2016

/*  Abstract: Demonstrated using mouse listeners.
*/

package applets;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class MousingAround extends Applet 
        implements MouseListener, MouseMotionListener {
    //  Declarations
    String message = "";
    int mouseX = 0;
    int mouseY = 0;

    //  Called after the applet is loaded into the browser.     
    public void init() {
        // Initialization Statements
        setSize(640,480);
        addMouseListener(this);
        addMouseMotionListener(this);
    }
    
    //  Mouse clicked.
    public void mouseClicked(MouseEvent e)
    {
        mouseX = 0;
        mouseY = 10;
        message = "Mouse clicked.";
        repaint();
    }
    
    //  Mouse entered.
    public void mouseEntered(MouseEvent e)
    {
        mouseX = 0;
        mouseY = 10;
        message = "Mouse entered.";
        repaint();
    }

        //  Mouse exited.
    public void mouseExited(MouseEvent e)
    {
        mouseX = 0;
        mouseY = 10;
        message = "Mouse exited.";
        repaint();
    }

    //  Mouse button pressed.
    public void mousePressed(MouseEvent e)
    {
        mouseX = e.getX();
        mouseY = e.getY();
        message = "Mouse button pressed down.";
        repaint();
    }

    //  Mouse button pressed.
    public void mouseReleased(MouseEvent e)
    {
        mouseX = e.getX();
        mouseY = e.getY();
        message = "Mouse button released.";
        repaint();
    }
    
    //  Mouse button pressed.
    public void mouseDragged(MouseEvent e)
    {
        mouseX = e.getX();
        mouseY = e.getY();
        message = "Dragging mouse.";
        showStatus("Dragging mouse at " + mouseX + ", " + mouseY);
        repaint();
    }

    //  Mouse button pressed.
    public void mouseMoved(MouseEvent e)
    {
        mouseX = e.getX();
        mouseY = e.getY();
        showStatus("Moving mouse at " + mouseX + ", " + mouseY);
        repaint();
    }
    
    //  Called when AWT-based applet is windows must be restored.
    public void paint(Graphics g) {
        //  Redisplays the windows contents
        g.drawString(message, mouseX, mouseY);
    }
}
