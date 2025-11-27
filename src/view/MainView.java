package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainView extends JFrame {

    public JButton btnAgendar, btnVerTurnos, btnRecordatorios;

    public MainView() {

        setTitle("Gestión de Turnos Médicos");
        setSize(550, 420);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 🔵 Fondo azul oscuro (principal)
        Color fondoOscuro = new Color(14, 29, 54);
        getContentPane().setBackground(fondoOscuro);

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(18,18,18,18); 
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;

        // 🎨 Blanco para contraste
        Color blanco = Color.WHITE;

        Font fontTitulo = new Font("Arial", Font.BOLD, 30);
        Font fontBoton = new Font("Arial", Font.PLAIN, 22);

        // 🔹 Título centrado
        JLabel titulo = new JLabel("Sistema de Turnos Médicos", SwingConstants.CENTER);
        titulo.setFont(fontTitulo);
        titulo.setForeground(blanco);
        gbc.gridy = 0;
        add(titulo, gbc);

        // Botones elegantes blancos sobre fondo oscuro
        gbc.gridy++;
        btnAgendar = boton("➕ Agendar Turno", fontBoton, blanco);
        add(btnAgendar, gbc);

        gbc.gridy++;
        btnVerTurnos = boton("📅 Ver Turnos", fontBoton, blanco);
        add(btnVerTurnos, gbc);

        gbc.gridy++;
        btnRecordatorios = boton("🔔 Recordatorios", fontBoton, blanco);
        add(btnRecordatorios, gbc);

        // Navegación
        btnAgendar.addActionListener(e -> new TurnoFormView().setVisible(true));
        btnVerTurnos.addActionListener(e -> new ListaTurnosView().setVisible(true));
        btnRecordatorios.addActionListener(e -> new RecordatorioView().setVisible(true));
    }

    // 🟦 Método para botones blancos con borde
    private JButton boton(String texto, Font font, Color blanco){
        JButton b = new JButton(texto);
        b.setFont(font);
        b.setBackground(new Color(14, 29, 54)); // fondo combina con la interfaz
        b.setForeground(blanco);
        b.setBorder(BorderFactory.createLineBorder(blanco,2,true));
        b.setFocusPainted(false);
        b.setPreferredSize(new Dimension(350,60));
        b.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Hover blanco ✨
        b.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent e){
                b.setBackground(blanco);
                b.setForeground(new Color(14, 29, 54));
            }
            public void mouseExited(MouseEvent e){
                b.setBackground(new Color(14, 29, 54));
                b.setForeground(blanco);
            }
        });

        return b;
    }

    public static void main(String[] args){
        new MainView().setVisible(true);
    }
}