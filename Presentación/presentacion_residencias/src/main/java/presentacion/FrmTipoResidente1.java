package presentacion;

public class FrmTipoResidente1 extends javax.swing.JFrame {

    /**
     * Creates new form FrmAsignarHabitacion
     */
    public FrmTipoResidente1() {
        initComponents();
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
        jLabel1 = new javax.swing.JLabel();
        altaResidentesTXT = new javax.swing.JLabel();
        panelInfo = new javax.swing.JPanel();
        checkBoxNuevoIngreso = new javax.swing.JCheckBox();
        checkBoxDeportista = new javax.swing.JCheckBox();
        checkBoxExtranjero = new javax.swing.JCheckBox();
        nombreResidenteTXT = new javax.swing.JLabel();
        idResidenteTXT = new javax.swing.JLabel();
        programaEducativoTXT = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        antecedentesTXT = new javax.swing.JLabel();
        btnConfirmarTipoResidente = new javax.swing.JButton();
        labelFotoPlaceholder = new javax.swing.JLabel();
        botonAgregarFotoResidente = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(228, 233, 236));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logo_ITSON.png"))); // NOI18N
        jLabel1.setText("jLabel1");

        altaResidentesTXT.setFont(new java.awt.Font("Kohinoor Gujarati", 1, 50)); // NOI18N
        altaResidentesTXT.setText("REGISTRO DE RESIDENTE");

        panelInfo.setBackground(new java.awt.Color(255, 255, 255));

        checkBoxNuevoIngreso.setFont(new java.awt.Font("Hiragino Sans CNS", 0, 24)); // NOI18N
        checkBoxNuevoIngreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxNuevoIngresoActionPerformed(evt);
            }
        });

        checkBoxDeportista.setFont(new java.awt.Font("Hiragino Sans CNS", 0, 14)); // NOI18N
        checkBoxDeportista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxDeportistaActionPerformed(evt);
            }
        });

        checkBoxExtranjero.setFont(new java.awt.Font("Hiragino Sans CNS", 0, 14)); // NOI18N

        nombreResidenteTXT.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 24)); // NOI18N
        nombreResidenteTXT.setText("Nombre del Residente");

        idResidenteTXT.setFont(new java.awt.Font("Hiragino Maru Gothic ProN", 0, 11)); // NOI18N
        idResidenteTXT.setForeground(new java.awt.Color(51, 51, 51));
        idResidenteTXT.setText("ID: 0000000000");

        programaEducativoTXT.setFont(new java.awt.Font("Hiragino Maru Gothic ProN", 0, 11)); // NOI18N
        programaEducativoTXT.setForeground(new java.awt.Color(51, 51, 51));
        programaEducativoTXT.setText("Programa educativo: Placeholder");

        jLabel2.setFont(new java.awt.Font("Hiragino Sans CNS", 0, 15)); // NOI18N
        jLabel2.setText("Deportista");

        jSeparator1.setBackground(new java.awt.Color(102, 102, 102));
        jSeparator1.setForeground(new java.awt.Color(204, 204, 204));

        jSeparator2.setBackground(new java.awt.Color(102, 102, 102));
        jSeparator2.setForeground(new java.awt.Color(204, 204, 204));

        jLabel3.setFont(new java.awt.Font("Hiragino Sans CNS", 0, 15)); // NOI18N
        jLabel3.setText("Nuevo Ingreso");

        jLabel4.setFont(new java.awt.Font("Hiragino Sans CNS", 0, 15)); // NOI18N
        jLabel4.setText("Extranjero");

        javax.swing.GroupLayout panelInfoLayout = new javax.swing.GroupLayout(panelInfo);
        panelInfo.setLayout(panelInfoLayout);
        panelInfoLayout.setHorizontalGroup(
            panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInfoLayout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelInfoLayout.createSequentialGroup()
                        .addGroup(panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(programaEducativoTXT)
                            .addComponent(idResidenteTXT)
                            .addComponent(nombreResidenteTXT))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelInfoLayout.createSequentialGroup()
                        .addGroup(panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(panelInfoLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(checkBoxDeportista))
                            .addGroup(panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(panelInfoLayout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(checkBoxNuevoIngreso))
                                    .addGroup(panelInfoLayout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(checkBoxExtranjero))
                                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 42, Short.MAX_VALUE))))
        );
        panelInfoLayout.setVerticalGroup(
            panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInfoLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(nombreResidenteTXT)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(idResidenteTXT)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(programaEducativoTXT)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkBoxNuevoIngreso)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkBoxExtranjero)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkBoxDeportista)
                    .addComponent(jLabel2))
                .addGap(52, 52, 52))
        );

        antecedentesTXT.setForeground(new java.awt.Color(153, 0, 0));
        antecedentesTXT.setText("*No se encontraron registros del residente");

        btnConfirmarTipoResidente.setBackground(new java.awt.Color(52, 47, 51));
        btnConfirmarTipoResidente.setForeground(new java.awt.Color(250, 250, 250));
        btnConfirmarTipoResidente.setText("CONFIRMAR");
        btnConfirmarTipoResidente.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        btnConfirmarTipoResidente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarTipoResidenteActionPerformed(evt);
            }
        });

        labelFotoPlaceholder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/placeholderPFP.jpg"))); // NOI18N

        botonAgregarFotoResidente.setBackground(new java.awt.Color(228, 233, 236));
        botonAgregarFotoResidente.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 15)); // NOI18N
        botonAgregarFotoResidente.setForeground(new java.awt.Color(0, 153, 255));
        botonAgregarFotoResidente.setText("Agregar foto");
        botonAgregarFotoResidente.setBorder(null);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(labelFotoPlaceholder)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 147, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(antecedentesTXT)
                    .addComponent(panelInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(altaResidentesTXT))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(206, 206, 206)
                        .addComponent(botonAgregarFotoResidente))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(514, 514, 514)
                        .addComponent(btnConfirmarTipoResidente, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(altaResidentesTXT)))
                .addGap(71, 71, 71)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(panelInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(antecedentesTXT))
                    .addComponent(labelFotoPlaceholder, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(botonAgregarFotoResidente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(btnConfirmarTipoResidente, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void checkBoxNuevoIngresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxNuevoIngresoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkBoxNuevoIngresoActionPerformed

    private void checkBoxDeportistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxDeportistaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkBoxDeportistaActionPerformed

    private void btnConfirmarTipoResidenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarTipoResidenteActionPerformed
        FrmTipoResidente1 frmTipoResidente = new FrmTipoResidente1();
        frmTipoResidente.setVisible(true);
    }//GEN-LAST:event_btnConfirmarTipoResidenteActionPerformed

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
            java.util.logging.Logger.getLogger(FrmTipoResidente1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmTipoResidente1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmTipoResidente1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmTipoResidente1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new FrmTipoResidente1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel altaResidentesTXT;
    private javax.swing.JLabel antecedentesTXT;
    private javax.swing.JButton botonAgregarFotoResidente;
    private javax.swing.JButton btnConfirmarTipoResidente;
    private javax.swing.JCheckBox checkBoxDeportista;
    private javax.swing.JCheckBox checkBoxExtranjero;
    private javax.swing.JCheckBox checkBoxNuevoIngreso;
    private javax.swing.JLabel idResidenteTXT;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel labelFotoPlaceholder;
    private javax.swing.JLabel nombreResidenteTXT;
    private javax.swing.JPanel panelInfo;
    private javax.swing.JLabel programaEducativoTXT;
    // End of variables declaration//GEN-END:variables
}
