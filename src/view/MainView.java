package view;

import javax.swing.*;
import java.awt.*;

public class MainView extends JFrame {

    public JButton btnAgendar;
    public JButton btnVerTurnos;
    public JButton btnRecordatorios;

    public MainView() {
        setTitle("Gestión de Turnos Médicos - Accesible");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 1, 15, 15)); // 3 botones grandes

        // Estilo accesible
        Font font = new Font("Arial", Font.BOLD, 24);

        btnAgendar = new JButton("➕ Agendar Turno");
        btnAgendar.setFont(font);

        btnVerTurnos = new JButton("📅 Ver Turnos");
        btnVerTurnos.setFont(font);

        btnRecordatorios = new JButton("🔔 Recordatorios");
        btnRecordatorios.setFont(font);

        add(btnAgendar);
        add(btnVerTurnos);
        add(btnRecordatorios);

        // ≡≡≡ EVENTOS DE NAVEGACIÓN (solo interfaz, sin lógica) ≡≡≡
        btnAgendar.addActionListener(e -> new TurnoFormView().setVisible(true));
        btnVerTurnos.addActionListener(e -> new ListaTurnosView().setVisible(true));
        btnRecordatorios.addActionListener(e -> new RecordatorioView().setVisible(true));
    }

    public static void main(String[] args) {
        new MainView().setVisible(true);
    }
}
