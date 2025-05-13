/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion;

import javax.swing.JFrame;

/**
 * Clase base para ventanas de la aplicacion.
 * Establece un tamano predeterminado, centra la ventana, deshabilita el redimensionamiento y configura el cierre del sistema al cerrar la ventana.
 * @author abrilislas
 */
public class JFrameBase extends JFrame{
    
        /**
        * Crea una nueva ventana con configuraciones predeterminadas.
        * Establece un tamano de 911x634 pixeles, centra la ventana en la pantalla, deshabilita el redimensionamiento y configura el cierre del sistema al cerrar la ventana.
        */
        public JFrameBase() {
        // Tamaño predeterminado
        this.setSize(911, 634);
        // No permitir redimensionar
        this.setResizable(false);
        // Centrar en pantalla
        this.setLocationRelativeTo(null);

        // Cerrar el sistema al cerrar la ventana
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
