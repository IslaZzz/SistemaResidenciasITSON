package presentacion;

import javax.swing.JOptionPane;

import control.ControlAltaResidente;
import control.ControlActualizarResidente;
import dto.ResidenteDTO;
import java.awt.Color;

/**
 * Ventana para mostrar la informacion de un estudiante y registrar los datos de su contacto de emergencia.
 * Permite visualizar detalles del residente, ingresar informacion de contacto de emergencia y continuar
 * con el proceso de alta o salir. Extiende JFrameBase para heredar propiedades comunes de ventanas.
 */
public class FrmInfoEstudiante extends JFrameBase {

    /**
     * Controlador para gestionar la logica de alta de residentes.
     */
    private Object control;
    private int tipoFormulario;
    /**
     * Color personalizado para el fondo de los campos de texto no editables.
     */
    Color colorCielito = new Color(229, 255, 255);

    public static final int TIPO_ALTA = 0;
    public static final int TIPO_ACTUALIZAR = 1;

    /**
     * Crea una nueva ventana FrmInfoEstudiante.
     * Inicializa los componentes de la interfaz grafica.
     * @param control Controlador para la logica de alta de residentes
     * @param tipo
     */
    public FrmInfoEstudiante(Object control, int tipo) {
        super();
        this.control = control;
        tipoFormulario = tipo;
        initComponents();
    }

    public void cargarEstudiante(ResidenteDTO estudiante) {
        String matricula = estudiante.getMatricula();
        String nombreCompleto = estudiante.getNombreCompleto();
        int semestre = estudiante.getSemestre();
        String carrera = estudiante.getCarrera();
        String telefono = estudiante.getTelefono();
        String direccion = estudiante.getDireccion();
        if (control instanceof ControlAltaResidente controlAltaResidente) {
            controlAltaResidente.setResidente(estudiante);
        }

        this.lblNombreResidente.setText(nombreCompleto);
        this.campoTextoID1.setText(matricula);
        this.campoTextoSemestre.setText(Integer.toString(semestre));
        this.campoTextoCarrera.setText(carrera);
        this.campoTextoNum.setText(telefono);
        this.campoTextoDireccion.setText(direccion);

        this.campoTextoID1.setEditable(false);
        this.campoTextoSemestre.setEditable(false);
        this.campoTextoCarrera.setEditable(false);
        this.campoTextoNum.setEditable(false);
        this.campoTextoDireccion.setEditable(false);

        this.campoTextoID1.setBackground(colorCielito);
        this.campoTextoSemestre.setBackground(colorCielito);
        this.campoTextoCarrera.setBackground(colorCielito);
        this.campoTextoNum.setBackground(colorCielito);
        this.campoTextoDireccion.setBackground(colorCielito);
    }
    /**
     * Carga la información del residente en los campos de texto para mostrarla.
     * Configura los campos como no editables y aplica un color de fondo personalizado.
     * @param residente DTO con la información del residente
     */
    public void cargarResidente(ResidenteDTO residente) {
        String matricula = residente.getMatricula();
        String nombreCompleto = residente.getNombreCompleto();
        int semestre = residente.getSemestre();
        String carrera = residente.getCarrera();
        String telefono = residente.getTelefono();
        String direccion = residente.getDireccion();
        String nombreContactoEmergencia = residente.getNombreContactoEmergencia();
        String telefonoContactoEmergencia = residente.getTelefonoContactoEmergencia();
        if (control instanceof ControlActualizarResidente controlActualizarResidente) {
            controlActualizarResidente.setResidente(residente);
        }

        this.lblNombreResidente.setText(nombreCompleto != null ? nombreCompleto : "");
        this.campoTextoID1.setText(matricula != null ? matricula : "");
        this.campoTextoSemestre.setText(Integer.toString(semestre));
        this.campoTextoCarrera.setText(carrera != null ? carrera : "");
        this.campoTextoNum.setText(telefono != null ? telefono : "");
        this.campoTextoDireccion.setText(direccion != null ? direccion : "");
        this.campoTextoNombreContactoEmergencia.setText(nombreContactoEmergencia != null ? nombreContactoEmergencia : "");
        this.campoTextoNumContactoEmergencia.setText(telefonoContactoEmergencia != null ? telefonoContactoEmergencia : "");

        this.campoTextoID1.setEditable(false);
        this.campoTextoSemestre.setEditable(false);
        this.campoTextoCarrera.setEditable(false);
        this.campoTextoNum.setEditable(false);
        this.campoTextoDireccion.setEditable(false);
        this.campoTextoNombreContactoEmergencia.setEditable(true);
        this.campoTextoNumContactoEmergencia.setEditable(true);

        this.campoTextoID1.setBackground(colorCielito);
        this.campoTextoSemestre.setBackground(colorCielito);
        this.campoTextoCarrera.setBackground(colorCielito);
        this.campoTextoNum.setBackground(colorCielito);
        this.campoTextoDireccion.setBackground(colorCielito);
    }

