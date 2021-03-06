//  Class: GrapicsDemo.java
//  Author: Gary R. Smith
//  Date Written: 4/4/2016

/*  Abstract: This program demonstrates methods of the Graphics class.
*/
package DemoGraphics;

import java.awt.image.BufferedImage;
import java.awt.*;
import static java.awt.Color.BLACK;
import static java.awt.Color.BLUE;
import static java.awt.Color.ORANGE;
import static java.awt.Color.YELLOW;
import static java.awt.Color.magenta;
import static java.awt.EventQueue.invokeLater;
import static java.awt.Font.PLAIN;
import java.io.*;
import static java.util.logging.Level.SEVERE;
import static java.util.logging.Logger.getLogger;
import static javax.imageio.ImageIO.read;
import static javax.swing.UIManager.getInstalledLookAndFeels;
import static javax.swing.UIManager.setLookAndFeel;


public class GraphicsDemo extends javax.swing.JFrame
{
    //  Declarations
    private int change = 0;
    BufferedImage img;

    /**
     * Creates new form GraphicsDemo
     */
    public GraphicsDemo()
    {
        initComponents();
       
        try {
            img = read(new File("image\\dont_give_up.jpg"));
        }
        catch (IOException err)
        {
            System.out.println("Can't find picture.");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        Change = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Change.setText("Change");
        Change.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                ChangeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(293, Short.MAX_VALUE)
                .addComponent(Change)
                .addGap(278, 278, 278))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(430, Short.MAX_VALUE)
                .addComponent(Change, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ChangeActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_ChangeActionPerformed
    {//GEN-HEADEREND:event_ChangeActionPerformed
        // TODO add your handling code here:
        change++;
        repaint();
    }//GEN-LAST:event_ChangeActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex)
        {
            getLogger(GraphicsDemo.class.getName()).log(SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        invokeLater(() ->
        {
            new GraphicsDemo().setVisible(true);
        });
    }

    public void paint(Graphics g) 
    {
        //  Remove all previous components other thatn those that were there intially.
        super.paintComponents(g);
        switch (change)
        {
            case 1: 
                //  Draws a string
                Font f = new Font("Comic Sans MS", PLAIN, 36);
                g.setFont(f);
                g.setColor(magenta);
                g.drawString("Hello World!", 240, 150);
                break;
            case 2:
                //  Draws a filled rectangle
                g.setColor(BLUE);
                g.fillRect(240, 150, 200, 80);
                break;
            case 3:
                //  Draws an oval then a filled arc
                //  Note: A circle is a oval thet has the same length and width.
                g.drawOval(250, 200, 150, 150);
                g.fillArc(250, 200, 150, 150, 180, 60);
                break;
            case 4:
                //  Draws an arc
                g.drawArc(250, 230, 100, 100, 90, 180);
                g.fillArc(260, 230, 100, 100, 270, 180);
                break;
            case 5:
                //  Draws a filled oval
                g.setColor(ORANGE);
                g.fillOval(270, 150, 100, 150);
                break;
            case 6:
                //  Draw a smily face
                g.setColor(BLACK);
                g.drawOval(170, 100, 300, 300);
                g.setColor(YELLOW);
                g.fillOval(171, 101, 298, 298);
                g.setColor(BLACK);
                g.fillOval(250, 200, 30, 30);
                g.fillOval(350, 200, 30, 30);
                g.fillArc(250, 300, 150, 60, 180, 180);
                g.drawLine(240, 180, 280, 175);
                g.drawLine(345, 175, 390, 180);
                break;
            case 7:
                //  Draw an image
                g.drawImage(img, 120, 60, this);
                break;
            case 8:
                //  Draw house
                super.paintComponents(g);
                g.setColor(Color.CYAN);
                g.fillRect(150, 330, 200, 100);
                g.setColor(Color.BLACK);
                g.drawLine(150, 330, 250, 230);
                g.drawLine(250, 230, 350, 330);
                g.drawRect(200, 350, 25, 25);
                for (int x = 0; x < 15; x++)
                {
                g.copyArea(200, 350, 26, 26, 50+(x+10), 0);
                try
                {
                Thread.sleep(250);
                }
                catch (InterruptedException e){}}
                
                break;
            case 9:
                change = 0;
                break;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Change;
    // End of variables declaration//GEN-END:variables
}
