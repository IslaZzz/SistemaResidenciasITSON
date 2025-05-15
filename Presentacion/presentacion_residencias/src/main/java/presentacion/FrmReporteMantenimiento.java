/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package presentacion;

import control.ControlReporteMantenimiento;
import dto.ReporteDTO;
import excepciones.NegocioException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 * Ventana para generar reportes de mantenimiento en residencias estudiantiles.
 * Permite seleccionar el piso, habitacion, residente, horario preferente de
 * visita y describir el problema a reportar. Utiliza un controlador para
 * gestionar la logica de los reportes.
 *
 * @author rauln
 */
public class FrmReporteMantenimiento extends javax.swing.JFrame {

    // Constantes para los textos por defecto de los JComboBox
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
     * Constructor que inicializa la ventana, recibe el controlador, configura
     * los componentes, carga datos iniciales y agrega listeners.
     *
     * @param controlReporteMantenimiento Controlador para la logica de reportes
     */
    public FrmReporteMantenimiento(ControlReporteMantenimiento controlReporteMantenimiento) {
        this.controlReporteMantenimiento = controlReporteMantenimiento;
        initComponents(); // Llamamos a initComponents generado por el diseñador
        postInitComponents(); // Llamamos a un método adicional para cargar y configurar datos
        agregarListeners(); // Llamamos al método para agregar los listeners
    }

    /**
     * Método llamado después de initComponents para cargar los datos iniciales.
     */
    private void postInitComponents() {
        // Llamamos a los métodos para cargar datos en los ComboBoxes
        cargarComboBoxPisos();
    }

    /**
     * Agrega todos los listeners necesarios a los ComboBoxes para manejar los
     * eventos de selección.
     */
    private void agregarListeners() {
        comboBoxPisos.addActionListener(evt -> onPisoSelected());
        comboBoxHabitaciones.addActionListener(evt -> onHabitacionSelected());
        comboBoxResidentes.addActionListener(evt -> onResidenteSelected());
        comboBoxPrimerHoraRango.addActionListener(evt -> onPrimerHoraSelected());
    }

    /**
     * Carga el ComboBox de pisos con los valores obtenidos del controlador.
     */
    private void cargarComboBoxPisos() {
        List<Integer> pisos = controlReporteMantenimiento.obtenerPisos();
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        model.addElement(PISO_COMBOBOX_TEXT);
        for (Integer piso : pisos) {
            model.addElement(String.valueOf(piso));
        }
        comboBoxPisos.setModel(model);
    }

    /**
     * Carga el ComboBox de las habitaciones con los valores obtenidos del
     * controlador.
     */
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

    /**
     * Carga el ComboBox de los residentes con los valores obtenidos del
     * controlador.
     */
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

    /**
     * Carga el ComboBox de los horarios del primer combobox de seleccion de
     * hora con los valores obtenidos del controlador.
     */
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

    /**
     * Carga el ComboBox de los horarios del segundo combobox de seleccion de
     * hora con los valores obtenidos del controlador.
     */
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

    /**
     * Listener para cuando se selecciona un piso. Carga las habitaciones del
     * piso si la selección es válida.
     */
    private void onPisoSelected() {
        String selectedPiso = (String) comboBoxPisos.getSelectedItem();
        if (!selectedPiso.equals(PISO_COMBOBOX_TEXT)) {
            Integer pisoSeleccionado = Integer.valueOf(selectedPiso);
            cargarComboBoxHabitaciones(pisoSeleccionado);
        }
    }

    /**
     * Listener para cuando se selecciona una habitación. Carga los residentes
     * de la habitación si la selección es válida.
     */
    private void onHabitacionSelected() {
        String selectedHabitacion = (String) comboBoxHabitaciones.getSelectedItem();
        if (!selectedHabitacion.equals(HABITACION_COMBOBOX_TEXT)) {
            Integer habitacionSeleccionada = Integer.valueOf(selectedHabitacion);
            String selectedPiso = (String) comboBoxPisos.getSelectedItem();
            Integer pisoSeleccionado = Integer.valueOf(selectedPiso);
            cargarComboBoxResidentes(pisoSeleccionado, habitacionSeleccionada);
        }
    }

    /**
     * Listener para cuando se selecciona un residente. Carga el primer comboBox
     * de horarios si la selección es válida.
     */
    private void onResidenteSelected() {
        String selectedResidente = (String) comboBoxResidentes.getSelectedItem();
        if (!selectedResidente.equals(RESIDENTE_COMBOBOX_TEXT)) {
            cargarComboBoxHorarios(); // Cargar primer comboBox de horarios
        }
    }

