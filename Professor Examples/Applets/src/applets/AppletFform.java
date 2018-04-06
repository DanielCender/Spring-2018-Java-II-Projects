/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applets;

/**
 *
 * @author Gary
 */
public class AppletFform extends java.applet.Applet {

    /**
     * Initializes the applet AppletFform
     */
    public void init() {
        setSize(640,480);
        try {
            java.awt.EventQueue.invokeAndWait(new Runnable() {
                public void run() {
                    initComponents();
                }
            });
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * This method is called from within the init() method to initialize the
     * form. WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblFirstName = new javax.swing.JLabel();
        txtFirstName = new javax.swing.JTextField();
        lblLastName = new javax.swing.JLabel();
        txtLastName = new javax.swing.JTextField();
        lblFullName = new javax.swing.JLabel();
        txtFullName = new javax.swing.JTextField();
        doIt = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblFirstName.setText("First Name: ");
        add(lblFirstName, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        txtFirstName.setColumns(20);
        add(txtFirstName, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, -1, -1));

        lblLastName.setText("Last Name: ");
        add(lblLastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        txtLastName.setColumns(20);
        txtLastName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLastNameActionPerformed(evt);
            }
        });
        add(txtLastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, -1, -1));

        lblFullName.setText("Full Name:");
        add(lblFullName, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        txtFullName.setEditable(false);
        txtFullName.setColumns(20);
        txtFullName.setToolTipText("");
        add(txtFullName, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, -1, -1));

        doIt.setText("Do it");
        doIt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doItActionPerformed(evt);
            }
        });
        add(doIt, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 180, -1, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void txtLastNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLastNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLastNameActionPerformed

    private void doItActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doItActionPerformed
        // TODO add your handling code here:
        txtFullName.setText(txtFirstName.getText() + " " + txtLastName.getText());
    }//GEN-LAST:event_doItActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton doIt;
    private javax.swing.JLabel lblFirstName;
    private javax.swing.JLabel lblFullName;
    private javax.swing.JLabel lblLastName;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtFullName;
    private javax.swing.JTextField txtLastName;
    // End of variables declaration//GEN-END:variables
}