    /**
     * Limpia los campos de texto y los habilita para nueva entrada.
     * Restaura el color de fondo a blanco y elimina cualquier dato previo.
     */
    private void limpiarCampos() {
        this.campoTextoID1.setText("");
        this.campoTextoSemestre.setText("");
        this.campoTextoCarrera.setText("");
        this.campoTextoNum.setText("");
        this.campoTextoDireccion.setText("");
        this.campoTextoNombreContactoEmergencia.setText("");
        this.campoTextoNumContactoEmergencia.setText("");

        this.campoTextoID1.setEnabled(true);
        this.campoTextoSemestre.setEnabled(true);
        this.campoTextoCarrera.setEnabled(true);
        this.campoTextoNum.setEnabled(true);
        this.campoTextoDireccion.setEnabled(true);

        this.campoTextoID1.setBackground(Color.white);
        this.campoTextoSemestre.setBackground(Color.white);
        this.campoTextoCarrera.setBackground(Color.white);
        this.campoTextoNum.setBackground(Color.white);
        this.campoTextoDireccion.setBackground(Color.white);
    }



    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnContinuar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        pnlInfoEstudiante = new javax.swing.JPanel();
        campoTextoID1 = new javax.swing.JTextField();
        campoTextoSemestre = new javax.swing.JTextField();
        campoTextoCarrera = new javax.swing.JTextField();
        pnlLinea = new javax.swing.JPanel();
        campoTextoNum = new javax.swing.JTextField();
        labelID = new javax.swing.JLabel();
        labelID1 = new javax.swing.JLabel();
        labelID2 = new javax.swing.JLabel();
        labelID3 = new javax.swing.JLabel();
        labelID4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        campoTextoDireccion = new javax.swing.JTextField();
        lblNombreResidente = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        campoTextoNombreContactoEmergencia = new javax.swing.JTextField();
        campoTextoNumContactoEmergencia = new javax.swing.JTextField();
        labelID5 = new javax.swing.JLabel();
        labelID6 = new javax.swing.JLabel();
        lblPreview = new javax.swing.JLabel();
        lblLogoResi = new javax.swing.JLabel();
        lblContEemerg = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(37, 55, 95));

        btnContinuar.setBackground(new java.awt.Color(107, 225, 251));
        btnContinuar.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 13)); // NOI18N
        btnContinuar.setForeground(new java.awt.Color(37, 55, 95));
        btnContinuar.setText("Continuar");
        btnContinuar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37, 55, 95)));
        btnContinuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContinuarActionPerformed(evt);
            }
        });

        btnSalir.setBackground(new java.awt.Color(37, 55, 95));
        btnSalir.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 13)); // NOI18N
        btnSalir.setForeground(new java.awt.Color(112, 222, 255));
        btnSalir.setText("Salir");
        btnSalir.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(107, 225, 251), 2, true));
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        pnlInfoEstudiante.setBackground(new java.awt.Color(244, 244, 244));

        campoTextoID1.setFont(new java.awt.Font("Hiragino Maru Gothic ProN", 1, 18)); // NOI18N
        campoTextoID1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoTextoID1ActionPerformed(evt);
            }
        });

        campoTextoSemestre.setFont(new java.awt.Font("Hiragino Maru Gothic ProN", 1, 18)); // NOI18N

        campoTextoCarrera.setFont(new java.awt.Font("Hiragino Maru Gothic ProN", 1, 18)); // NOI18N

        pnlLinea.setBackground(new java.awt.Color(107, 225, 251));
        pnlLinea.setPreferredSize(new java.awt.Dimension(0, 2));

        javax.swing.GroupLayout pnlLineaLayout = new javax.swing.GroupLayout(pnlLinea);
        pnlLinea.setLayout(pnlLineaLayout);
        pnlLineaLayout.setHorizontalGroup(
            pnlLineaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 398, Short.MAX_VALUE)
        );
        pnlLineaLayout.setVerticalGroup(
            pnlLineaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 9, Short.MAX_VALUE)
        );

        campoTextoNum.setFont(new java.awt.Font("Hiragino Maru Gothic ProN", 1, 18)); // NOI18N

        labelID.setFont(new java.awt.Font("Toppan Bunkyu Midashi Gothic", 1, 16)); // NOI18N
        labelID.setForeground(new java.awt.Color(37, 55, 95));
        labelID.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelID.setText("ID estudiante");
        labelID.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        labelID1.setFont(new java.awt.Font("Toppan Bunkyu Midashi Gothic", 1, 16)); // NOI18N
        labelID1.setForeground(new java.awt.Color(37, 55, 95));
        labelID1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelID1.setText("Semestre");
        labelID1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        labelID2.setFont(new java.awt.Font("Toppan Bunkyu Midashi Gothic", 1, 16)); // NOI18N
        labelID2.setForeground(new java.awt.Color(37, 55, 95));
        labelID2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelID2.setText("Carrera");
        labelID2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        labelID3.setFont(new java.awt.Font("Toppan Bunkyu Midashi Gothic", 1, 16)); // NOI18N
        labelID3.setForeground(new java.awt.Color(37, 55, 95));
        labelID3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelID3.setText("Dirección");
        labelID3.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        labelID4.setFont(new java.awt.Font("Toppan Bunkyu Midashi Gothic", 1, 16)); // NOI18N
        labelID4.setForeground(new java.awt.Color(37, 55, 95));
        labelID4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelID4.setText("Número de teléfono");
        labelID4.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jLabel3.setFont(new java.awt.Font("Al Bayan", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 51, 204));
        jLabel3.setText("*La información fue actualizada por última vez: ");

        campoTextoDireccion.setFont(new java.awt.Font("Hiragino Maru Gothic ProN", 1, 18)); // NOI18N

        javax.swing.GroupLayout pnlInfoEstudianteLayout = new javax.swing.GroupLayout(pnlInfoEstudiante);
        pnlInfoEstudiante.setLayout(pnlInfoEstudianteLayout);
        pnlInfoEstudianteLayout.setHorizontalGroup(
            pnlInfoEstudianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlInfoEstudianteLayout.createSequentialGroup()
                .addComponent(pnlLinea, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(pnlInfoEstudianteLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pnlInfoEstudianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(campoTextoDireccion, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelID)
                    .addComponent(labelID1)
                    .addComponent(campoTextoCarrera, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
                    .addComponent(campoTextoID1)
                    .addComponent(labelID2)
                    .addComponent(labelID4)
                    .addComponent(labelID3)
                    .addComponent(campoTextoNum)
                    .addComponent(campoTextoSemestre))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlInfoEstudianteLayout.setVerticalGroup(
            pnlInfoEstudianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInfoEstudianteLayout.createSequentialGroup()
                .addComponent(pnlLinea, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(labelID, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoTextoID1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelID1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoTextoSemestre, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelID2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoTextoCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelID3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoTextoDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(labelID4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoTextoNum, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addContainerGap())
        );

        lblNombreResidente.setFont(new java.awt.Font("Apple LiGothic", 0, 60)); // NOI18N
        lblNombreResidente.setForeground(new java.awt.Color(245, 253, 255));
        lblNombreResidente.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblNombreResidente.setText("Nombre del Estudiante");
        lblNombreResidente.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jPanel2.setBackground(new java.awt.Color(27, 44, 87));

        campoTextoNombreContactoEmergencia.setFont(new java.awt.Font("Hiragino Maru Gothic ProN", 1, 18)); // NOI18N

        campoTextoNumContactoEmergencia.setFont(new java.awt.Font("Hiragino Maru Gothic ProN", 1, 18)); // NOI18N

        labelID5.setFont(new java.awt.Font("Toppan Bunkyu Midashi Gothic", 1, 16)); // NOI18N
        labelID5.setForeground(new java.awt.Color(242, 242, 242));
        labelID5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelID5.setText("Número de teléfono");
        labelID5.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        labelID6.setFont(new java.awt.Font("Toppan Bunkyu Midashi Gothic", 1, 16)); // NOI18N
        labelID6.setForeground(new java.awt.Color(242, 242, 242));
        labelID6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelID6.setText("Nombre completo");
        labelID6.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelID6)
                    .addComponent(labelID5)
                    .addComponent(campoTextoNumContactoEmergencia, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoTextoNombreContactoEmergencia, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(labelID6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoTextoNombreContactoEmergencia, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(labelID5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(campoTextoNumContactoEmergencia, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13))
        );

        lblPreview.setFont(new java.awt.Font("Apple LiGothic", 0, 24)); // NOI18N
        lblPreview.setForeground(new java.awt.Color(245, 253, 255));
        lblPreview.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblPreview.setText("Preview del residente");
        lblPreview.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        lblLogoResi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Logotipo Residencias Estudiantiles Horizontal.png"))); // NOI18N

        lblContEemerg.setFont(new java.awt.Font("Apple LiGothic", 0, 24)); // NOI18N
        lblContEemerg.setForeground(new java.awt.Color(107, 225, 251));
        lblContEemerg.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblContEemerg.setText("Contacto de emergencia");
        lblContEemerg.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jLabel4.setFont(new java.awt.Font("Al Bayan", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Llene el formulario con los datos del contacto de emergencia");

        jLabel5.setFont(new java.awt.Font("Al Bayan", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("del estudiante.");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblNombreResidente, javax.swing.GroupLayout.PREFERRED_SIZE, 539, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblLogoResi, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPreview, javax.swing.GroupLayout.PREFERRED_SIZE, 446, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(pnlInfoEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(59, 59, 59)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(205, 205, 205)
                                                .addComponent(jLabel2))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(btnContinuar, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(6, 6, 6))))
                                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblContEemerg, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(68, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLogoResi, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblNombreResidente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblPreview)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(lblContEemerg)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(397, 397, 397)
                                .addComponent(jLabel2)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnContinuar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(50, 50, 50))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pnlInfoEstudiante, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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

    /**
     * Maneja el evento del boton Continuar.
     * Valida el numero de contacto de emergencia (10 digitos) y actualiza el residente con los datos
     * de contacto de emergencia antes de avanzar a la seleccion del tipo de residente.
     * Muestra un mensaje de error si la validacion falla.
     * @param evt Evento de accion del boton
     */
    private void btnContinuarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnContinuarActionPerformed
        try {
            String nombreContactoEmergencia = this.campoTextoNombreContactoEmergencia.getText().trim();
            String numContactoEmergencia = this.campoTextoNumContactoEmergencia.getText().trim();
            if (!numContactoEmergencia.matches("^\\d{10}$")) {
                throw new Exception("El número de contacto de emergencia debe tener 10 dígitos");
            }
            if (tipoFormulario == TIPO_ALTA && control instanceof ControlAltaResidente) {
                ((ControlAltaResidente) control).getResidente().setNombreContactoEmergencia(nombreContactoEmergencia);
                ((ControlAltaResidente) control).getResidente().setTelefonoContactoEmergencia(numContactoEmergencia);
                ((ControlAltaResidente) control).mostrarTipoResidente();
            }
            if (tipoFormulario == TIPO_ACTUALIZAR && control instanceof ControlActualizarResidente) {
                ((ControlActualizarResidente) control).getResidente().setNombreContactoEmergencia(nombreContactoEmergencia);
                ((ControlActualizarResidente) control).getResidente().setTelefonoContactoEmergencia(numContactoEmergencia);
                ((ControlActualizarResidente) control).mostrarTipoResidente();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(
                this,
                ex.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE
            );
        }

    }// GEN-LAST:event_btnContinuarActionPerformed

    /**
     * Maneja el evento del boton Salir.
     * Limpia los campos, elimina el residente del controlador y regresa a la pantalla
     * para ingresar el ID del estudiante.
     * @param evt Evento de accion del boton
     */
    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnSalirActionPerformed
        limpiarCampos();
        if (tipoFormulario == 0 && control instanceof ControlAltaResidente) {
            ((ControlAltaResidente) control).setResidente(null);
            ((ControlAltaResidente) control).volverIngresarIDEstudiante();
        } else if (tipoFormulario == 1 && control instanceof ControlActualizarResidente) {
            ((ControlActualizarResidente) control).acabarCaso(); 
        }
    }// GEN-LAST:event_btnSalirActionPerformed

    /**
     * Maneja el evento de accion del campo de texto ID.
     * @param evt Evento de accion del campo de texto
     */
    private void campoTextoID1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_campoTextoID1ActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_campoTextoID1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnContinuar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JTextField campoTextoCarrera;
    private javax.swing.JTextField campoTextoDireccion;
    private javax.swing.JTextField campoTextoID1;
    private javax.swing.JTextField campoTextoNombreContactoEmergencia;
    private javax.swing.JTextField campoTextoNum;
    private javax.swing.JTextField campoTextoNumContactoEmergencia;
    private javax.swing.JTextField campoTextoSemestre;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel labelID;
    private javax.swing.JLabel labelID1;
    private javax.swing.JLabel labelID2;
    private javax.swing.JLabel labelID3;
    private javax.swing.JLabel labelID4;
    private javax.swing.JLabel labelID5;
    private javax.swing.JLabel labelID6;
    private javax.swing.JLabel lblContEemerg;
    private javax.swing.JLabel lblLogoResi;
    private javax.swing.JLabel lblNombreResidente;
    private javax.swing.JLabel lblPreview;
    private javax.swing.JPanel pnlInfoEstudiante;
    private javax.swing.JPanel pnlLinea;
    // End of variables declaration//GEN-END:variables
}
