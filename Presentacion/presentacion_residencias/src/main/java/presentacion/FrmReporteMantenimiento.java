/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package presentacion;

import control.ControlReporteMantenimiento;
import java.awt.Insets;
import java.util.List;
import javax.swing.JComboBox;

/**
 *
 * @author rauln
 */
public class FrmReporteMantenimiento extends javax.swing.JFrame {

    public static final String PISO_COMBOBOX_TEXT = "PISO";
    public static final String HABITACION_COMBOBOX_TEXT = "HABITACIÓN";
    public static final String RESIDENTE_COMBOBOX_TEXT = "RESIDENTE";
    public static final String RANGO_INICIO_COMBOBOX_TEXT = "INICIO";
    public static final String RANGO_FIN_COMBOBOX_TEXT = "FIN";
    private ControlReporteMantenimiento controlReporteMantenimiento;
    public FrmReporteMantenimiento(ControlReporteMantenimiento controlReporteMantenimiento) {
        initComponents();
        this.controlReporteMantenimiento = controlReporteMantenimiento;
        setLocationRelativeTo(null);  // Centra la ventana
        inicializarCombos();
        agregarListeners();
        

    }

    private void inicializarCombos() {
        List<String> pisos = controlReporteMantenimiento.obtenerPisos();
        inicializarComboConPlaceholder(comboBoxPisos, PISO_COMBOBOX_TEXT, pisos);
        comboBoxHabitaciones.setEnabled(false);
        comboBoxResidentes.setEnabled(false);
        comboBoxPrimerHoraRango.setEnabled(false);
        comboBoxSegundaHoraRango.setEnabled(false);
    }

    private void agregarListeners() {
        List<String> habitaciones = List.of("1", "2", "3");
        List<String> residentes = List.of("ari", "pedro", "julio");

        // Listener para Piso
        comboBoxPisos.addActionListener(e -> {
            if (seleccionValida(comboBoxPisos)) {
                // Habilita habitaciones y limpia/comienza desde el placeholder
                comboBoxHabitaciones.setEnabled(true);
                inicializarComboConPlaceholder(comboBoxHabitaciones, HABITACION_COMBOBOX_TEXT, habitaciones);
                // Deshabilita los siguientes combobox
                comboBoxResidentes.setEnabled(false);
                comboBoxResidentes.setSelectedIndex(0);
                comboBoxPrimerHoraRango.setEnabled(false);
                comboBoxPrimerHoraRango.setSelectedIndex(0);
                comboBoxSegundaHoraRango.setEnabled(false);
                comboBoxSegundaHoraRango.setSelectedIndex(0);
            } else {
                comboBoxHabitaciones.setEnabled(false);
                comboBoxResidentes.setEnabled(false);
                comboBoxPrimerHoraRango.setEnabled(false);
                comboBoxSegundaHoraRango.setEnabled(false);
            }
        });

        // Listener para Habitaciones
        comboBoxHabitaciones.addActionListener(e -> {
            if (seleccionValida(comboBoxHabitaciones)) {
                // Habilita residentes y limpia/comienza desde el placeholder
                comboBoxResidentes.setEnabled(true);
                inicializarComboConPlaceholder(comboBoxResidentes, RESIDENTE_COMBOBOX_TEXT, residentes);
                // Deshabilita los siguientes combobox
                comboBoxPrimerHoraRango.setEnabled(false);
                comboBoxPrimerHoraRango.setSelectedIndex(0);
                comboBoxSegundaHoraRango.setEnabled(false);
                comboBoxSegundaHoraRango.setSelectedIndex(0);
            } else {
                comboBoxResidentes.setEnabled(false);
                comboBoxPrimerHoraRango.setEnabled(false);
                comboBoxSegundaHoraRango.setEnabled(false);
            }
        });

        // Listener para Residentes
        comboBoxResidentes.addActionListener(e -> {
            if (seleccionValida(comboBoxResidentes)) {
                comboBoxPrimerHoraRango.setEnabled(true);
                inicializarComboConPlaceholder(comboBoxPrimerHoraRango, RANGO_INICIO_COMBOBOX_TEXT, null);
                comboBoxSegundaHoraRango.setEnabled(false);
                comboBoxSegundaHoraRango.setSelectedIndex(0);
            } else {
                comboBoxPrimerHoraRango.setEnabled(false);
                comboBoxSegundaHoraRango.setEnabled(false);
            }
        });

        // Listener para Primer Hora de Rango
        comboBoxPrimerHoraRango.addActionListener(e -> {
            if (seleccionValida(comboBoxPrimerHoraRango)) {
                comboBoxSegundaHoraRango.setEnabled(true);
                inicializarComboConPlaceholder(comboBoxSegundaHoraRango, RANGO_FIN_COMBOBOX_TEXT, null);
            } else {
                comboBoxSegundaHoraRango.setEnabled(false);
            }
        });
    }

