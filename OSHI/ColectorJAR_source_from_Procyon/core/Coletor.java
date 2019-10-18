// 
// Decompiled by Procyon v0.5.36
// 

package core;

import java.awt.EventQueue;
import javax.swing.UnsupportedLookAndFeelException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle;
import java.awt.Component;
import java.awt.LayoutManager;
import java.awt.Container;
import javax.swing.GroupLayout;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import Database.Query;
import javax.swing.JFrame;

public class Coletor extends JFrame
{
    Query query;
    String username;
    private JButton jButton1;
    private JButton jButton2;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JPanel jPanel1;
    private JPasswordField jPasswordField2;
    private JTextField jTextField1;
    
    public Coletor() {
        this.query = new Query();
        this.initComponents();
    }
    
    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.jLabel1 = new JLabel();
        this.jTextField1 = new JTextField();
        this.jPasswordField2 = new JPasswordField();
        this.jLabel2 = new JLabel();
        this.jButton1 = new JButton();
        this.jButton2 = new JButton();
        this.setDefaultCloseOperation(3);
        this.setResizable(false);
        this.jLabel1.setFont(new Font("Arial", 1, 12));
        this.jLabel1.setText("Usu\u00e1rio");
        this.jTextField1.setBorder(BorderFactory.createEtchedBorder());
        this.jTextField1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                Coletor.this.jTextField1ActionPerformed(evt);
            }
        });
        this.jPasswordField2.setBorder(BorderFactory.createEtchedBorder());
        this.jLabel2.setFont(new Font("Arial", 1, 12));
        this.jLabel2.setText("Senha");
        this.jButton1.setFont(new Font("Arial", 1, 12));
        this.jButton1.setText("Entrar");
        this.jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                try {
                    Coletor.this.jButton1ActionPerformed(evt);
                }
                catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
        this.jButton2.setFont(new Font("Arial", 1, 12));
        this.jButton2.setText("Cancelar");
        this.jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                Coletor.this.jButton2ActionPerformed(evt);
            }
        });
        final GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(33, 33, 33).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jButton1).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jButton2)).addComponent(this.jTextField1, -2, 119, -2).addComponent(this.jLabel2).addComponent(this.jPasswordField2, -2, 119, -2).addComponent(this.jLabel1, -2, 54, -2)).addContainerGap(127, 32767)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(32, 32, 32).addComponent(this.jLabel1).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jTextField1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jLabel2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPasswordField2, -2, -1, -2).addGap(18, 18, 18).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jButton1).addComponent(this.jButton2)).addContainerGap(71, 32767)));
        final GroupLayout layout = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -2, -1, -2));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.jPanel1, -2, -1, -2).addGap(0, 0, 32767)));
        this.pack();
    }
    
    private void jButton1ActionPerformed(final ActionEvent evt) throws SQLException {
        this.username = this.jTextField1.getText();
        final String password = this.jPasswordField2.getText();
        System.out.println(this.username + " " + password);
        try {
            if (this.username.equals(this.query.getUser(this.username)) && password.equals(this.query.getPassword(this.username))) {
                final Coletor2 coletor2 = new Coletor2();
                coletor2.setVisible(true);
                this.dispose();
            }
            else {
                final Coletor coletor3 = new Coletor();
                JOptionPane.showMessageDialog(coletor3, "Senha ou Usu\u00e1rio inv\u00e1lido");
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    private void jButton2ActionPerformed(final ActionEvent evt) {
        System.exit(0);
    }
    
    private void jTextField1ActionPerformed(final ActionEvent evt) {
    }
    
    public static void main(final String[] args) {
        try {
            for (final UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }
        catch (ClassNotFoundException ex) {
            Logger.getLogger(Coletor.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (InstantiationException ex2) {
            Logger.getLogger(Coletor.class.getName()).log(Level.SEVERE, null, ex2);
        }
        catch (IllegalAccessException ex3) {
            Logger.getLogger(Coletor.class.getName()).log(Level.SEVERE, null, ex3);
        }
        catch (UnsupportedLookAndFeelException ex4) {
            Logger.getLogger(Coletor.class.getName()).log(Level.SEVERE, null, ex4);
        }
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Coletor().setVisible(true);
            }
        });
    }
}
