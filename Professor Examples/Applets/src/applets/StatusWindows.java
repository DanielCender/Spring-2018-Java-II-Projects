//  Class: StatusWindows.java
//  Author: Gary R. Smith
//  Date Written: 3/2/2016

/*  Abstract: Demonstrated writing to the status window.
*/

package applets;

import java.applet.Applet;
import java.awt.*;

public class StatusWindows extends Applet {

    //  Called when AWT-based applet is windows must be restored.
    public void paint(Graphics g) {
        //  Redisplays the windows contents
        //  Sets font
        Font f = new Font("Comic Sans MS", Font.PLAIN, 20);
        g.setFont(f);
        g.drawString("Java is Fun!", 50, 30);
        showStatus("Painting the applet");
    }
}
