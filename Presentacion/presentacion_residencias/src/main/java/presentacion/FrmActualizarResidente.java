/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package presentacion;

import control.ControlActualizarResidente;
import dto.ResidenteDTO;
import excepciones.NegocioException;
import javax.swing.JOptionPane;


/**
 * Ventana para actualizar los datos del contacto de emergencia de un residente.
 * Muestra la informacion del residente en campos no editables y permite modificar
 * el nombre y telefono del contacto de emergencia.
 * Extiende JFrameBase para heredar propiedades comunes de ventanas.
 */
public class FrmActualizarResidente extends JFrameBase {
    /**
     * Controlador para gestionar la logica de actualizacion de residentes.
     */
    private ControlActualizarResidente control;
    /**
     * DTO del residente cuya informacion se esta actualizando.
     */
    private ResidenteDTO residente;

    /**
     * Crea una nueva ventana FrmActualizarResidente.
     * Inicializa los componentes de la interfaz y asocia el controlador.
     * @param control Controlador para la logica de actualizacion
     */
    public FrmActualizarResidente(ControlActualizarResidente control) {
        super();
        this.control = control;
        initComponents();
    }
    
    /**
     * Carga la info del residente en los campos para mostrarla.
     * @param residente DTO con la info del residente.
     */
    public void cargarResidente(ResidenteDTO residente) {
        this.residente = residente;
        control.setResidente(residente);

        this.txtFieldIDEstudiante.setText(residente.getMatricula());
        this.txtFieldSemestre.setText(String.valueOf(residente.getSemestre()));
        this.txtFieldCarrera.setText(residente.getCarrera());
        this.txtFieldDireccion.setText(residente.getDireccion());
        this.txtFieldTelefono.setText(residente.getTelefono());
        this.txtFieldNombreCompleto.setText(residente.getNombreContactoEmergencia());
        this.txtFieldNumTelefono.setText(residente.getTelefonoContactoEmergencia());
        
        
        // Campos no editables
        this.txtFieldIDEstudiante.setEditable(false);
        this.txtFieldSemestre.setEditable(false);
        this.txtFieldCarrera.setEditable(false);
        this.txtFieldDireccion.setEditable(false);
        this.txtFieldTelefono.setEditable(false);
    }
    
    public void limpiarCampos() {
        this.txtFieldIDEstudiante.setText("");
        this.txtFieldSemestre.setText("");
        this.txtFieldCarrera.setText("");
        this.txtFieldDireccion.setText("");
        this.txtFieldTelefono.setText("");
        this.txtFieldNombreCompleto.setText("");
        this.txtFieldNumTelefono.setText("");

        this.txtFieldIDEstudiante.setEnabled(true);
        this.txtFieldSemestre.setEnabled(true);
        this.txtFieldCarrera.setEnabled(true);
        this.txtFieldDireccion.setEnabled(true);
        this.txtFieldTelefono.setEnabled(true);
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
        lblActualizarDatos = new javax.swing.JLabel();
        lblLogoResidencias = new javax.swing.JLabel();
        lblContacto = new javax.swing.JLabel();
        lblInformacionResidente = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblIDEstudiante = new javax.swing.JLabel();
        lblSemestre = new javax.swing.JLabel();
        lblCarrera = new javax.swing.JLabel();
        lblDireccion = new javax.swing.JLabel();
        lblTelefono = new javax.swing.JLabel();
        txtFieldIDEstudiante = new javax.swing.JTextField();
        txtFieldSemestre = new javax.swing.JTextField();
        txtFieldCarrera = new javax.swing.JTextField();
        txtFieldDireccion = new javax.swing.JTextField();
        txtFieldTelefono = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        lblNombreCompleto = new javax.swing.JLabel();
        txtFieldNombreCompleto = new javax.swing.JTextField();
        lblNumTelefono = new javax.swing.JLabel();
        txtFieldNumTelefono = new javax.swing.JTextField();
        btnSalir = new javax.swing.JButton();
        btnActualizarDatos = new javax.swing.JButton();
        lblIngresarInfo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(37, 55, 95));

        lblActualizarDatos.setFont(new java.awt.Font("Segoe UI", 0, 60)); // NOI18N
        lblActualizarDatos.setText("Actualizar Datos del Residente");

        lblLogoResidencias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Logotipo Residencias Estudiantiles Horizontal.png"))); // NOI18N

        lblContacto.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblContacto.setForeground(new java.awt.Color(107, 225, 251));
        lblContacto.setText("Contacto de emergencia");

        lblInformacionResidente.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblInformacionResidente.setText("Informacion del Residente");

        jPanel2.setBackground(new java.awt.Color(244, 244, 244));

        lblIDEstudiante.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblIDEstudiante.setForeground(new java.awt.Color(37, 55, 95));
        lblIDEstudiante.setText("ID estudiante");

        lblSemestre.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblSemestre.setForeground(new java.awt.Color(37, 55, 95));
        lblSemestre.setText("Semestre");

        lblCarrera.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblCarrera.setForeground(new java.awt.Color(37, 55, 95));
        lblCarrera.setText("Carrera");

        lblDireccion.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblDireccion.setForeground(new java.awt.Color(37, 55, 95));
        lblDireccion.setText("Dirección");

