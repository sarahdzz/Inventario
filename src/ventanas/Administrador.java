package ventanas;

import clases.Conexion;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.WindowConstants;

public class Administrador extends javax.swing.JFrame {
//variables de la clase

    String user, nom_usser;
    public static int session_usuario;

//constructor
    public Administrador() {
        initComponents();
        user = Login.user;//guardamos el valor de la interfaz login 
        session_usuario = 1;
        this.setSize(1041, 630);
        setResizable(false);//no se modifique el tam del from
        this.setTitle("Administrador - Sistema de Inventario - " + user);
        this.setLocationRelativeTo(null);
//cuando se cierre la ventana por default la ejecucion termine
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//metodo para modificar el fondo de  el label 
//inicio agregar y escalar la inm del label 
        ImageIcon fondo = new ImageIcon("src/img/17538.jpg");
        Icon icono_fondo = new ImageIcon(fondo.getImage().getScaledInstance(lb_fondo.getWidth(),
                lb_fondo.getHeight(), Image.SCALE_DEFAULT));

        lb_fondo.setIcon(icono_fondo);
        this.repaint();
// fin de fondo de icono

// variable con el nombre del usuario
        try {
            Connection cn3 = Conexion.conectar();
            PreparedStatement pst = cn3.prepareStatement("select nombre from usuarios where username='" + user + "'");
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                user = rs.getString("nombre");
                lbl_nom_user.setText(user);

            }
        } catch (Exception e) {
        }
    }

// icono en cabezera jframe e icono de la app
    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("img/user1.png"));
        return retValue;
    }
//tambien se debe modifica eliconimage deljframe desde diseño 
//fin icono jframeFrame
//fins

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_Acerca = new javax.swing.JButton();
        btn_resgritro_user1 = new javax.swing.JButton();
        btn_gestion = new javax.swing.JButton();
        btn_capturista = new javax.swing.JButton();
        btn_tecnico = new javax.swing.JButton();
        btn_creativida = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lbl_nom_user = new javax.swing.JLabel();
        lb_fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_Acerca.setBackground(new java.awt.Color(58, 134, 255));
        btn_Acerca.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_Acerca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/acerca.png"))); // NOI18N
        btn_Acerca.setText("Acerca de..");
        btn_Acerca.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_Acerca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AcercaActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Acerca, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 170, 40));

        btn_resgritro_user1.setBackground(new java.awt.Color(58, 134, 255));
        btn_resgritro_user1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_resgritro_user1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/adduser1.png"))); // NOI18N
        btn_resgritro_user1.setText("Agregar Usuario");
        btn_resgritro_user1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_resgritro_user1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_resgritro_user1ActionPerformed(evt);
            }
        });
        getContentPane().add(btn_resgritro_user1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 170, 40));

        btn_gestion.setBackground(new java.awt.Color(58, 134, 255));
        btn_gestion.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_gestion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/gest_user.png"))); // NOI18N
        btn_gestion.setText("Gestionar Usuarios");
        btn_gestion.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_gestion.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_gestion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_gestionActionPerformed(evt);
            }
        });
        getContentPane().add(btn_gestion, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 170, 40));

        btn_capturista.setBackground(new java.awt.Color(58, 134, 255));
        btn_capturista.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_capturista.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/capturist.png"))); // NOI18N
        btn_capturista.setText("Capturar Datos");
        btn_capturista.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_capturista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_capturistaActionPerformed(evt);
            }
        });
        getContentPane().add(btn_capturista, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 170, 40));

        btn_tecnico.setBackground(new java.awt.Color(58, 134, 255));
        btn_tecnico.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_tecnico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/tecnico.png"))); // NOI18N
        btn_tecnico.setText("Tecnico    ");
        btn_tecnico.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_tecnico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tecnicoActionPerformed(evt);
            }
        });
        getContentPane().add(btn_tecnico, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 170, 40));

        btn_creativida.setBackground(new java.awt.Color(58, 134, 255));
        btn_creativida.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_creativida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/creativid.png"))); // NOI18N
        btn_creativida.setText("Creatividad");
        btn_creativida.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_creativida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_creatividaActionPerformed(evt);
            }
        });
        getContentPane().add(btn_creativida, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 170, 40));

        jPanel1.setBackground(new java.awt.Color(58, 134, 255));

        lbl_nom_user.setFont(new java.awt.Font("Constantia", 1, 12)); // NOI18N
        lbl_nom_user.setForeground(new java.awt.Color(255, 255, 255));
        lbl_nom_user.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_nom_user.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/user.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_nom_user)
                .addContainerGap(134, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(lbl_nom_user)
                .addContainerGap(583, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 170, 630));

        lb_fondo.setBackground(new java.awt.Color(58, 134, 255));
        getContentPane().add(lb_fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1040, 630));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_AcercaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AcercaActionPerformed

    }//GEN-LAST:event_btn_AcercaActionPerformed

    private void btn_resgritro_user1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_resgritro_user1ActionPerformed
        RegistroUsuarios registaraUser = new RegistroUsuarios();
        registaraUser.setVisible(true);
    }//GEN-LAST:event_btn_resgritro_user1ActionPerformed

    private void btn_gestionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_gestionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_gestionActionPerformed

    private void btn_capturistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_capturistaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_capturistaActionPerformed

    private void btn_tecnicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tecnicoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_tecnicoActionPerformed

    private void btn_creatividaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_creatividaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_creatividaActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Administrador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Acerca;
    private javax.swing.JButton btn_capturista;
    private javax.swing.JButton btn_creativida;
    private javax.swing.JButton btn_gestion;
    private javax.swing.JButton btn_resgritro_user1;
    private javax.swing.JButton btn_tecnico;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lb_fondo;
    private javax.swing.JLabel lbl_nom_user;
    // End of variables declaration//GEN-END:variables
}
