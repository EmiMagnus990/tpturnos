package view;

import javax.swing.*;
import java.awt.*;

public class ListaTurnosView extends JFrame {

    public JTable tablaTurnos;
    public JButton btnActualizar;

    public ListaTurnosView() {
        setTitle("📅 Turnos Registrados");
        setSize(650, 400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Columnas de la tabla
        String[] columnas = {"Paciente", "Médico", "Fecha", "Hora", "Estado"};
        Object[][] datos = {}; // luego los cargará tu compañero

        tablaTurnos = new JTable(datos, columnas);
        tablaTurnos.setFont(new Font("Arial", Font.PLAIN, 18));
        tablaTurnos.setRowHeight(28);

        add(new JScrollPane(tablaTurnos), BorderLayout.CENTER);

        btnActualizar = new JButton("🔄 Actualizar");
        btnActualizar.setFont(new Font("Arial", Font.BOLD, 22));
        btnActualizar.setBackground(new Color(120,160,255));
        btnActualizar.setForeground(Color.WHITE);

        add(btnActualizar, BorderLayout.SOUTH);
    }
}
