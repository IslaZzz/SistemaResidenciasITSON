/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion;

import javax.swing.JFrame;

/**
 *
 * @author abrilislas
 */
public class JFrameBase extends JFrame{
    
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
