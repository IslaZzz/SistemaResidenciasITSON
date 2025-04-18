package presentacion;

import javax.swing.JOptionPane;

import control.ControlAltaResidente;
import dto.ResidenteDTO;

public class FrmInfoEstudiante extends JFrameBase {

    private ControlAltaResidente control;

    /**
     * Creates new form FrmInfoEstudiante
     */
    public FrmInfoEstudiante(ControlAltaResidente control) {
        super();
        this.control = control;
        initComponents();
    }

    /**
     * Carga la información del estudiante en los inputs para mostrarla
     *
     * @param estudiante DTO con la información del estudiante
     */
    public void cargarEstudiante(ResidenteDTO estudiante) {
        String matricula = estudiante.getMatricula();
        String nombreCompleto = estudiante.getNombreCompleto();
        int semestre = estudiante.getSemestre();
        String carrera = estudiante.getCarrera();
        String telefono = estudiante.getTelefono();
        String direccion = estudiante.getDireccion();
        control.setResidente(estudiante);

        this.campoTextoID1.setText(matricula);
        this.campoTextoNombre.setText(nombreCompleto);
        this.campoTextoSemestre.setText(Integer.toString(semestre));
        this.campoTextoCarrera.setText(carrera);
        this.campoTextoNum.setText(telefono);
        this.campoTextoDireccion.setText(direccion);

        this.campoTextoID1.setEditable(false);
        this.campoTextoNombre.setEditable(false);
        this.campoTextoSemestre.setEditable(false);
        this.campoTextoCarrera.setEditable(false);
        this.campoTextoNum.setEditable(false);
        this.campoTextoDireccion.setEditable(false);
    }

