package vista;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

public class VentanaVetCare extends JFrame {
    
    public JButton btnCrearEspacios;
    
    public JTextField txtCodMascota;
    public JTextField txtNombreMascota;
    public JTextField txtTipoMascota;
    public JTextField txtPesoMascota;
    public JTextField txtCodEspacio;
    public JButton btnRegistrarIngreso;
    
    public JTextField txtEspacioAfectado;
    public JButton btnReubicar;
    
    public JTextArea txtResultados;

    public VentanaVetCare() {
        setTitle("VETCARE - Control de Hospitalización");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panelIzquierdo = new JPanel();
        panelIzquierdo.setPreferredSize(new Dimension(350, 500));
        panelIzquierdo.setLayout(null);

        // RF1
        JPanel panelRF1 = new JPanel();
        panelRF1.setBorder(new TitledBorder("RF1. Espacios de hospitalizacion"));
        panelRF1.setBounds(10, 10, 330, 70);
        
        btnCrearEspacios = new JButton("Crear espacios");
        panelRF1.add(btnCrearEspacios);
        
        // RF2
        JPanel panelRF2 = new JPanel();
        panelRF2.setBorder(new TitledBorder("RF2. Registro de ingreso de mascota"));
        panelRF2.setBounds(10, 90, 330, 220);
        panelRF2.setLayout(new GridLayout(6, 2, 5, 10));
        
        txtCodMascota = new JTextField();
        txtNombreMascota = new JTextField();
        txtTipoMascota = new JTextField();
        txtPesoMascota = new JTextField();
        txtCodEspacio = new JTextField();
        btnRegistrarIngreso = new JButton("Registrar ingreso");

        panelRF2.add(new JLabel("Codigo mascota:"));
        panelRF2.add(txtCodMascota);
        panelRF2.add(new JLabel("Nombre mascota:"));
        panelRF2.add(txtNombreMascota);
        panelRF2.add(new JLabel("Tipo (Perro / Gato):"));
        panelRF2.add(txtTipoMascota);
        panelRF2.add(new JLabel("Peso (kg):"));
        panelRF2.add(txtPesoMascota);
        panelRF2.add(new JLabel("Codigo espacio:"));
        panelRF2.add(txtCodEspacio);
        panelRF2.add(new JLabel(""));
        panelRF2.add(btnRegistrarIngreso);

        // RF3
        JPanel panelRF3 = new JPanel();
        panelRF3.setBorder(new TitledBorder("RF3. Reubicacion por mantenimiento"));
        panelRF3.setBounds(10, 320, 330, 100);
        panelRF3.setLayout(new GridLayout(2, 2, 5, 10));
        
        txtEspacioAfectado = new JTextField();
        btnReubicar = new JButton("Reubicar mascota");
        
        panelRF3.add(new JLabel("Codigo espacio afectado:"));
        panelRF3.add(txtEspacioAfectado);
        panelRF3.add(new JLabel(""));
        panelRF3.add(btnReubicar);

        panelIzquierdo.add(panelRF1);
        panelIzquierdo.add(panelRF2);
        panelIzquierdo.add(panelRF3);

        // Resultados
        JPanel panelDerecho = new JPanel();
        panelDerecho.setBorder(new TitledBorder("Resultados de las operaciones"));
        panelDerecho.setLayout(new BorderLayout());
        
        txtResultados = new JTextArea();
        txtResultados.setEditable(false);
        JScrollPane scroll = new JScrollPane(txtResultados);
        
        panelDerecho.add(scroll, BorderLayout.CENTER);

        add(panelIzquierdo, BorderLayout.WEST);
        add(panelDerecho, BorderLayout.CENTER);
    }
}