    private void inicializarComboConPlaceholder(JComboBox<String> combo, String placeholder, List<String> elementos) {
        combo.removeAllItems();
        combo.addItem(placeholder); // Agrega el placeholder inicialmente

        // Luego, agrega las opciones reales solo si la lista de elementos no es null o vacía.
        if (elementos != null && !elementos.isEmpty()) {
            for (String elemento : elementos) {
                combo.addItem(elemento);
            }
        }

        // Desmarcar el placeholder, ya que el ComboBox se inicializa con el índice 0.
        combo.setSelectedIndex(0);
    }

    public static boolean seleccionValida(JComboBox<String> combo) {
        return combo.getSelectedIndex() > 0;
    }

    public static String obtenerSeleccion(JComboBox<String> combo) {
        if (seleccionValida(combo)) {
            return combo.getSelectedItem().toString();
        }
        return null;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fondo = new javax.swing.JPanel();
        labelTextTitulo = new javax.swing.JLabel();
        labelTextInformacion = new javax.swing.JLabel();
        labelTextHabitaciones = new javax.swing.JLabel();
        comboBoxResidentes = new javax.swing.JComboBox<>();
        labelTextResidentes = new javax.swing.JLabel();
        comboBoxHabitaciones = new javax.swing.JComboBox<>();
        labelTextInformacion1 = new javax.swing.JLabel();
        labelTextHorario1 = new javax.swing.JLabel();
        comboBoxSegundaHoraRango = new javax.swing.JComboBox<>();
        labelTextHorario2 = new javax.swing.JLabel();
        comboBoxPrimerHoraRango = new javax.swing.JComboBox<>();
        panelCajaTexto = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textAreaDescripcion = new javax.swing.JTextArea();
        labelTextInformacion2 = new javax.swing.JLabel();
        botonEnviar = new javax.swing.JButton();
        comboBoxPisos = new javax.swing.JComboBox<>();
        labelTextPiso = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(0, 0));
        setMinimumSize(new java.awt.Dimension(0, 0));
        setName("FrmReporteMantenimiento"); // NOI18N
        setPreferredSize(new java.awt.Dimension(835, 566));
        setResizable(false);
        setSize(new java.awt.Dimension(835, 566));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        fondo.setBackground(new java.awt.Color(255, 255, 255));
        fondo.setMinimumSize(new java.awt.Dimension(835, 546));
        fondo.setPreferredSize(new java.awt.Dimension(835, 546));
        fondo.setRequestFocusEnabled(false);
        fondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelTextTitulo.setFont(new java.awt.Font("Montserrat Medium", 1, 30)); // NOI18N
        labelTextTitulo.setText(" GENERAR REPORTE DE MANTENIMIENTO");
        fondo.add(labelTextTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(79, 15, -1, -1));