    private void limpiarCampos() {
        this.campoTextoID1.setText("");
        this.campoTextoNombre.setText("");
        this.campoTextoSemestre.setText("");
        this.campoTextoCarrera.setText("");
        this.campoTextoNum.setText("");
        this.campoTextoDireccion.setText("");
        this.campoTextoNombreContactoEmergencia.setText("");
        this.campoTextoNumContactoEmergencia.setText("");

        this.campoTextoID1.setEnabled(true);
        this.campoTextoNombre.setEnabled(true);
        this.campoTextoSemestre.setEnabled(true);
        this.campoTextoCarrera.setEnabled(true);
        this.campoTextoNum.setEnabled(true);
        this.campoTextoDireccion.setEnabled(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        idEstudianteTXT = new javax.swing.JLabel();
        campoTextoCarrera = new javax.swing.JTextField();
        idEstudianteTXT1 = new javax.swing.JLabel();
        campoTextoID1 = new javax.swing.JTextField();
        idEstudianteTXT2 = new javax.swing.JLabel();
        campoTextoNombre = new javax.swing.JTextField();
        campoTextoSemestre = new javax.swing.JTextField();
        idEstudianteTXT3 = new javax.swing.JLabel();
        idEstudianteTXT4 = new javax.swing.JLabel();
        campoTextoNumContactoEmergencia = new javax.swing.JTextField();
        idEstudianteTXT5 = new javax.swing.JLabel();
        idEstudianteTXT6 = new javax.swing.JLabel();
        campoTextoNombreContactoEmergencia = new javax.swing.JTextField();
        idEstudianteTXT7 = new javax.swing.JLabel();
        campoTextoDireccion = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnObtenerInformacion = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        campoTextoNum = new javax.swing.JTextField();
        altaResidentesTXT = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(228, 233, 236));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logo_ITSON.png"))); // NOI18N
        jLabel1.setText("jLabel1");

        idEstudianteTXT.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        idEstudianteTXT.setText("CARRERA");

        campoTextoCarrera.setFont(new java.awt.Font("Hiragino Maru Gothic ProN", 1, 18)); // NOI18N

        idEstudianteTXT1.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        idEstudianteTXT1.setText("ID ESTUDIANTE");

        campoTextoID1.setFont(new java.awt.Font("Hiragino Maru Gothic ProN", 1, 18)); // NOI18N

        idEstudianteTXT2.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        idEstudianteTXT2.setText("NOMBRE");

        campoTextoNombre.setFont(new java.awt.Font("Hiragino Maru Gothic ProN", 1, 18)); // NOI18N

        campoTextoSemestre.setFont(new java.awt.Font("Hiragino Maru Gothic ProN", 1, 18)); // NOI18N

        idEstudianteTXT3.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        idEstudianteTXT3.setText("SEMESTRE");

        idEstudianteTXT4.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        idEstudianteTXT4.setText("NÚMERO DE TELÉFONO");

        campoTextoNumContactoEmergencia.setFont(new java.awt.Font("Hiragino Maru Gothic ProN", 1, 18)); // NOI18N

        idEstudianteTXT5.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        idEstudianteTXT5.setText("NÚMERO DEL CONTACTO");

        idEstudianteTXT6.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        idEstudianteTXT6.setText("DIRECCIÓN");

        campoTextoNombreContactoEmergencia.setFont(new java.awt.Font("Hiragino Maru Gothic ProN", 1, 18)); // NOI18N

        idEstudianteTXT7.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        idEstudianteTXT7.setText("CONTACTO DE EMERGENCIA");

        campoTextoDireccion.setFont(new java.awt.Font("Hiragino Maru Gothic ProN", 1, 18)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Al Bayan", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 153, 255));
        jLabel3.setText("La información fue actualizada por última vez: ");

        btnObtenerInformacion.setBackground(new java.awt.Color(52, 47, 51));
        btnObtenerInformacion.setForeground(new java.awt.Color(250, 250, 250));
        btnObtenerInformacion.setText("DAR DE ALTA");
        btnObtenerInformacion.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        btnObtenerInformacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObtenerInformacionActionPerformed(evt);
            }
        });

        btnSalir.setBackground(new java.awt.Color(228, 233, 236));
        btnSalir.setText("SALIR");
        btnSalir.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        campoTextoNum.setFont(new java.awt.Font("Hiragino Maru Gothic ProN", 1, 18)); // NOI18N

        altaResidentesTXT.setFont(new java.awt.Font("Kohinoor Gujarati", 1, 50)); // NOI18N
        altaResidentesTXT.setText("ALTA DE RESIDENTES");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(idEstudianteTXT)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(idEstudianteTXT1)
                                .addComponent(idEstudianteTXT2)
                                .addComponent(idEstudianteTXT3)
                                .addComponent(campoTextoNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                                .addComponent(campoTextoCarrera)
                                .addComponent(campoTextoSemestre)
                                .addComponent(campoTextoID1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(252, 252, 252)
                                .addComponent(jLabel2))
                            .addComponent(jLabel3))
                        .addGap(100, 100, 100)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(idEstudianteTXT4)
                            .addComponent(idEstudianteTXT6)
                            .addComponent(idEstudianteTXT7)
                            .addComponent(idEstudianteTXT5)
                            .addComponent(campoTextoNum, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                            .addComponent(campoTextoDireccion)
                            .addComponent(campoTextoNombreContactoEmergencia)
                            .addComponent(campoTextoNumContactoEmergencia)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(115, 115, 115)
                        .addComponent(altaResidentesTXT))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(532, 532, 532)
                        .addComponent(btnObtenerInformacion, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(603, 603, 603)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(195, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel1)
                        .addGap(88, 88, 88))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(altaResidentesTXT)
                        .addGap(31, 31, 31)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idEstudianteTXT4)
                    .addComponent(idEstudianteTXT1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoTextoID1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoTextoNum, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idEstudianteTXT6)
                    .addComponent(idEstudianteTXT2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoTextoDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoTextoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idEstudianteTXT3)
                    .addComponent(idEstudianteTXT7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoTextoSemestre, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoTextoNombreContactoEmergencia, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idEstudianteTXT)
                    .addComponent(idEstudianteTXT5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoTextoCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoTextoNumContactoEmergencia, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(26, 26, 26)
                .addComponent(btnObtenerInformacion, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(9, Short.MAX_VALUE))
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

    private void btnObtenerInformacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObtenerInformacionActionPerformed
        try {
            String nombreContactoEmergencia = this.campoTextoNombreContactoEmergencia.getText();
            String numContactoEmergencia = this.campoTextoNumContactoEmergencia.getText();
            if (!numContactoEmergencia.matches("^\\d{10}$")) {
                throw new Exception("El número de contacto de emergencia debe tener 10 dígitos");
            }
            control.getResidente().setNombreContactoEmergencia(nombreContactoEmergencia);
            control.getResidente().setTelefonoContactoEmergencia(numContactoEmergencia);
            int confirmacion = JOptionPane.showConfirmDialog(
                    this, 
                    "¿Seguro que desea dar de alta al residente?",
                    "Confirmar",
                    JOptionPane.YES_NO_OPTION);
            if(confirmacion == JOptionPane.YES_OPTION){
                control.registrarResidente(control.getResidente());
                JOptionPane.showMessageDialog(
                        this,
                        "Residente dado de alta exitosamente",
                        "Informacion",
                        JOptionPane.INFORMATION_MESSAGE);
                control.mostrarTipoResidente();
            }
        } catch(Exception ex){
            JOptionPane.showMessageDialog(
                        this,
                        ex.getMessage(),
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_btnObtenerInformacionActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        limpiarCampos();
        control.setResidente(null);
        control.volverIngresarIDEstudiante();
    }//GEN-LAST:event_btnSalirActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel altaResidentesTXT;
    private javax.swing.JButton btnObtenerInformacion;
    private javax.swing.JButton btnSalir;
    private javax.swing.JTextField campoTextoCarrera;
    private javax.swing.JTextField campoTextoDireccion;
    private javax.swing.JTextField campoTextoID1;
    private javax.swing.JTextField campoTextoNombre;
    private javax.swing.JTextField campoTextoNombreContactoEmergencia;
    private javax.swing.JTextField campoTextoNum;
    private javax.swing.JTextField campoTextoNumContactoEmergencia;
    private javax.swing.JTextField campoTextoSemestre;
    private javax.swing.JLabel idEstudianteTXT;
    private javax.swing.JLabel idEstudianteTXT1;
    private javax.swing.JLabel idEstudianteTXT2;
    private javax.swing.JLabel idEstudianteTXT3;
    private javax.swing.JLabel idEstudianteTXT4;
    private javax.swing.JLabel idEstudianteTXT5;
    private javax.swing.JLabel idEstudianteTXT6;
    private javax.swing.JLabel idEstudianteTXT7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
