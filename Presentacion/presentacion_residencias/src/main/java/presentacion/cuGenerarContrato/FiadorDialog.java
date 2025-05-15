///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package presentacion.cuGenerarContrato;
//
///**
// *
// * @author abrilislas
// */
//import control.ControlGenerarContrato;
//import javax.swing.*;
//import java.awt.event.*;
//
//public class FiadorDialog {
//    ControlGenerarContrato control;
//    public FiadorDialog(ControlGenerarContrato control){
//        this.control=control;
//    }
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(() -> {
//            String mensaje = "Se ha encontrado un fiador, ¿Quieres renovarlo o generar contrato con el fiador actual?";
//            String titulo = "Fiador encontrado";
//
//            Object[] opciones = {"Renovar", "Generar contrato"};
//            int eleccion = JOptionPane.showOptionDialog(
//                null,
//                mensaje,
//                titulo,
//                JOptionPane.DEFAULT_OPTION,
//                JOptionPane.QUESTION_MESSAGE,
//                null,
//                opciones,
//                opciones[0]
//            );
//
//         /*   if (eleccion == 0) {
//                control.registrarFiador(fiadorDTO, residenteDTO);
//            } else if (eleccion == 1) {
//                control.generarContratoPDF();
//            }
//        });*/
//    }
//}
//
