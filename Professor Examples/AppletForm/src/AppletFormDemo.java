//  Class AppletFormDemo.java
//  Written by: Gary R. Smith
//  Date Written: 3/9/2016

/*  This program allows the user to enter values and creates a graph. 
*/

import java.awt.*;
import javax.swing.*;

public class AppletFormDemo extends javax.swing.JApplet {

    //  Instance variables.
    MyGraph gr;
    int b1;
    int b2;
    int b3;
    
    //  Initializaions
    public void init() {
        try {
            java.awt.EventQueue.invokeAndWait(new Runnable() {
                public void run() {
                    initComponents();
                }
            });
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        setSize(640, 480);
        setVisible(true);
    }

    //  Paint method.
    public void paint(Graphics g) {
        System.out.println("Paint");
        gr = new MyGraph(b1, b2, b3);
        gr.setBounds(new Rectangle(500, 10, 150, 150));
        this.add(gr);
        this.paintComponents(g);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Submit = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        value3slider = new javax.swing.JSlider();
        value2slider = new javax.swing.JSlider();
        value1slider = new javax.swing.JSlider();

        setPreferredSize(new java.awt.Dimension(640, 480));

        Submit.setText("Submit");
        Submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubmitActionPerformed(evt);
            }
        });

        jTextField1.setColumns(10);

        jTextField2.setColumns(10);

        jTextField3.setColumns(10);

        jLabel1.setText("Value 1");

        jLabel2.setText("Value 2");

        jLabel3.setText("Value 3");

        value3slider.setBackground(new java.awt.Color(255, 255, 0));
        value3slider.setValue(0);
        value3slider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                value3sliderStateChanged(evt);
            }
        });

        value2slider.setBackground(new java.awt.Color(0, 51, 255));
        value2slider.setValue(0);
        value2slider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                value2sliderStateChanged(evt);
            }
        });

        value1slider.setBackground(new java.awt.Color(255, 51, 51));
        value1slider.setValue(0);
        value1slider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                value1sliderStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(value3slider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(value2slider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(value1slider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(291, 291, 291)
                        .addComponent(Submit)))
                .addContainerGap(306, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(7, 7, 7)
                .addComponent(value1slider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(value2slider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(value3slider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(Submit)
                .addContainerGap(234, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    //  Submit button is pressed.
    private void SubmitActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_SubmitActionPerformed
    {//GEN-HEADEREND:event_SubmitActionPerformed
        // Handles bad data.
        try {
            b1 = Integer.parseInt(jTextField1.getText());
            b2 = Integer.parseInt(jTextField2.getText());
            b3 = Integer.parseInt(jTextField3.getText());
        } catch (Exception e) {
            b1 = 0;
            b2 = 0;
            b3 = 0;
        }
        this.remove(gr);
        this.repaint();
    }//GEN-LAST:event_SubmitActionPerformed

    private void value3sliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_value3sliderStateChanged
        // TODO add your handling code here:
        b1 = value1slider.getValue();
        b2 = value2slider.getValue();
        b3 = value3slider.getValue();
        this.remove(gr);
        this.repaint();
    }//GEN-LAST:event_value3sliderStateChanged

    private void value2sliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_value2sliderStateChanged
        // TODO add your handling code here:
                b2 = value2slider.getValue();
        this.remove(gr);
        this.repaint();
    }//GEN-LAST:event_value2sliderStateChanged

    private void value1sliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_value1sliderStateChanged
        // TODO add your handling code here:
        b1 = value1slider.getValue();
        this.remove(gr);
        this.repaint();
    }//GEN-LAST:event_value1sliderStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Submit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JSlider value1slider;
    private javax.swing.JSlider value2slider;
    private javax.swing.JSlider value3slider;
    // End of variables declaration//GEN-END:variables

    //  Inner class for the graph.
    static class MyGraph extends JLayeredPane {
        
        private int x = 10;
        private int y = 10;
        private int w = 25;
        private int size = 100;
        int bar1;
        int bar2;
        int bar3;
        
        //  Constructor
        public MyGraph(int bar1, int bar2, int bar3) {
            this.bar1 = bar1;
            this.bar2 = bar2;
            this.bar3 = bar3;
        }
        
        //  Paints the graph.
        public void paintComponent(Graphics g) {
            g.setColor(Color.RED);
            g.fillRect(x, size - bar1, w, bar1);
            g.setColor(Color.BLUE);
            g.fillRect(x + w, size - bar2, w, bar2);
            g.setColor(Color.YELLOW);
            g.fillRect(x + (2*w), size - bar3, w, bar3);
            g.setColor(Color.BLACK);
            g.drawString(String.valueOf(bar1), x, size + 20);
            g.drawString(String.valueOf(bar2), x + w, size + 20);
            g.drawString(String.valueOf(bar3), x + (2*w), size + 20);
        }
    }
}
