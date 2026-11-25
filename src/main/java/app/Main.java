package app;

import controlador.ControladorVetCare;
import modelo.ClinicaVet;
import vista.VentanaVetCare;

public class Main {
    public static void main(String[] args) {
        ClinicaVet modelo = new ClinicaVet();
        VentanaVetCare vista = new VentanaVetCare();
        ControladorVetCare controlador = new ControladorVetCare(modelo, vista);
        controlador.iniciar();
    }
}