        labelTextInformacion.setFont(new java.awt.Font("Montserrat Medium", 1, 14)); // NOI18N
        labelTextInformacion.setForeground(new java.awt.Color(204, 204, 204));
        labelTextInformacion.setText("INFORMACIÓN");
        fondo.add(labelTextInformacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, -1, -1));

        labelTextHabitaciones.setFont(new java.awt.Font("Montserrat Medium", 1, 18)); // NOI18N
        labelTextHabitaciones.setText("HABITACIÓN");
        fondo.add(labelTextHabitaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 100, -1, 30));

        comboBoxResidentes.setFont(new java.awt.Font("Montserrat Medium", 1, 14)); // NOI18N
        comboBoxResidentes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "RESIDENTE" }));
        comboBoxResidentes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxResidentesActionPerformed(evt);
            }
        });
        fondo.add(comboBoxResidentes, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 140, 330, 30));

        labelTextResidentes.setFont(new java.awt.Font("Montserrat Medium", 1, 18)); // NOI18N
        labelTextResidentes.setText("RESIDENTE");
        fondo.add(labelTextResidentes, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, -1, 30));

        comboBoxHabitaciones.setFont(new java.awt.Font("Montserrat Medium", 1, 14)); // NOI18N
        comboBoxHabitaciones.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "HABITACIÓN" }));
        comboBoxHabitaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxHabitacionesActionPerformed(evt);
            }
        });
        fondo.add(comboBoxHabitaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 100, 140, 30));

        labelTextInformacion1.setFont(new java.awt.Font("Montserrat Medium", 1, 14)); // NOI18N
        labelTextInformacion1.setForeground(new java.awt.Color(204, 204, 204));
        labelTextInformacion1.setText("HORARIO PREFERENTE DE VISITA");
        fondo.add(labelTextInformacion1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 180, -1, -1));

        labelTextHorario1.setFont(new java.awt.Font("Montserrat Medium", 1, 18)); // NOI18N
        labelTextHorario1.setText("ENTRE");
        fondo.add(labelTextHorario1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 210, -1, 30));

        comboBoxSegundaHoraRango.setFont(new java.awt.Font("Montserrat Medium", 1, 14)); // NOI18N
        comboBoxSegundaHoraRango.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "FIN" }));
        fondo.add(comboBoxSegundaHoraRango, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 210, 110, 30));

        labelTextHorario2.setFont(new java.awt.Font("Montserrat Medium", 1, 18)); // NOI18N
        labelTextHorario2.setText("Y");
        fondo.add(labelTextHorario2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 210, -1, 30));

        comboBoxPrimerHoraRango.setFont(new java.awt.Font("Montserrat Medium", 1, 14)); // NOI18N
        comboBoxPrimerHoraRango.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "INICIO" }));
        comboBoxPrimerHoraRango.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxPrimerHoraRangoActionPerformed(evt);
            }
        });
        fondo.add(comboBoxPrimerHoraRango, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 210, 110, 30));

        panelCajaTexto.setBackground(new java.awt.Color(255, 255, 255));
        panelCajaTexto.setBorder(new javax.swing.border.MatteBorder(null));

        textAreaDescripcion.setColumns(20);
        textAreaDescripcion.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        textAreaDescripcion.setRows(5);
        jScrollPane1.setViewportView(textAreaDescripcion);

        javax.swing.GroupLayout panelCajaTextoLayout = new javax.swing.GroupLayout(panelCajaTexto);
        panelCajaTexto.setLayout(panelCajaTextoLayout);
        panelCajaTextoLayout.setHorizontalGroup(
            panelCajaTextoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCajaTextoLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 673, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        panelCajaTextoLayout.setVerticalGroup(
            panelCajaTextoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
        );

        fondo.add(panelCajaTexto, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 280, 675, 175));

        labelTextInformacion2.setFont(new java.awt.Font("Montserrat Medium", 1, 14)); // NOI18N
        labelTextInformacion2.setForeground(new java.awt.Color(204, 204, 204));
        labelTextInformacion2.setText("DESCRIPCIÓN DEL PROBLEMA");
        fondo.add(labelTextInformacion2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 260, -1, -1));

        botonEnviar.setBackground(new java.awt.Color(113, 209, 153));
        botonEnviar.setFont(new java.awt.Font("Montserrat Medium", 1, 18)); // NOI18N
        botonEnviar.setText("ENVIAR");
        botonEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEnviarActionPerformed(evt);
            }
        });
        fondo.add(botonEnviar, new org.netbeans.lib.awtextra.AbsoluteConstraints(345, 480, 145, 40));

        comboBoxPisos.setFont(new java.awt.Font("Montserrat Medium", 1, 14)); // NOI18N
        comboBoxPisos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PISO" }));
        comboBoxPisos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxPisosActionPerformed(evt);
            }
        });
        fondo.add(comboBoxPisos, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, 110, 30));

        labelTextPiso.setFont(new java.awt.Font("Montserrat Medium", 1, 18)); // NOI18N
        labelTextPiso.setText("PISO");
        fondo.add(labelTextPiso, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, -1, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconITSON_MANTENIMIENTO.jpg"))); // NOI18N
        fondo.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 50, 237, 231));

        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 835, 546));
    }// </editor-fold>//GEN-END:initComponents

    private void botonEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEnviarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonEnviarActionPerformed

    private void comboBoxPrimerHoraRangoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxPrimerHoraRangoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxPrimerHoraRangoActionPerformed

    private void comboBoxHabitacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxHabitacionesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxHabitacionesActionPerformed

    private void comboBoxPisosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxPisosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxPisosActionPerformed

    private void comboBoxResidentesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxResidentesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxResidentesActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonEnviar;
    private javax.swing.JComboBox<String> comboBoxHabitaciones;
    private javax.swing.JComboBox<String> comboBoxPisos;
    private javax.swing.JComboBox<String> comboBoxPrimerHoraRango;
    private javax.swing.JComboBox<String> comboBoxResidentes;
    private javax.swing.JComboBox<String> comboBoxSegundaHoraRango;
    private javax.swing.JPanel fondo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelTextHabitaciones;
    private javax.swing.JLabel labelTextHorario1;
    private javax.swing.JLabel labelTextHorario2;
    private javax.swing.JLabel labelTextInformacion;
    private javax.swing.JLabel labelTextInformacion1;
    private javax.swing.JLabel labelTextInformacion2;
    private javax.swing.JLabel labelTextPiso;
    private javax.swing.JLabel labelTextResidentes;
    private javax.swing.JLabel labelTextTitulo;
    private javax.swing.JPanel panelCajaTexto;
    private javax.swing.JTextArea textAreaDescripcion;
    // End of variables declaration//GEN-END:variables
}
