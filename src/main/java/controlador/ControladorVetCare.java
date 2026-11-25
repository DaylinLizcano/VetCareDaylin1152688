package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.ClinicaVet;
import vista.VentanaVetCare;

public class ControladorVetCare implements ActionListener {

    private ClinicaVet modelo;
    private VentanaVetCare vista;

    public ControladorVetCare(ClinicaVet modelo, VentanaVetCare vista) {
        this.modelo = modelo;
        this.vista = vista;
          
        this.vista.btnCrearEspacios.addActionListener(this);
        this.vista.btnRegistrarIngreso.addActionListener(this);
        this.vista.btnReubicar.addActionListener(this);
    }

    public void iniciar() {
        vista.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        // RF1: Crear espacios
        if (e.getSource() == vista.btnCrearEspacios) {
            String resultado = modelo.crearEspaciosHospitalizacion();
            vista.txtResultados.append(resultado + "\n\n");
        }
        
        // RF2: Registrar ingreso
        if (e.getSource() == vista.btnRegistrarIngreso) {
            String codigo = vista.txtCodMascota.getText();
            String nombre = vista.txtNombreMascota.getText();
            String tipo = vista.txtTipoMascota.getText();
            int peso = Integer.parseInt(vista.txtPesoMascota.getText());
            String codEspacio = vista.txtCodEspacio.getText();

            String resultado = modelo.registrarIngreso(codigo, nombre, tipo, peso, codEspacio);
            vista.txtResultados.append(resultado + "\n\n");
        }
        
        // RF3: Reubicar por mantenimiento
        if (e.getSource() == vista.btnReubicar) {
            String codEspacio = vista.txtEspacioAfectado.getText();
            
            String resultado = modelo.reubicarMascota(codEspacio);
            vista.txtResultados.append(resultado + "\n\n");
        }
    }
}