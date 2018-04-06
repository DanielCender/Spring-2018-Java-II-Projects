//  Class: GetParams.java
//  Author: Gary R. Smith
//  Date Written:

/*  Abstract: 
*/

package applets;

import java.applet.Applet;
import java.awt.*;

public class GetParams extends Applet {
    //  Parameters declarations
    String author;
    String programName;
    int version;

    //  Called after init() or whenever apples is restarted.
    public void start() {
        //  Get the parameters
        author = getParameter("author");
        if(author==null) author = "No author";
        
        programName = getParameter("name");
        if(programName==null) programName = "No program name.";
        
        String strVer = getParameter("version");
        try {
            if (strVer != null) version = Integer.parseInt(strVer);
            else version = 0;
        }
        catch (Exception err) { version = -1; }       
    }
    
    //  Called when AWT-based applet is windows must be restored.
    public void paint(Graphics g) {
        //  Redisplays the windows contents
        g.drawString(author, 10, 20);
        g.drawString(programName, 10, 40);
        g.drawString("Version: " + version, 10, 60);
    }
}
