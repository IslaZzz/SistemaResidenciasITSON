/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package presentacion.cuGenerarContrato;

import control.ControlGenerarContrato;
import dto.ResidenteDTO;
import javax.swing.JFrame;

/**
 *
 * @author abrilislas
 */
public class FrmFiadorEncontrado extends javax.swing.JFrame {
        
    private ControlGenerarContrato control;
    private ResidenteDTO residenteDTO;

    /**
     * Creates new form FrmFiadorEncontrado
     */
    public FrmFiadorEncontrado(ControlGenerarContrato control) {
        this.control=control;
        initComponents();
        // No permitir redimensionar
        this.setResizable(false);
        // Centrar en pantalla
        this.setLocationRelativeTo(null);
        // Cerrar el sistema al cerrar la ventana
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

        public void enviarResidenteDTO( ResidenteDTO residenteDTO){
        this.residenteDTO=residenteDTO;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblLogoResi = new javax.swing.JLabel();
        lblPreview = new javax.swing.JLabel();
        lblPreview1 = new javax.swing.JLabel();
        btnGenerarContraroPDF = new javax.swing.JButton();
        btnRegistrarFiador = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        lblLogoResi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Logotipo Residencias Estudiantiles Horizontal.png"))); // NOI18N

        lblPreview.setFont(new java.awt.Font("Apple LiGothic", 0, 24)); // NOI18N
        lblPreview.setForeground(new java.awt.Color(0, 51, 153));
        lblPreview.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblPreview.setText("¿Desea actualizar la información del fiador?");
        lblPreview.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        lblPreview1.setFont(new java.awt.Font("Apple LiGothic", 0, 24)); // NOI18N
        lblPreview1.setForeground(new java.awt.Color(0, 51, 153));
        lblPreview1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblPreview1.setText("El residente ya cuenta con un fiador registrado,");
        lblPreview1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        btnGenerarContraroPDF.setBackground(new java.awt.Color(107, 225, 251));
        btnGenerarContraroPDF.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 18)); // NOI18N
        btnGenerarContraroPDF.setForeground(new java.awt.Color(27, 44, 87));
        btnGenerarContraroPDF.setText("Generar contrato");
        btnGenerarContraroPDF.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        btnGenerarContraroPDF.setBorderPainted(false);
        btnGenerarContraroPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarContraroPDFActionPerformed(evt);
            }
        });

        btnRegistrarFiador.setBackground(new java.awt.Color(107, 225, 251));
        btnRegistrarFiador.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 18)); // NOI18N
        btnRegistrarFiador.setForeground(new java.awt.Color(27, 44, 87));
        btnRegistrarFiador.setText("Actualizar fiador");
        btnRegistrarFiador.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        btnRegistrarFiador.setBorderPainted(false);
        btnRegistrarFiador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarFiadorActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(27, 44, 87));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 33, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(lblLogoResi, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnRegistrarFiador, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(63, 63, 63)
                        .addComponent(btnGenerarContraroPDF, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(94, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPreview1)
                            .addComponent(lblPreview))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(lblLogoResi, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(lblPreview1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblPreview)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGenerarContraroPDF, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegistrarFiador, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGenerarContraroPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarContraroPDFActionPerformed
        control.abrirFormularioFiador(residenteDTO);
    }//GEN-LAST:event_btnGenerarContraroPDFActionPerformed

    private void btnRegistrarFiadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarFiadorActionPerformed
        control.abrirPantallaDescarga(residenteDTO);
    }//GEN-LAST:event_btnRegistrarFiadorActionPerformed
//agregar metodo para crear fiadorDTO y enviarlo a 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGenerarContraroPDF;
    private javax.swing.JButton btnRegistrarFiador;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblLogoResi;
    private javax.swing.JLabel lblPreview;
    private javax.swing.JLabel lblPreview1;
    // End of variables declaration//GEN-END:variables
}
