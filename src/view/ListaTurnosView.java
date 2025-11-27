package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import controller.TurnoController;

public class ListaTurnosView extends JFrame {

    public JTable tablaTurnos;
    public JButton btnActualizar;

    private TurnoController controller;

    public ListaTurnosView() {

        controller = new TurnoController();

        setTitle("📅 Turnos Registrados");
        setSize(650, 400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        String[] columnas = {"Paciente", "Médico", "Fecha", "Hora", "Estado"};
        Object[][] datos = {};

        tablaTurnos = new JTable(datos, columnas);
        tablaTurnos.setFont(new Font("Arial", Font.PLAIN, 18));
        tablaTurnos.setRowHeight(28);
        add(new JScrollPane(tablaTurnos), BorderLayout.CENTER);

        btnActualizar = new JButton("🔄 Actualizar");
        btnActualizar.setFont(new Font("Arial", Font.BOLD, 22));
        btnActualizar.setBackground(new Color(120,160,255));
        btnActualizar.setForeground(Color.WHITE);
        add(btnActualizar, BorderLayout.SOUTH);

        btnActualizar.addActionListener(e -> actualizarTabla());
    }

    private void actualizarTabla() {

        var lista = controller.listarTurnos();
        String[][] data = new String[lista.size()][5];

        for (int i = 0; i < lista.size(); i++) {
            var t = lista.get(i);
            data[i][0] = t.getPaciente().getNombre();
            data[i][1] = t.getMedico().getNombre();
            data[i][2] = t.getFecha().toString();
            data[i][3] = t.getHora().toString();
            data[i][4] = t.getEstado();
        }

        tablaTurnos.setModel(new DefaultTableModel(
                data,
                new String[]{"Paciente", "Médico", "Fecha", "Hora", "Estado"}
        ));
    }
}