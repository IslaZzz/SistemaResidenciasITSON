/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package presentacion;

import control.ControlReporteMantenimiento;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

/**
 * Ventana para generar reportes de mantenimiento en residencias estudiantiles.
 * Permite seleccionar el piso, habitacion, residente, horario preferente de
 * visita y describir el problema a reportar. Utiliza un controlador para
 * gestionar la logica de los reportes.
 *
 * @author rauln
 */
public class FrmReporteMantenimiento extends javax.swing.JFrame {

    public static final String PISO_COMBOBOX_TEXT = "PISO";
    public static final String HABITACION_COMBOBOX_TEXT = "HABITACIÓN";
    public static final String RESIDENTE_COMBOBOX_TEXT = "RESIDENTE";
    public static final String RANGO_INICIO_COMBOBOX_TEXT = "INICIO";
    public static final String RANGO_FIN_COMBOBOX_TEXT = "FIN";

    /**
     * Controlador para gestionar la logica de reportes de mantenimiento.
     */
    private ControlReporteMantenimiento controlReporteMantenimiento;

    /**
     * Crea una nueva ventana FrmReporteMantenimiento. Inicializa los
     * componentes de la interfaz grafica, centra la ventana y configura los
     * ComboBox y sus listeners.
     *
     * @param controlReporteMantenimiento Controlador para la logica de reportes
     */
    public FrmReporteMantenimiento(ControlReporteMantenimiento controlReporteMantenimiento) {
        this.controlReporteMantenimiento = controlReporteMantenimiento;
        initComponents(); // Llamamos a initComponents generado por el diseñador
        postInitComponents(); // Llamamos a un método adicional para cargar y configurar datos
        agregarListeners(); // Llamamos al método para agregar los listeners
    }

    // Método que se llama después de initComponents
    private void postInitComponents() {
        // Llamamos a los métodos para cargar datos en los ComboBoxes
        cargarComboBoxPisos();
    }

    private void cargarComboBoxPisos() {
        List<Integer> pisos = controlReporteMantenimiento.obtenerPisos();
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        model.addElement(PISO_COMBOBOX_TEXT);
        for (Integer piso : pisos) {
            model.addElement(String.valueOf(piso));
        }
        comboBoxPisos.setModel(model);
    }

    private void cargarComboBoxHabitaciones(Integer pisoSeleccionado) {
        List<Integer> habitaciones = controlReporteMantenimiento.obtenerHabitacionesPorPiso(pisoSeleccionado);
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        model.addElement(HABITACION_COMBOBOX_TEXT);
        for (Integer habitacion : habitaciones) {
            model.addElement(String.valueOf(habitacion));
        }
        comboBoxHabitaciones.setModel(model);
        comboBoxHabitaciones.setEnabled(true);
    }

    private void cargarComboBoxResidentes(Integer pisoSeleccionado, Integer habitacionSeleccionada) {
        List<String> residentes = controlReporteMantenimiento.obtenerResidentesPorHabitacion(pisoSeleccionado, habitacionSeleccionada);
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        model.addElement(RESIDENTE_COMBOBOX_TEXT);
        for (String residente : residentes) {
            model.addElement(residente);
        }
        comboBoxResidentes.setModel(model);
        comboBoxResidentes.setEnabled(true);
    }

    private void cargarComboBoxHorarios() {
        List<String> horarios = controlReporteMantenimiento.generarHorarios();
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        model.addElement(RANGO_INICIO_COMBOBOX_TEXT);
        for (String horario : horarios) {
            model.addElement(horario);
        }
        comboBoxPrimerHoraRango.setModel(model);
        comboBoxPrimerHoraRango.setEnabled(true);
    }

    private void cargarComboBoxHorariosPosteriores(String horaInicio) {
        List<String> horariosPosteriores = controlReporteMantenimiento.obtenerHorariosPosteriores(horaInicio);
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        model.addElement(RANGO_FIN_COMBOBOX_TEXT);
        for (String horario : horariosPosteriores) {
            model.addElement(horario);
        }
        comboBoxSegundaHoraRango.setModel(model);
        comboBoxSegundaHoraRango.setEnabled(true);
    }

    private void onPisoSelected() {
        String selectedPiso = (String) comboBoxPisos.getSelectedItem();
        if (!selectedPiso.equals(PISO_COMBOBOX_TEXT)) {
            Integer pisoSeleccionado = Integer.valueOf(selectedPiso);
            cargarComboBoxHabitaciones(pisoSeleccionado);
        }
    }

    private void onHabitacionSelected() {
        String selectedHabitacion = (String) comboBoxHabitaciones.getSelectedItem();
        if (!selectedHabitacion.equals(HABITACION_COMBOBOX_TEXT)) {
            Integer habitacionSeleccionada = Integer.valueOf(selectedHabitacion);
            String selectedPiso = (String) comboBoxPisos.getSelectedItem();
            Integer pisoSeleccionado = Integer.valueOf(selectedPiso);
            cargarComboBoxResidentes(pisoSeleccionado, habitacionSeleccionada);
        }
    }

    private void agregarListeners() {
        comboBoxPisos.addActionListener(evt -> onPisoSelected());
        comboBoxHabitaciones.addActionListener(evt -> onHabitacionSelected());
    }

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

    /**
     * Maneja el evento del boton Enviar.
     *
     * @param evt Evento de accion del boton
     */
    private void botonEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEnviarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonEnviarActionPerformed

    /**
     * Maneja el evento de seleccion en el ComboBox de la primera hora del
     * rango.
     *
     * @param evt Evento de accion del ComboBox
     */
    private void comboBoxPrimerHoraRangoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxPrimerHoraRangoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxPrimerHoraRangoActionPerformed

    /**
     * Maneja el evento de seleccion en el ComboBox de habitaciones. Actualmente
     * sin funcionalidad implementada adicional a la definida en
     * agregarListeners.
     *
     * @param evt Evento de accion del ComboBox
     */
    private void comboBoxHabitacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxHabitacionesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxHabitacionesActionPerformed

    /**
     * Maneja el evento de seleccion en el ComboBox de pisos.
     *
     * @param evt Evento de accion del ComboBox
     */
    private void comboBoxPisosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxPisosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxPisosActionPerformed

    /**
     * Maneja el evento de seleccion en el ComboBox de residentes.
     *
     * @param evt Evento de accion del ComboBox
     */
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
