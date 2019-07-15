/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Front;

import Back.Works;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;



/**
 *
 * @author qq
 */
public class Main extends javax.swing.JFrame{
    Works works = null;
    public Main() {
        initComponents();

        setDimension();
        setResizable(false);
        jPanel1.setFocusable(true);
        user_pass.setEchoChar((char)0);
        user_pass.setText("Şifre");
        works = new Works();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        user_name = new javax.swing.JTextField();
        user_pass = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        message_box = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(0, 123, 255));

        jPanel1.setBackground(new java.awt.Color(248, 249, 250));

        user_name.setBackground(new java.awt.Color(248, 249, 250));
        user_name.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        user_name.setForeground(new java.awt.Color(204, 204, 204));
        user_name.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        user_name.setText("Kullanıcı Adı");
        user_name.setToolTipText("");
        user_name.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        user_name.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        user_name.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                user_nameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                user_nameFocusLost(evt);
            }
        });

        user_pass.setBackground(new java.awt.Color(248, 249, 250));
        user_pass.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        user_pass.setForeground(new java.awt.Color(204, 204, 204));
        user_pass.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        user_pass.setToolTipText("");
        user_pass.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        user_pass.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                user_passFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                user_passFocusLost(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(40, 167, 69));
        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Giriş");
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(251, 252, 252)));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        message_box.setBackground(new java.awt.Color(248, 249, 250));
        message_box.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        message_box.setForeground(new java.awt.Color(201, 36, 52));
        message_box.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(user_name, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(user_pass, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 17, Short.MAX_VALUE))
            .addComponent(message_box, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addComponent(user_name, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(user_pass, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(message_box, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel1.setIcon(new javax.swing.ImageIcon("X:\\Javas\\Library\\img\\library1.png")); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 489, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void user_passFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_user_passFocusLost
        String ps = new String(user_pass.getPassword());
        if(ps.equals("")){
            user_pass.setText("Şifre");
            user_pass.setEchoChar((char)0);
        }
    }//GEN-LAST:event_user_passFocusLost

    private void user_passFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_user_passFocusGained
        String ps = new String(user_pass.getPassword());
        if(ps.equals("Şifre")){
            user_pass.setText("");
            user_pass.setEchoChar('*');
        }
    }//GEN-LAST:event_user_passFocusGained

    private void user_nameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_user_nameFocusLost
        if(user_name.getText().equals("")){
            user_name.setText("Kullanıcı Adı");
        }
    }//GEN-LAST:event_user_nameFocusLost

    private void user_nameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_user_nameFocusGained
        if(user_name.getText().equals("Kullanıcı Adı")){
            user_name.setText("");
        }
    }//GEN-LAST:event_user_nameFocusGained

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String username = user_name.getText();
        String password = new String(user_pass.getPassword());
        if(username.equals("Kullanıcı Adı") || username.equals("")){
            message_box.setText("");
            message_box.setText("Kullanıcı Adını Giriniz");
        }
        else if(password.equals("") || password.equals("Şifre")){
            message_box.setText("");
            message_box.setText("Şifreyi Girinz.");
        }
        else{
            if(works.login(username, password)){

                    setVisible(false);
                    Window window = new Window(this,true);
                    window.setVisible(true);
                    System.exit(0);
              
            }
            else{
                message_box.setText("");
                message_box.setText("Giriş Bilgileri Hatalı.");
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    public final void setDimension(){
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((screen.width-getWidth())/2, (screen.height-getHeight())/2);
    }
    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel message_box;
    private javax.swing.JTextField user_name;
    private javax.swing.JPasswordField user_pass;
    // End of variables declaration//GEN-END:variables

   
    

}
