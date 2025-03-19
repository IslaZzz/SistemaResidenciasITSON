package presentacion;

import javax.swing.ButtonGroup;

import control.ControlAltaResidente;
import dto.ResidenteDTO;
import javax.swing.JOptionPane;

public class FrmTipoResidente extends javax.swing.JFrame {


    private ControlAltaResidente control;
    /**
     * Creates new form FrmContrato
     */
    public FrmTipoResidente(ControlAltaResidente control) {
        this.control = control;
        initComponents();
    }

    
    public void cargarInfo(ResidenteDTO residente){
        this.idResidenteTXT.setText("ID: "+residente.getMatricula());
        this.nombreResidenteTXT.setText(residente.getNombreCompleto());
        this.programaEducativoTXT.setText("Programa Educativo: "+residente.getCarrera());
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
        panelInfo = new javax.swing.JPanel();
        nombreResidenteTXT = new javax.swing.JLabel();
        idResidenteTXT = new javax.swing.JLabel();
        programaEducativoTXT = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        radioButtonNuevoIngreso = new javax.swing.JRadioButton();
        radioButtonExtranjero = new javax.swing.JRadioButton();
        radioButtonDeportista = new javax.swing.JRadioButton();
        ButtonGroup grupoTipo = new ButtonGroup();
        grupoTipo.add(radioButtonNuevoIngreso);
        grupoTipo.add(radioButtonExtranjero);
        grupoTipo.add(radioButtonDeportista);
        btnConfirmarTipoResidente = new javax.swing.JButton();
        altaResidentesTXT = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(228, 233, 236));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logo_ITSON.png"))); // NOI18N
        jLabel1.setText("jLabel1");

        panelInfo.setBackground(new java.awt.Color(255, 255, 255));

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

        radioButtonNuevoIngreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioButtonNuevoIngresoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelInfoLayout = new javax.swing.GroupLayout(panelInfo);
        panelInfo.setLayout(panelInfoLayout);
        panelInfoLayout.setHorizontalGroup(
            panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInfoLayout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelInfoLayout.createSequentialGroup()
                        .addGroup(panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(idResidenteTXT)
                            .addComponent(nombreResidenteTXT)
                            .addComponent(programaEducativoTXT))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelInfoLayout.createSequentialGroup()
                        .addGroup(panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelInfoLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(radioButtonDeportista))
                            .addGroup(panelInfoLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(radioButtonExtranjero))
                            .addGroup(panelInfoLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(radioButtonNuevoIngreso))
                            .addGroup(panelInfoLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 42, Short.MAX_VALUE))))
        );
        panelInfoLayout.setVerticalGroup(
            panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInfoLayout.createSequentialGroup()
                .addGroup(panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelInfoLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(nombreResidenteTXT)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(idResidenteTXT)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(programaEducativoTXT)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                        .addComponent(jLabel3))
                    .addGroup(panelInfoLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(radioButtonNuevoIngreso)
                        .addGap(1, 1, 1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(panelInfoLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(radioButtonExtranjero)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(radioButtonDeportista))
                .addGap(52, 52, 52))
        );

        btnConfirmarTipoResidente.setBackground(new java.awt.Color(52, 47, 51));
        btnConfirmarTipoResidente.setForeground(new java.awt.Color(250, 250, 250));
        btnConfirmarTipoResidente.setText("CONFIRMAR");
        btnConfirmarTipoResidente.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        btnConfirmarTipoResidente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarTipoResidenteActionPerformed(evt);
            }
        });

        altaResidentesTXT.setFont(new java.awt.Font("Kohinoor Gujarati", 1, 50)); // NOI18N
        altaResidentesTXT.setText("REGISTRO DE RESIDENTE");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(341, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(panelInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(362, 362, 362))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnConfirmarTipoResidente, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(505, 505, 505))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(altaResidentesTXT)
                        .addGap(298, 298, 298))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addGap(20, 20, 20)
                .addComponent(altaResidentesTXT)
                .addGap(59, 59, 59)
                .addComponent(panelInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(btnConfirmarTipoResidente, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(148, Short.MAX_VALUE))
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

    private void btnConfirmarTipoResidenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarTipoResidenteActionPerformed
        String tipo = null;
        if(radioButtonDeportista.isSelected()){
            tipo = "Deportista";
        } else if (radioButtonExtranjero.isSelected()){
            tipo = "Extranjero";
        } else if (radioButtonNuevoIngreso.isSelected()){
            tipo = "NuevoIngreso";
        }
        if(tipo != null){
            int confirmar = JOptionPane.showConfirmDialog(
                this,
                "¿Seguro que desea asignar el tipo a :"+tipo+"?",
                "Confirmar",
                JOptionPane.YES_NO_OPTION);
            if(confirmar == JOptionPane.YES_OPTION){
                control.asignarTipo(control.getResidente(), tipo);
                JOptionPane.showMessageDialog(
                        this,
                        "Tipo actualizado con exito",
                        "Informacion",
                        JOptionPane.INFORMATION_MESSAGE);
                control.mostrarAsignarHabitacion();
            }
        }
        
    }//GEN-LAST:event_btnConfirmarTipoResidenteActionPerformed

    private void radioButtonNuevoIngresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioButtonNuevoIngresoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radioButtonNuevoIngresoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel altaResidentesTXT;
    private javax.swing.JButton btnConfirmarTipoResidente;
    private javax.swing.JLabel idResidenteTXT;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel nombreResidenteTXT;
    private javax.swing.JPanel panelInfo;
    private javax.swing.JLabel programaEducativoTXT;
    private javax.swing.JRadioButton radioButtonDeportista;
    private javax.swing.JRadioButton radioButtonExtranjero;
    private javax.swing.JRadioButton radioButtonNuevoIngreso;
    // End of variables declaration//GEN-END:variables
}
