/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegodados;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Transparency;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Bryant
 */
public class GuiBienvenida extends JFrame implements ActionListener {
    private Jugador jug1;
    private JPanel panelBienvenido;
    private JLabel lbBienvenida;
    private JLabel NombreUsuario;
    private JLabel SaldoUsuario;
    private JLabel ContadorJugadas;
    private JLabel ContadorJugadasGana;
    private JLabel ContadorJugadasPierde;
    private JButton btnJugar;
    private JButton btnCambiarSaldo;
    private JButton btnCerrarSesion;
    private JTextField txtSaldo;
    private JTextField txtAposta;
    private JLabel lbApostar;
    private DatosArchivo archivos;
    public GuiBienvenida(Jugador jug1){
        Font fuenteTituloG = new Font("", Font.BOLD, 24);
        this.jug1 = jug1;
        archivos = new DatosArchivo();
        panelBienvenido = new JPanel();
        panelBienvenido.setBackground(Color.DARK_GRAY);
        lbBienvenida = new JLabel("Juego de Dados");
        lbBienvenida.setForeground(Color.WHITE);
        NombreUsuario = new JLabel(jug1.getNombre());
        NombreUsuario.setForeground(Color.WHITE);
        SaldoUsuario = new JLabel("Saldo Actual: ");
        SaldoUsuario.setForeground(Color.WHITE);
        ContadorJugadas = new JLabel("Total de Juegos: "+String.valueOf(jug1.getJuegosGanados() + jug1.getJuegosPerdidos()));
        ContadorJugadas.setForeground(Color.WHITE);
        ContadorJugadasGana = new JLabel("Total de Partidas Ganadas: "+String.valueOf(jug1.getJuegosGanados()));
        ContadorJugadasGana.setForeground(Color.WHITE);
        ContadorJugadasPierde = new JLabel("Total de Partidas Perdidas : "+String.valueOf(jug1.getJuegosPerdidos()));
        ContadorJugadasPierde.setForeground(Color.WHITE);
        btnJugar = new JButton("Jugar");
        btnJugar.setBackground(java.awt.Color.LIGHT_GRAY);
        btnJugar.setForeground(Color.WHITE);
        
        btnCambiarSaldo = new JButton(new ImageIcon("src/resource/BotonEditar.png"));
        btnCambiarSaldo.setBackground(java.awt.Color.LIGHT_GRAY);
        btnCambiarSaldo.setForeground(Color.WHITE);
        btnCerrarSesion = new JButton(new ImageIcon("src/resource/cerrar.png"));
        btnCerrarSesion.setBackground(java.awt.Color.LIGHT_GRAY);
        btnCerrarSesion.setForeground(Color.WHITE);
        txtSaldo = new JTextField(String.valueOf(jug1.getSaldo()));
        lbApostar = new JLabel("Valor a apostar?");
        lbApostar.setForeground(Color.WHITE);
        txtAposta = new JTextField("100");
        this.getContentPane().setLayout(null);
        this.setBounds(100, 100, 250, 400);
        this.getContentPane().add(panelBienvenido);
           
        panelBienvenido.setBounds(0, 0, 250, 400);
        panelBienvenido.setLayout(null);
        
        panelBienvenido.add(lbBienvenida);
        lbBienvenida.setBounds(15, 15, 220, 30);
        lbBienvenida.setHorizontalAlignment(JLabel.CENTER);
        lbBienvenida.setFont(fuenteTituloG);
        
        panelBienvenido.add(NombreUsuario);
        NombreUsuario.setBounds(15, 45, 220, 30);
        NombreUsuario.setHorizontalAlignment(JLabel.CENTER);
        NombreUsuario.setFont(fuenteTituloG);
        
        panelBienvenido.add(SaldoUsuario);
        SaldoUsuario.setBounds(15, 100, 80, 30);
        
        panelBienvenido.add(txtSaldo);
        txtSaldo.setBounds(95, 100, 75, 30);
        
        panelBienvenido.add(btnCambiarSaldo);
        btnCambiarSaldo.setBounds(190, 100, 30, 30);
        btnCambiarSaldo.setBorder(null);
        btnCambiarSaldo.setContentAreaFilled(false);
        btnCambiarSaldo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        
        panelBienvenido.add(ContadorJugadas);
        ContadorJugadas.setBounds(15, 130, 220, 30);
        panelBienvenido.add(ContadorJugadasGana);
        ContadorJugadasGana.setBounds(15, 160, 220, 30);
        panelBienvenido.add(ContadorJugadasPierde);
        ContadorJugadasPierde.setBounds(15, 190, 220, 30);
        
        
        panelBienvenido.add(btnCerrarSesion);
        btnCerrarSesion.setBounds(200, 330, 30, 30);
        btnCerrarSesion.setBorder(null);
        btnCerrarSesion.setContentAreaFilled(false);
        btnCerrarSesion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        
        panelBienvenido.add(lbApostar);
        lbApostar.setBounds(15, 230, 100, 30);
        
        panelBienvenido.add(txtAposta);
        txtAposta.setBounds(115, 230, 120, 30);
        
        panelBienvenido.add(btnJugar);
        btnJugar.setBounds(15, 260, 220, 50);
        btnJugar.setFont(fuenteTituloG);
        
        this.setTitle("Juego Dados");
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        btnJugar.setActionCommand("jugar");
        btnJugar.addActionListener(this);
        btnCambiarSaldo.addActionListener(this);
        btnCambiarSaldo.setActionCommand("cambiarSaldo");
        
        btnCerrarSesion.addActionListener(this);
        btnCerrarSesion.setActionCommand("cerrarSesion");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("jugar")){
            this.dispose();
            Juego juego = new Juego(this.jug1, Integer.parseInt(this.txtAposta.getText()));
            GuiJugar jugar = new GuiJugar(juego);
        }
        else if(e.getActionCommand().equals("cambiarSaldo")){
            ControlArchivo res = archivos.cambiarSaldo(this.jug1, Integer.parseInt(txtSaldo.getText()));
            if(!res.getRespuesta()){
                JOptionPane.showMessageDialog(null, res.getMensaje(), "Error", JOptionPane.ERROR_MESSAGE);
            }
            else{
                JOptionPane.showMessageDialog(null, "Saldo modificado satisfactoriamente", "Saldo Modificado", JOptionPane.DEFAULT_OPTION);
            }
        }
        else if(e.getActionCommand().equals("cerrarSesion")){
            this.dispose();
            GuiJuego inicio = new GuiJuego();
        }
    }
    
    
    
    
    
}
