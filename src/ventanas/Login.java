package ventanas;

import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import clases.Conexion;
import java.sql.*;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {

//variables que permite enviar inf entre interfaces
    public static String user = "";
    String pass = "";

    public Login() {
        initComponents();
        this.setLocationRelativeTo(null);// la ventana paaresca en medio del monitor
        this.setTitle("Login");//titulo
        this.setSize(400, 550);//tamaño de la ventana
        this.setResizable(false);// el usuario no modifique el tamaño d ela ventana

//inicio agregar y escalar la inm del label 
        ImageIcon fondo = new ImageIcon("src/img/fondoa2.jpg");
        Icon icono_fondo = new ImageIcon(fondo.getImage().getScaledInstance(fondo_log.getWidth(),
                fondo_log.getHeight(), Image.SCALE_DEFAULT));

        fondo_log.setIcon(icono_fondo);
        this.repaint();
// fin de fondo de icono

// logo del login
        ImageIcon logo_login = new ImageIcon("src/img/user1.png");
        Icon icono_logo = new ImageIcon(logo_login.getImage().getScaledInstance(jbl_logo.getWidth(), jbl_logo.getHeight(), Image.SCALE_DEFAULT));
        jbl_logo.setIcon(icono_logo);
        this.repaint();
//fin logo
    }
// icono en cabezera jframe e icono de la app

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("img/user1.png"));
        return retValue;
    }
//fin icono jframeFrame

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jbl_logo = new javax.swing.JLabel();
        txt_user = new javax.swing.JTextField();
        txt_pass = new javax.swing.JPasswordField();
        btn_acceder = new javax.swing.JButton();
        footer = new javax.swing.JLabel();
        fondo_log = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jbl_logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 150, 150));

        txt_user.setBackground(new java.awt.Color(248, 249, 249));
        txt_user.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txt_user.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_user.setToolTipText("");
        txt_user.setAlignmentX(95.0F);
        txt_user.setAlignmentY(130.0F);
        txt_user.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_user, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 290, 210, -1));

        txt_pass.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txt_pass.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_pass.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 350, 210, -1));

        btn_acceder.setBackground(new java.awt.Color(24, 40, 88));
        btn_acceder.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        btn_acceder.setForeground(new java.awt.Color(255, 255, 255));
        btn_acceder.setText("Acceder");
        btn_acceder.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_acceder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_accederActionPerformed(evt);
            }
        });
        getContentPane().add(btn_acceder, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 410, 220, 30));

        footer.setForeground(new java.awt.Color(255, 255, 255));
        footer.setText("Craedo por SaraHdzz 2022@");
        getContentPane().add(footer, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 460, -1, -1));
        getContentPane().add(fondo_log, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 550));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_accederActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_accederActionPerformed

//recuperar los datos que se escriben 
        user = txt_user.getText().trim();
        pass = txt_pass.getText().trim();
//validacion de  user y pass
        if (!user.equals("") || !pass.equals("")) {
            try {
                Connection cn1 = Conexion.conectar();
                PreparedStatement pst = cn1.prepareStatement("select tipo_nivel, status from usuarios where username= '" + user
                        + "' and password = '" + pass + "'");

                ResultSet rs = pst.executeQuery();
                if (rs.next()) {//valida el estatus y el tipo
                    String tipo_nivel = rs.getString("tipo_nivel");
                    String status = rs.getString("status");

                    if (tipo_nivel.equalsIgnoreCase("Administrador") && status.equalsIgnoreCase("Activo")) {
                        dispose();//permite qeu el jframe sea limpiado y cerrada
                        new Administrador().setVisible(true);//abra la interfaz administrador
                    } else if (tipo_nivel.equalsIgnoreCase("Capturista") && status.equalsIgnoreCase("Activo")) {
                        dispose();//permite qeu el jframe sea limpiado y cerrada
                        new Capturista().setVisible(true);//abra la interfaz administrador
                    } else if (tipo_nivel.equalsIgnoreCase("Tecnico") && status.equalsIgnoreCase("Activo")) {
                        dispose();//permite qeu el jframe sea limpiado y cerrada
                        new Tecnico().setVisible(true);//abra la interfaz administrador
}

                    } else {
                        JOptionPane.showMessageDialog(null, "Datos de Acceso incorrectos");
                        txt_user.setText("");
                        txt_pass.setText("");
                    }
                }catch (Exception e) {
                System.err.println("Error en el boton acceder" + e);
                JOptionPane.showMessageDialog(null, "Error al iniciar sesion, Contacte al Administrador");
            }
            }else {
            JOptionPane.showMessageDialog(null, "Debes llenar todos los campos");
        }
    }//GEN-LAST:event_btn_accederActionPerformed

    

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_acceder;
    private javax.swing.JLabel fondo_log;
    private javax.swing.JLabel footer;
    private javax.swing.JLabel jbl_logo;
    private javax.swing.JPasswordField txt_pass;
    private javax.swing.JTextField txt_user;
    // End of variables declaration//GEN-END:variables
}
