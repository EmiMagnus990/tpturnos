package view;

import javax.swing.*;
import java.awt.*;

public class RecordatorioView extends JFrame {

    public JList<String> listaRecordatorios;
    public JButton btnCerrar;

    public RecordatorioView() {
        setTitle("🔔 Recordatorios");
        setSize(450, 300);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        listaRecordatorios = new JList<>(new String[]{"No hay recordatorios"});
        listaRecordatorios.setFont(new Font("Arial", Font.PLAIN, 18));

        add(new JScrollPane(listaRecordatorios), BorderLayout.CENTER);

        btnCerrar = new JButton("Cerrar");
        btnCerrar.setFont(new Font("Arial", Font.BOLD, 18));
        btnCerrar.addActionListener(e -> dispose());

        JPanel pnlSur = new JPanel();
        pnlSur.setLayout(new FlowLayout(FlowLayout.RIGHT));
        pnlSur.add(btnCerrar);

        add(pnlSur, BorderLayout.SOUTH);
    }

}
