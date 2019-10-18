// 
// Decompiled by Procyon v0.5.36
// 

package core;

import java.awt.EventQueue;
import javax.swing.UnsupportedLookAndFeelException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.LayoutStyle;
import java.awt.LayoutManager;
import java.awt.Container;
import javax.swing.GroupLayout;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.Border;
import javax.swing.border.SoftBevelBorder;
import java.awt.Font;
import java.awt.Cursor;
import javax.swing.BorderFactory;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import oshi.software.os.OperatingSystem;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.SystemInfo;
import coletor.Hardware;
import Database.Query;
import javax.swing.JFrame;

public class Coletor2 extends JFrame
{
    Query query;
    Threads threads;
    Hardware hardware;
    SystemInfo si;
    HardwareAbstractionLayer hal;
    OperatingSystem os;
    public String maquina;
    private JButton jButton1;
    private JButton jButton2;
    private JButton jButton3;
    private JButton jButton4;
    private JButton jButton5;
    private JButton jButton6;
    private JButton jButton7;
    private JButton jButton8;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JPanel jPanel1;
    
    public Coletor2() {
        this.query = new Query();
        this.threads = new Threads();
        this.hardware = new Hardware();
        this.si = new SystemInfo();
        this.hal = this.si.getHardware();
        this.os = this.si.getOperatingSystem();
        this.initComponents();
        this.maquina = JOptionPane.showInputDialog(null, "Qual o nome da sua m\u00e1quina?");
        this.threads.setMaquina(this.maquina);
        this.jButton6.setEnabled(false);
    }
    
    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.jLabel1 = new JLabel();
        this.jLabel2 = new JLabel();
        this.jButton1 = new JButton();
        this.jButton2 = new JButton();
        this.jButton3 = new JButton();
        this.jButton4 = new JButton();
        this.jButton5 = new JButton();
        this.jButton6 = new JButton();
        this.jButton7 = new JButton();
        this.jButton8 = new JButton();
        this.setResizable(false);
        this.setDefaultCloseOperation(3);
        this.jPanel1.setBorder(BorderFactory.createEtchedBorder());
        this.jPanel1.setCursor(new Cursor(0));
        this.jLabel1.setFont(new Font("Ebrima", 1, 12));
        this.jLabel1.setText("Bem vindo ");
        this.jLabel1.setToolTipText("");
        this.jLabel1.setBorder(new SoftBevelBorder(0));
        this.jLabel2.setFont(new Font("Ebrima", 1, 14));
        this.jLabel2.setText("Escolha o que quer que seja monitorado!");
        this.jButton1.setFont(new Font("Arial", 1, 12));
        this.jButton1.setText("Mem\u00f3ria RAM");
        this.jButton1.setBorder(BorderFactory.createEtchedBorder());
        this.jButton1.setBorderPainted(false);
        this.jButton1.setFocusPainted(false);
        this.jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                Coletor2.this.jButton1ActionPerformed(evt);
            }
        });
        this.jButton2.setFont(new Font("Arial", 1, 12));
        this.jButton2.setText("Processador");
        this.jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                Coletor2.this.jButton2ActionPerformed(evt);
            }
        });
        this.jButton3.setFont(new Font("Arial", 1, 12));
        this.jButton3.setText("Disco Rig\u00eddo");
        this.jButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                Coletor2.this.jButton3ActionPerformed(evt);
            }
        });
        this.jButton4.setFont(new Font("Arial", 1, 12));
        this.jButton4.setText("Placa de V\u00eddeo");
        this.jButton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                Coletor2.this.jButton4ActionPerformed(evt);
            }
        });
        this.jButton5.setFont(new Font("Arial", 1, 12));
        this.jButton5.setText("Todos os componentes");
        this.jButton5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                Coletor2.this.jButton5ActionPerformed(evt);
            }
        });
        this.jButton6.setFont(new Font("Arial", 1, 12));
        this.jButton6.setText("Parar");
        this.jButton6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                Coletor2.this.jButton6ActionPerformed(evt);
            }
        });
        this.jButton7.setFont(new Font("Arial", 1, 12));
        this.jButton7.setText("Sair");
        this.jButton7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                Coletor2.this.jButton7ActionPerformed(evt);
            }
        });
        this.jButton8.setFont(new Font("Arial", 1, 12));
        this.jButton8.setText("Componentes");
        this.jButton8.setActionCommand("jButton8");
        this.jButton8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                try {
                    Coletor2.this.jButton8ActionPerformed(evt);
                }
                catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
        final GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jLabel1, -2, 142, -2).addGap(0, 0, 32767)).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addGap(0, 32, 32767).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addComponent(this.jLabel2, -2, 333, -2).addGap(21, 21, 21)).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addComponent(this.jButton7).addContainerGap()))).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jButton5).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.jButton6)).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jButton4, -2, 130, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.jButton8)).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jButton3, -2, 130, -2).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jButton1, -1, -1, 32767).addComponent(this.jButton2, -1, 130, 32767))).addGap(0, 0, 32767))).addContainerGap()))));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jLabel1).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel2, -2, 31, -2).addGap(34, 34, 34).addComponent(this.jButton1, -2, 34, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jButton2, -2, 35, -2).addGap(17, 17, 17).addComponent(this.jButton3, -2, 35, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jButton4, -2, 34, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addComponent(this.jButton8).addGap(3, 3, 3))).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jButton5, -2, 34, -2).addComponent(this.jButton6)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.jButton7).addContainerGap()));
        this.jButton8.getAccessibleContext().setAccessibleName("jButton8");
        final GroupLayout layout = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767));
        this.pack();
    }
    
    private void jButton1ActionPerformed(final ActionEvent evt) {
        this.threads.memoriaRAM.start();
        this.jButton1.setEnabled(false);
        this.jButton6.setEnabled(true);
    }
    
    private void jButton2ActionPerformed(final ActionEvent evt) {
        this.threads.processador.start();
        this.jButton2.setEnabled(false);
        this.jButton6.setEnabled(true);
    }
    
    private void jButton3ActionPerformed(final ActionEvent evt) {
        this.threads.disco.start();
        this.jButton3.setEnabled(false);
        this.jButton6.setEnabled(true);
    }
    
    private void jButton4ActionPerformed(final ActionEvent evt) {
        this.jButton4.setEnabled(false);
        this.jButton6.setEnabled(true);
    }
    
    private void jButton5ActionPerformed(final ActionEvent evt) {
        this.threads.todosOsComponentes.start();
        this.jButton5.setEnabled(false);
        this.jButton6.setEnabled(true);
    }
    
    private void jButton6ActionPerformed(final ActionEvent evt) {
        this.threads.timer.cancel();
        this.jButton1.setEnabled(true);
        this.jButton2.setEnabled(true);
        this.jButton3.setEnabled(true);
        this.jButton4.setEnabled(true);
        this.jButton5.setEnabled(true);
        this.jButton6.setEnabled(false);
    }
    
    private void jButton7ActionPerformed(final ActionEvent evt) {
        this.setVisible(false);
    }
    
    private void jButton8ActionPerformed(final ActionEvent evt) throws SQLException {
        JOptionPane.showMessageDialog(null, "Processador: " + this.hardware.nomeProcessador(this.hal.getProcessor()) + "\nMem\u00f3ria Instalada: " + this.hardware.memoriaTotal(this.hal.getMemory()) + "\nSistema Operacional: " + this.hardware.sistemaOperacional());
        this.query.hardware(this.maquina);
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
            Logger.getLogger(Coletor2.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (InstantiationException ex2) {
            Logger.getLogger(Coletor2.class.getName()).log(Level.SEVERE, null, ex2);
        }
        catch (IllegalAccessException ex3) {
            Logger.getLogger(Coletor2.class.getName()).log(Level.SEVERE, null, ex3);
        }
        catch (UnsupportedLookAndFeelException ex4) {
            Logger.getLogger(Coletor2.class.getName()).log(Level.SEVERE, null, ex4);
        }
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Coletor2().setVisible(true);
            }
        });
    }
}
