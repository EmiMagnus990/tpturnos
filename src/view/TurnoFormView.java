package view;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.text.SimpleDateFormat;

public class TurnoFormView extends JFrame {

    public JTextField txtPaciente;
    public JComboBox<String> cmbMedico;
    public JFormattedTextField txtFecha;
    public JFormattedTextField txtHora;
    public JButton btnGuardar;

    public TurnoFormView() {

        setTitle("➕ Agendar Turno");
        setSize(500, 520);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        Color fondo = new Color(14,29,54);
        Color blanco = Color.WHITE;

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(fondo);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15,15,15,15);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;

        Font labelFont = new Font("Arial", Font.BOLD, 20);
        Font inputFont = new Font("Arial", Font.PLAIN, 18);

        // ──────────────────────────── TÍTULO
        JLabel titulo = new JLabel("Registrar Nuevo Turno", SwingConstants.CENTER);
        titulo.setForeground(blanco);
        titulo.setFont(new Font("Arial", Font.BOLD, 28));
        gbc.gridy = 0;
        panel.add(titulo, gbc);

        // 📍 PACIENTE
        gbc.gridy++;
        panel.add(label("Paciente:", labelFont, blanco), gbc);
        gbc.gridy++;
        txtPaciente = campo(inputFont, blanco, fondo);
        panel.add(txtPaciente, gbc);

        // 📍 MÉDICO
        gbc.gridy++;
        panel.add(label("Médico:", labelFont, blanco), gbc);
        gbc.gridy++;
        cmbMedico = new JComboBox<>(new String[]{"Dr. Pérez", "Dra. López", "Dr. Martinez"});
        estiloCombo(cmbMedico,inputFont,blanco,fondo);
        panel.add(cmbMedico, gbc);

        // 📅 FECHA AUTOMÁTICA + VALIDADA
        gbc.gridy++;
        panel.add(label("Fecha (dd/mm/aaaa):", labelFont, blanco), gbc);
        gbc.gridy++;

        try {
            MaskFormatter m = new MaskFormatter("##/##/####");
            m.setPlaceholderCharacter('_');
            txtFecha = new JFormattedTextField(m);
        } catch(Exception e){ txtFecha=new JFormattedTextField(); }

        estiloCampo(txtFecha,inputFont,blanco,fondo);
        panel.add(txtFecha, gbc);

        // ⏰ HORA AUTOMÁTICA HH:MM
        gbc.gridy++;
        panel.add(label("Hora (hh:mm):", labelFont, blanco), gbc);
        gbc.gridy++;

        try{
            MaskFormatter h = new MaskFormatter("##:##");
            h.setPlaceholderCharacter('_');
            txtHora = new JFormattedTextField(h);
        } catch(Exception e){ txtHora=new JFormattedTextField(); }

        estiloCampo(txtHora,inputFont,blanco,fondo);
        panel.add(txtHora,gbc);

        // 💾 BOTÓN GUARDAR + VALIDACIONES
        gbc.gridy++;
        btnGuardar = boton("💾 Guardar", blanco, fondo, inputFont);
        panel.add(btnGuardar, gbc);

        btnGuardar.addActionListener(e -> validarContenido());

        // Scroll
        JScrollPane scroll = new JScrollPane(panel);
        scroll.setBorder(null);
        setContentPane(scroll);
    }

    // ─────────────────────────── VALIDACIONES

    private void validarContenido(){

        if(!validarFecha(txtFecha.getText())){
            mensaje("❌ Fecha inválida.");
            txtFecha.requestFocus();
            return;
        }

        if(!validarHora(txtHora.getText())){
            mensaje("❌ Hora inválida.");
            txtHora.requestFocus();
            return;
        }

        mensaje("✔ Turno registrado correctamente");
    }

    private boolean validarFecha(String f){
        try {
            SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            df.setLenient(false);
            df.parse(f);
            return true;
        }catch(Exception e){ return false; }
    }

    private boolean validarHora(String h){
        return h.matches("([01][0-9]|2[0-3]):[0-5][0-9]");
    }

    private void mensaje(String msg){
        JOptionPane.showMessageDialog(this,msg,"Validación",JOptionPane.INFORMATION_MESSAGE);
    }

    // ─────────────────────────── ESTILO VISUAL

    private JLabel label(String txt,Font f, Color c){
        JLabel l=new JLabel(txt);
        l.setFont(f);
        l.setForeground(c);
        return l;
    }

    private void estiloCampo(JFormattedTextField t,Font f,Color letra,Color fondo){
        t.setFont(f);
        t.setBackground(fondo);
        t.setForeground(letra);
        t.setBorder(BorderFactory.createLineBorder(letra,2,true));
    }

    private JTextField campo(Font f,Color letra,Color fondo){
        JTextField t=new JTextField();
        t.setFont(f);
        t.setForeground(letra);
        t.setBackground(fondo);
        t.setBorder(BorderFactory.createLineBorder(letra,2,true));
        return t;
    }

    private JButton boton(String text,Color blanco,Color fondo,Font f){
        JButton b=new JButton(text);
        b.setFont(f);
        b.setBackground(fondo);
        b.setForeground(blanco);
        b.setBorder(BorderFactory.createLineBorder(blanco,2,true));

        b.addMouseListener(new java.awt.event.MouseAdapter(){
            public void mouseEntered(java.awt.event.MouseEvent e){ b.setBackground(blanco); b.setForeground(fondo); }
            public void mouseExited (java.awt.event.MouseEvent e){ b.setBackground(fondo); b.setForeground(blanco); }
        });
        return b;
    }

    private void estiloCombo(JComboBox<?> c,Font f,Color w,Color fnd){
        c.setFont(f);
        c.setForeground(w);
        c.setBackground(fnd);
        c.setBorder(BorderFactory.createLineBorder(w,2,true));
    }
}
