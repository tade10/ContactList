
//import GUI.*;
//import GUI.EditContactGUI;
//import contactlist.ContactList;
//import contactlist.connector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nadat
 */
public class ViewContactDetailsGUI extends javax.swing.JFrame {
    
    /**
     * Creates new form ViewContactDetailsGUI
     */
    int contactId;
    
    public ViewContactDetailsGUI() {
        initComponents();
    }
     public ViewContactDetailsGUI(int msg) {
        initComponents();
        this.contactId = msg;
        displayContact();
        
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
        fnameTf = new javax.swing.JTextField();
        mnameTf = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        lnameTf = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        dateTable = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        addressTable = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        phoneTable = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        contactIdTf = new javax.swing.JTextField();
        editContactBtn = new javax.swing.JButton();
        deleteContactBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("VIEW CONTACT DETAILS");
        setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N

        jLabel1.setText("First Name");

        fnameTf.setEditable(false);

        mnameTf.setEditable(false);
        mnameTf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnameTfActionPerformed(evt);
            }
        });

        jLabel2.setText("Middle Name");

        lnameTf.setEditable(false);

        jLabel3.setText("Last Name");

        dateTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Date Type", "Date"
            }
        ));
        jScrollPane1.setViewportView(dateTable);

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel4.setText("DATES");

        jLabel5.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel5.setText("ADDRESSES");

        addressTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Address Type", "Address", "City", "State", "Zipcode"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(addressTable);

        jLabel6.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel6.setText("PHONES");

        phoneTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Phone Type", "Area Code", "Number"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(phoneTable);

        jLabel7.setText("Contact Id");

        contactIdTf.setEditable(false);

        editContactBtn.setText("Edit Contact");
        editContactBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editContactBtnActionPerformed(evt);
            }
        });

        deleteContactBtn.setText("Delete Contact");
        deleteContactBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteContactBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(deleteContactBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                    .addComponent(editContactBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(contactIdTf, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 509, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane2)
                                    .addComponent(jScrollPane3)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addComponent(jLabel1)
                                .addGap(10, 10, 10)
                                .addComponent(fnameTf, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(mnameTf, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(lnameTf, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(21, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(contactIdTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(fnameTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(lnameTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mnameTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(editContactBtn)
                        .addGap(18, 18, 18)
                        .addComponent(deleteContactBtn)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jLabel6)
                        .addGap(7, 7, 7)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnameTfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnameTfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mnameTfActionPerformed

    private void deleteContactBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteContactBtnActionPerformed
        // TODO add your handling code here:
        ContactList list = new ContactList();
        list.deleteContact(this.contactId);
        ContactListGUI.selectedRow=-1;
        ContactListGUI.displayContacts();
        dispose();
    }//GEN-LAST:event_deleteContactBtnActionPerformed

    private void editContactBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editContactBtnActionPerformed
        // TODO add your handling code here:
        EditContactGUI editContact = new EditContactGUI(this.contactId);
        editContact.setVisible(true);
        editContact.pack();
        editContact.setLocationRelativeTo(null);
        editContact.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        dispose();
    }//GEN-LAST:event_editContactBtnActionPerformed

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
            java.util.logging.Logger.getLogger(ViewContactDetailsGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewContactDetailsGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewContactDetailsGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewContactDetailsGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewContactDetailsGUI().setVisible(true);
            }
        });
    }
    
    private void displayContact() {                                         
        // TODO add your handling code here:
            
        try
        {
            Connection con = connector.get();
            
            //Display contact table details
            String sqlContact = "select * from contact where Contact_Id ='"+this.contactId+"'";
            PreparedStatement psContact = con.prepareStatement(sqlContact);
            ResultSet rsContact = psContact.executeQuery();
            
            
            while(rsContact.next())
            {   
                fnameTf.setText(rsContact.getString("Fname"));
                mnameTf.setText(rsContact.getString("Mname"));
                lnameTf.setText(rsContact.getString("Lname"));
                contactIdTf.setText(Integer.toString(rsContact.getInt("contact_id")));
            }   
            
            
            //Display date table
            DefaultTableModel tm = (DefaultTableModel)dateTable.getModel();
            tm.setRowCount(0);
            
            String sqlDate = "select * from date where Contact_id = '"+this.contactId+"'";
            PreparedStatement psDate = con.prepareStatement(sqlDate);
            ResultSet rsDate = psDate.executeQuery();
                
            while(rsDate.next())
            {
                Object[] row = new Object[2];
                row[0] = rsDate.getString("Date_type");
                row[1] = rsDate.getString("Date");
                tm.addRow(row);
            }
            
            //Display address table
            tm = (DefaultTableModel)addressTable.getModel();
            tm.setRowCount(0);
            
            String sqlAddress = "select * from address where Contact_id = '"+this.contactId+"'";
            PreparedStatement psAddress = con.prepareStatement(sqlAddress);
            ResultSet rsAddress = psAddress.executeQuery();
                
            while(rsAddress.next())
            {
                Object[] row = new Object[6];
                row[0] = rsAddress.getString("Address_type");
                row[1] = rsAddress.getString("Address");
                row[2] = rsAddress.getString("City");
                row[3] = rsAddress.getString("State");
                row[4] = rsAddress.getString("Zip");
                tm.addRow(row);
            }
            
            
            
            //Display phone table
            tm = (DefaultTableModel)phoneTable.getModel();
            tm.setRowCount(0);
            
            String sqlPhone = "select * from phone where Contact_id = '"+this.contactId+"'";
            PreparedStatement psPhone = con.prepareStatement(sqlPhone);
            ResultSet rsPhone = psPhone.executeQuery();
                
            while(rsPhone.next())
            {
                Object[] row = new Object[3];
                row[0] = rsPhone.getString("Phone_type");
                row[1] = rsPhone.getString("Area_code");
                row[2] = rsPhone.getString("Number");
                tm.addRow(row);
            }
            
            
        }
        catch(Exception e)
        {
           e.printStackTrace();
            JOptionPane.showMessageDialog(this, e);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable addressTable;
    private javax.swing.JTextField contactIdTf;
    private javax.swing.JTable dateTable;
    private javax.swing.JButton deleteContactBtn;
    private javax.swing.JButton editContactBtn;
    private javax.swing.JTextField fnameTf;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField lnameTf;
    private javax.swing.JTextField mnameTf;
    private javax.swing.JTable phoneTable;
    // End of variables declaration//GEN-END:variables
}