
//import GUI.*;
//import GUI.EditContactGUI;
//import contactlist.ContactList;
//import contactlist.connector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nadat
 */
public class EditPhoneRowGUI extends javax.swing.JFrame {
    
    String phoneId, phoneType, areaCode, number;
    int rowId;
    /**
     * Creates new form EditPhoneRowGUI
     */
    public EditPhoneRowGUI() {
        initComponents();
    }
    
    public EditPhoneRowGUI(int rowId, String phoneId, String phoneType, String areaCode, String number) {
        initComponents();
        this.rowId = rowId;
        this.phoneId = phoneId;
        this.phoneType = phoneType;
        this.areaCode = areaCode;
        this.number = number;
        display();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        phoneTypeTf = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        areaCodeTf = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        numberTf = new javax.swing.JTextField();
        cancelSavePhoneBtn = new javax.swing.JButton();
        savePhoneBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Edit Phone");

        jLabel1.setText("Phone Type");

        jLabel2.setText("Area Code");

        jLabel3.setText("Number");

        cancelSavePhoneBtn.setText("Cancel");
        cancelSavePhoneBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelSavePhoneBtnActionPerformed(evt);
            }
        });

        savePhoneBtn.setText("Save");
        savePhoneBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savePhoneBtnActionPerformed(evt);
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
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(phoneTypeTf, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(areaCodeTf, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(numberTf, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(186, 186, 186)
                        .addComponent(cancelSavePhoneBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(114, 114, 114)
                        .addComponent(savePhoneBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(111, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(phoneTypeTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(areaCodeTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(numberTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelSavePhoneBtn)
                    .addComponent(savePhoneBtn))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelSavePhoneBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelSavePhoneBtnActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_cancelSavePhoneBtnActionPerformed

    private void savePhoneBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savePhoneBtnActionPerformed
        // TODO add your handling code here:
        try{
            if(!ContactList.isNumeric(areaCodeTf.getText())){
                JOptionPane.showMessageDialog(null, "Areacode must be numeric");
            }
            else if(areaCodeTf.getText().length() != 3){
                JOptionPane.showMessageDialog(null, "Areacode must be 3-digit");
            }
            else if(!ContactList.isNumeric(numberTf.getText())){
                JOptionPane.showMessageDialog(null, "Number must be numeric");
            }
            else if(numberTf.getText().length() != 7){
                JOptionPane.showMessageDialog(null, "Number must be 7-digit");
            }
            else{
                String newPhoneType = phoneTypeTf.getText();
                String newAreaCode = areaCodeTf.getText();
                String newNumber = numberTf.getText();
                
                //Insert Phone
                Connection con = connector.get();
                String sqlPhone = "UPDATE phone SET phone_type = ?, area_code = ?, number = ? WHERE Phone_id = ?";
                PreparedStatement psPhone = con.prepareStatement(sqlPhone);
                
                psPhone.setString(1, newPhoneType);//PhoneTYpe
                psPhone.setString(2, newAreaCode);//AreaCode
                psPhone.setString(3, newNumber);//Number
                psPhone.setInt(4, Integer.parseInt(this.phoneId));
                psPhone.execute();
                
                EditContactGUI.editPhoneRow(this.rowId,this.phoneId, newPhoneType,  newAreaCode, newNumber);
                JOptionPane.showMessageDialog(null, "Phone updated successfully");
                
                dispose();  
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
       
    }//GEN-LAST:event_savePhoneBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EditPhoneRowGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditPhoneRowGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditPhoneRowGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditPhoneRowGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditPhoneRowGUI().setVisible(true);
            }
        });
    }
    
    public void display(){
        
        phoneTypeTf.setText(this.phoneType);
        areaCodeTf.setText(this.areaCode);
        numberTf.setText(this.number);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField areaCodeTf;
    private javax.swing.JButton cancelSavePhoneBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField numberTf;
    private javax.swing.JTextField phoneTypeTf;
    private javax.swing.JButton savePhoneBtn;
    // End of variables declaration//GEN-END:variables
}