    /**
     * Listener para cuando se selecciona la primera hora del rango. Si se
     * selecciona una hora válida, carga las horas posteriores.
     */
    private void onPrimerHoraSelected() {
        String selectedHoraInicio = (String) comboBoxPrimerHoraRango.getSelectedItem();
        if (selectedHoraInicio == null || selectedHoraInicio.equals(RANGO_INICIO_COMBOBOX_TEXT)) {
            comboBoxSegundaHoraRango.setEnabled(false);
            comboBoxSegundaHoraRango.removeAllItems();
            comboBoxSegundaHoraRango.addItem(RANGO_FIN_COMBOBOX_TEXT);
            return;
        }

        cargarComboBoxHorariosPosteriores(selectedHoraInicio);
    }

    /**
     * Valida que todos los campos estén completos y con valores válidos.
     *
     * @return true si todos los campos están correctamente llenados, false en
     * caso contrario
     */
    private boolean validarCamposCompletos() {
        String piso = (String) comboBoxPisos.getSelectedItem();
        String habitacion = (String) comboBoxHabitaciones.getSelectedItem();
        String residente = (String) comboBoxResidentes.getSelectedItem();
        String inicio = (String) comboBoxPrimerHoraRango.getSelectedItem();
        String fin = (String) comboBoxSegundaHoraRango.getSelectedItem();
        String descripcion = textAreaDescripcion.getText();

        return piso != null && !piso.equals("PISO")
                && habitacion != null && !habitacion.equals("HABITACION")
                && residente != null && !residente.equals("RESIDENTE")
                && inicio != null && !inicio.equals("INICIO")
                && fin != null && !fin.equals("FIN")
                && descripcion != null && !descripcion.trim().isEmpty();
    }

    /**
     * Limpia todos los campos del formulario, restableciendo los valores por
     * defecto.
     */
    private void limpiarCampos() {
        comboBoxPisos.setSelectedIndex(0);
        comboBoxHabitaciones.setSelectedIndex(0);
        comboBoxResidentes.setSelectedIndex(0);
        comboBoxPrimerHoraRango.setSelectedIndex(0);
        comboBoxSegundaHoraRango.setSelectedIndex(0);
        textAreaDescripcion.setText("");
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(0, 0));
        setName("FrmReporteMantenimiento"); // NOI18N
        setPreferredSize(new java.awt.Dimension(835, 566));
        setResizable(false);
        setSize(new java.awt.Dimension(835, 566));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
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
        fondo.add(comboBoxResidentes, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 140, 330, 30));

        labelTextResidentes.setFont(new java.awt.Font("Montserrat Medium", 1, 18)); // NOI18N
        labelTextResidentes.setText("RESIDENTE");
        fondo.add(labelTextResidentes, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, -1, 30));

        comboBoxHabitaciones.setFont(new java.awt.Font("Montserrat Medium", 1, 14)); // NOI18N
        comboBoxHabitaciones.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "HABITACIÓN" }));
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

        comboBoxPrimerHoraRango.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "INICIO" }));
        comboBoxPrimerHoraRango.setFont(new java.awt.Font("Montserrat Medium", 1, 14)); // NOI18N
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
        if (!validarCamposCompletos()) {
            JOptionPane.showMessageDialog(this, "Por favor, completa todos los campos antes de enviar.", "Campos incompletos", JOptionPane.WARNING_MESSAGE);
            return;
        }
        String piso = (String) comboBoxPisos.getSelectedItem();
        String habitacion = (String) comboBoxHabitaciones.getSelectedItem();
        String residente = (String) comboBoxResidentes.getSelectedItem();
        String inicio = (String) comboBoxPrimerHoraRango.getSelectedItem();
        String fin = (String) comboBoxSegundaHoraRango.getSelectedItem();
        String horarioVisita = controlReporteMantenimiento.fusionarHorarios(inicio, fin);
        String descripcion = textAreaDescripcion.getText();
        Date fechaHoraRegistro = new Date();

        try {
            ReporteDTO reporte = new ReporteDTO(piso, habitacion, residente, horarioVisita, descripcion, fechaHoraRegistro);
            controlReporteMantenimiento.registrarReporte(reporte);

            JOptionPane.showMessageDialog(this, "Reporte registrado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            // Opcional: limpiar campos después de enviar
            limpiarCampos();
        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(this, "Error al registrar el reporte: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(FrmReporteMantenimiento.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Ocurrió un error inesperado: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(FrmReporteMantenimiento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_botonEnviarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        controlReporteMantenimiento.acabarCaso();
    }//GEN-LAST:event_formWindowClosing

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