        lblTelefono.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblTelefono.setForeground(new java.awt.Color(37, 55, 95));
        lblTelefono.setText("Número de teléfono");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtFieldTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                    .addComponent(txtFieldDireccion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                    .addComponent(txtFieldCarrera, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtFieldSemestre, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtFieldIDEstudiante, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblIDEstudiante, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSemestre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCarrera, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDireccion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTelefono, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(159, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(lblIDEstudiante)
                .addGap(11, 11, 11)
                .addComponent(txtFieldIDEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblSemestre)
                .addGap(11, 11, 11)
                .addComponent(txtFieldSemestre, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblCarrera)
                .addGap(12, 12, 12)
                .addComponent(txtFieldCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblDireccion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFieldDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(lblTelefono)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFieldTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(27, 44, 87));

        lblNombreCompleto.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblNombreCompleto.setForeground(new java.awt.Color(242, 242, 242));
        lblNombreCompleto.setText("Nombre completo");

        lblNumTelefono.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblNumTelefono.setText("Número de teléfono");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblNumTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNombreCompleto, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFieldNombreCompleto, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
                    .addComponent(txtFieldNumTelefono))
                .addContainerGap(111, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(lblNombreCompleto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtFieldNombreCompleto, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblNumTelefono)
                .addGap(18, 18, 18)
                .addComponent(txtFieldNumTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        btnSalir.setBackground(new java.awt.Color(37, 55, 95));
        btnSalir.setForeground(new java.awt.Color(107, 225, 251));
        btnSalir.setText("Salir");
        btnSalir.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnActualizarDatos.setBackground(new java.awt.Color(107, 225, 251));
        btnActualizarDatos.setForeground(new java.awt.Color(37, 55, 95));
        btnActualizarDatos.setText("Actualizar datos");
        btnActualizarDatos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnActualizarDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarDatosActionPerformed(evt);
            }
        });

        lblIngresarInfo.setText("Ingrese los datos actualizados del contacto de emergencia");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblActualizarDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(lblLogoResidencias)
                        .addGap(50, 50, 50))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblInformacionResidente, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(149, 149, 149)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblContacto)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(btnActualizarDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(lblIngresarInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLogoResidencias, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(lblActualizarDatos)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(lblContacto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblIngresarInfo)
                        .addGap(15, 15, 15)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnActualizarDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(55, 55, 55))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblInformacionResidente)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Maneja el evento del boton Salir.
     * Limpia los campos, restablece el residente en el controlador y regresa a la pantalla de ingreso de ID.
     * @param evt Evento de accion del boton
     */
    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        limpiarCampos();
        control.acabarCaso();
    }//GEN-LAST:event_btnSalirActionPerformed

    /**
     * Maneja el evento del boton Actualizar datos.
     * Actualiza los datos del contacto de emergencia del residente utilizando los valores de los campos editables.
     * @param evt Evento de accion del boton
     */
    private void btnActualizarDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarDatosActionPerformed
        try {
            // Recolectar datos de contacto de emergencia
            String nombreContactoEmergencia = txtFieldNombreCompleto.getText().trim();
            String telefonoContactoEmergencia = txtFieldNumTelefono.getText().trim();

            // Validaciones del contacto de emergencia
            if (nombreContactoEmergencia.isEmpty()) {
                throw new IllegalArgumentException("El nombre del contacto de emergencia es obligatorio.");
            }
            if (!telefonoContactoEmergencia.matches("^\\d{10}$")) {
                throw new IllegalArgumentException("El número de contacto de emergencia debe tener 10 dígitos.");
            }

            // Actualizar datos 
            control.actualizarDatos(residente.getMatricula(), nombreContactoEmergencia, telefonoContactoEmergencia);
            // Mostrar mensaje de exito
            JOptionPane.showMessageDialog(
                this,
                "Datos del contacto de emergencia actualizados correctamente.",
                "Actualización Exitosa",
                JOptionPane.INFORMATION_MESSAGE
            );

        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(
                this,
                ex.getMessage(),
                "Error de Validación",
                JOptionPane.ERROR_MESSAGE
            );
        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(
                this,
                "Error al actualizar datos: " + ex.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }//GEN-LAST:event_btnActualizarDatosActionPerformed

 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizarDatos;
    private javax.swing.JButton btnSalir;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblActualizarDatos;
    private javax.swing.JLabel lblCarrera;
    private javax.swing.JLabel lblContacto;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblIDEstudiante;
    private javax.swing.JLabel lblInformacionResidente;
    private javax.swing.JLabel lblIngresarInfo;
    private javax.swing.JLabel lblLogoResidencias;
    private javax.swing.JLabel lblNombreCompleto;
    private javax.swing.JLabel lblNumTelefono;
    private javax.swing.JLabel lblSemestre;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JTextField txtFieldCarrera;
    private javax.swing.JTextField txtFieldDireccion;
    private javax.swing.JTextField txtFieldIDEstudiante;
    private javax.swing.JTextField txtFieldNombreCompleto;
    private javax.swing.JTextField txtFieldNumTelefono;
    private javax.swing.JTextField txtFieldSemestre;
    private javax.swing.JTextField txtFieldTelefono;
    // End of variables declaration//GEN-END:variables
}
