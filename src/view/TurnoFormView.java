package view;

import javax.swing.*;
import java.awt.*;

public class TurnoFormView extends JFrame {

    public JTextField txtPaciente;
    public JComboBox<String> cmbMedico;
    public JTextField txtFecha;
    public JTextField txtHora;
    public JButton btnGuardar;

    public TurnoFormView() {

        setTitle("➕ Agendar Turno");
        setSize(450, 400);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 2, 15, 15));  // Espaciado grande ✔
        getContentPane().setBackground(new Color(235, 245, 255)); // Fondo suave ✔

        // Tipografías accesibles
        Font labelFont = new Font("Arial", Font.BOLD, 22);
        Font inputFont = new Font("Arial", Font.PLAIN, 20);

        // ----- CAMPOS -----
        add(crearLabel("Paciente:", labelFont));
        txtPaciente = new JTextField();
        txtPaciente.setFont(inputFont);
        add(txtPaciente);

        add(crearLabel("Médico:", labelFont));
        cmbMedico = new JComboBox<>(new String[]{"Dr. Pérez", "Dra. López"});
        cmbMedico.setFont(inputFont);
        add(cmbMedico);

        add(crearLabel("Fecha (dd/mm/aaaa):", labelFont));
        txtFecha = new JTextField();
        txtFecha.setFont(inputFont);
        add(txtFecha);

        add(crearLabel("Hora (hh:mm):", labelFont));
        txtHora = new JTextField();
        txtHora.setFont(inputFont);
        add(txtHora);

        // ----- BOTÓN GUARDAR -----
        btnGuardar = new JButton("💾 Guardar Turno");
        btnGuardar.setFont(new Font("Arial", Font.BOLD, 24));
        btnGuardar.setBackground(new Color(90, 180, 120)); // verde accesible
        btnGuardar.setForeground(Color.WHITE);

        add(new JLabel(""));
        add(btnGuardar);
    }

    private JLabel crearLabel(String texto, Font font){
        JLabel label = new JLabel(texto);
        label.setFont(font);
        return label;
    }
}
