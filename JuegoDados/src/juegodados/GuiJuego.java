/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegodados;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Estudiantes
 */
public class GuiJuego extends JFrame implements ActionListener {
    private DatosArchivo archivos;
    private JPanel panelInicio;
    private JLabel TituloJuego;
    private JLabel UsuarioInicio;
    private JLabel ContraseñaInicio;
    private JLabel lbFirma;
    private JLabel lbCodigo;
    private JTextField txtUsuarioInicio;
    private JPasswordField txtPassInicio;
    private JButton BotonIngresar;
    private JButton BotonRegistroInicio;
    private ImageIcon imgInicio;
    private JLabel lbImgInicio;
  

    public GuiJuego(){
        archivos = new DatosArchivo();
        Font fuenteTituloG = new Font("", Font.BOLD, 24);
        panelInicio = new JPanel();
        panelInicio.setBackground(Color.DARK_GRAY);
        imgInicio = new ImageIcon("src/resource/dadosInicio.png");
        lbImgInicio = new JLabel(imgInicio);
        TituloJuego = new JLabel("Juego Dados");
        TituloJuego.setForeground(Color.RED);
        UsuarioInicio = new JLabel("Usuario");
        UsuarioInicio.setForeground(Color.WHITE);
        ContraseñaInicio = new JLabel("Contraseña");
        ContraseñaInicio.setForeground(Color.WHITE);
        lbFirma = new JLabel("Carlos Julian Robayo Rojas");
        lbFirma.setForeground(Color.WHITE);
        lbCodigo = new JLabel("20182020097");
        lbCodigo.setForeground(Color.WHITE);
        txtUsuarioInicio = new JTextField();
        txtPassInicio = new JPasswordField();
        BotonIngresar = new JButton("Ingresar");
        BotonIngresar.setBackground(java.awt.Color.LIGHT_GRAY);
        BotonIngresar.setForeground(Color.WHITE);
        BotonRegistroInicio = new JButton("Registrarse");
        BotonRegistroInicio.setBackground(java.awt.Color.LIGHT_GRAY);
        BotonRegistroInicio.setForeground(Color.WHITE);
        
        this.getContentPane().setLayout(null);
        this.setBounds(100, 100, 250, 400);
        this.getContentPane().add(panelInicio);
        
        
        panelInicio.setBounds(0, 0, 250, 400);
        panelInicio.setLayout(null);
        
        panelInicio.add(TituloJuego);
        TituloJuego.setBounds(15, 15, 220, 30);
        TituloJuego.setHorizontalAlignment(JLabel.CENTER);
        TituloJuego.setFont(fuenteTituloG);
        
        
        panelInicio.add(lbImgInicio);
        lbImgInicio.setBounds(15, 45, 220, 110);
        
        
        panelInicio.add(UsuarioInicio);
        UsuarioInicio.setBounds(15, 150, 220, 30);
        panelInicio.add(txtUsuarioInicio);
        txtUsuarioInicio.setBounds(15, 180, 220, 30);
        
        panelInicio.add(ContraseñaInicio);
        ContraseñaInicio.setBounds(15, 210, 220, 30);
        panelInicio.add(txtPassInicio);
        txtPassInicio.setBounds(15, 240, 220, 30);
        
        panelInicio.add(BotonIngresar);
        BotonIngresar.setBounds(15, 280, 105, 30);
        
        panelInicio.add(BotonRegistroInicio);
        BotonRegistroInicio.setBounds(130, 280, 105, 30);
        BotonRegistroInicio.setHorizontalAlignment(JButton.CENTER);
        
        panelInicio.add(lbFirma);
        lbFirma.setBounds(15,325,300,30);
        panelInicio.add(lbCodigo);
        lbCodigo.setBounds(15,335,300,30);
        this.setTitle("Juego Dados");
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        BotonRegistroInicio.setActionCommand("Registrarme");
        BotonRegistroInicio.addActionListener(this);
        
        BotonIngresar.setActionCommand("Ingresar");
        BotonIngresar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Registrarme")){
            this.dispose();
            GuiRegistro registro = new GuiRegistro();            
        }
        else if(e.getActionCommand().equals("Ingresar")){
            
            
            ControlArchivo res = archivos.iniciarSesion(this.txtUsuarioInicio.getText(), new String(this.txtPassInicio.getPassword()));
            if(!res.getRespuesta()){
                JOptionPane.showMessageDialog(null, res.getMensaje(), "Error", JOptionPane.ERROR_MESSAGE);
            }
            else{
                this.dispose();
                GuiBienvenida juegoInt = new GuiBienvenida(res.getJug());
            }
                        
        }
    }
    
    
}
