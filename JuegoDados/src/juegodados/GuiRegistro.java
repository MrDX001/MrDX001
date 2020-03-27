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
import java.text.NumberFormat;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.text.NumberFormatter;

/**
 *
 * @author Bryant
 */
public class GuiRegistro extends JFrame implements ActionListener {
    private JPanel panelRegistro;
    private DatosArchivo archivos;
    private JLabel TituloRegistro;
    private JLabel NombreRegistro;
    private JLabel UsuarioRegistro;
    private JLabel ContraseñaRegistro;
    private JLabel SaldoRegistro;
    private JTextField txtNombreRegistro;
    private JTextField txtUsuarioRegistro;
    private JPasswordField txtPassRegistro;
    private JFormattedTextField txtSaldoRegistro;
    private JButton BotonRegresarRegistro;
    private JButton BotonRegistro;
            
    
    public GuiRegistro(){
        archivos = new DatosArchivo();
        Font fuenteTituloG = new Font("", Font.BOLD, 24);
        NumberFormat format = NumberFormat.getIntegerInstance();
        format.setGroupingUsed(false);
        NumberFormatter numberFormatter = new NumberFormatter(format);
        numberFormatter.setValueClass(Integer.class);
        numberFormatter.setMinimum(0);
        numberFormatter.setMaximum(Integer.MAX_VALUE);
        numberFormatter.setAllowsInvalid(false);
        numberFormatter.setCommitsOnValidEdit(true);
        
        
        panelRegistro = new JPanel();
        panelRegistro.setBackground(Color.DARK_GRAY);
        TituloRegistro = new JLabel("Registro");
        TituloRegistro.setForeground(Color.WHITE);
        NombreRegistro = new JLabel("Nombre");
        NombreRegistro.setForeground(Color.WHITE);
        UsuarioRegistro = new JLabel("Usuario");
        UsuarioRegistro.setForeground(Color.WHITE);
        ContraseñaRegistro = new JLabel("Contraseña");
        ContraseñaRegistro.setForeground(Color.WHITE);
        SaldoRegistro = new JLabel("Saldo");
        SaldoRegistro.setForeground(Color.WHITE);
        txtNombreRegistro = new JTextField();
        txtUsuarioRegistro = new JTextField();
        txtPassRegistro = new JPasswordField();
        txtSaldoRegistro = new JFormattedTextField(numberFormatter);
        BotonRegistro = new JButton("Registrar");
        BotonRegresarRegistro = new JButton("Volver");
        
        
        this.getContentPane().setLayout(null);
        this.setBounds(100, 100, 250, 400);
        this.getContentPane().add(panelRegistro);
        
        panelRegistro.setBounds(0, 0, 250, 400);
        panelRegistro.setLayout(null);
        panelRegistro.add(TituloRegistro);
        TituloRegistro.setBounds(15, 15, 220, 30);
        TituloRegistro.setHorizontalAlignment(JLabel.CENTER);
        TituloRegistro.setFont(fuenteTituloG);
        
        panelRegistro.add(NombreRegistro);
        NombreRegistro.setBounds(15, 50, 220, 30);
        panelRegistro.add(txtNombreRegistro);
        txtNombreRegistro.setBounds(15, 80, 220, 30);
        
        panelRegistro.add(UsuarioRegistro);
        UsuarioRegistro.setBounds(15, 110, 220, 30);
        panelRegistro.add(txtUsuarioRegistro);
        txtUsuarioRegistro.setBounds(15, 140, 220, 30);
        
        panelRegistro.add(ContraseñaRegistro);
        ContraseñaRegistro.setBounds(15, 170, 220, 30);
        panelRegistro.add(txtPassRegistro);
        txtPassRegistro.setBounds(15, 200, 220, 30);
        
        panelRegistro.add(SaldoRegistro);
        SaldoRegistro.setBounds(15, 230, 220, 30);
        panelRegistro.add(txtSaldoRegistro);
        txtSaldoRegistro.setBounds(15, 260, 220, 30);
        
        panelRegistro.add(BotonRegresarRegistro);
        BotonRegresarRegistro.setBounds(15, 320, 105, 30);
        
        panelRegistro.add(BotonRegistro);
        BotonRegistro.setBounds(130, 320, 105, 30);
        BotonRegistro.setHorizontalAlignment(JButton.CENTER);
        
        
        this.setTitle("Juego Dados");
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        BotonRegresarRegistro.addActionListener(this);
        BotonRegresarRegistro.setActionCommand("volver");
        
        BotonRegistro.addActionListener(this);
        BotonRegistro.setActionCommand("registro");
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("volver")){
            this.dispose();
            GuiJuego juego = new GuiJuego();
            
        }
        else if(e.getActionCommand().equals("registro")){
            Boolean error = false; 
            if(this.txtNombreRegistro.getText().equals("") || this.txtUsuarioRegistro.getText().equals("") || this.txtPassRegistro.getPassword().equals("") || this.txtSaldoRegistro.getText().equals("")){
                error = true;    
            }
            try{
                if(Integer.parseInt(this.txtSaldoRegistro.getText()) >= 0){
                    JOptionPane.showMessageDialog(null, "El saldo debe ser superior a 0", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }catch(NumberFormatException err){
                    JOptionPane.showMessageDialog(null, "Ha ingresado un valor invalido!", "Error", JOptionPane.ERROR_MESSAGE);
                    txtSaldoRegistro.setText("0");
            }
            catch(Exception err){
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error desconocido", "Error", JOptionPane.ERROR_MESSAGE);
                System.out.println(err);
            }
            
            
            if(error){
                JOptionPane.showMessageDialog(null, "Error completa todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else{
                try{
                    Jugador jug1 = new Jugador(this.txtUsuarioRegistro.getText(),
                        new String(this.txtPassRegistro.getPassword()), 
                        this.txtNombreRegistro.getText(), 
                        Integer.parseInt(this.txtSaldoRegistro.getText()), 0, 0);
                    ControlArchivo res = archivos.crearJugador(jug1);
                    if(!res.getRespuesta()){
                        JOptionPane.showMessageDialog(null, res.getMensaje(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Usuario registrado satisfactoriamente", "Bienvenido", JOptionPane.DEFAULT_OPTION);
                        this.dispose();
                        GuiBienvenida juegoInt = new GuiBienvenida(jug1);
                    }
                }catch(NumberFormatException err){
                    JOptionPane.showMessageDialog(null, "Ha ingresado un valor invalido!", "Error", JOptionPane.ERROR_MESSAGE);
                    txtSaldoRegistro.setText("0");
               
                }
                catch(Exception err){
                    JOptionPane.showMessageDialog(null, "Ha ocurrido un error desconocido", "Error", JOptionPane.ERROR_MESSAGE);
                    System.out.println(err);
                }
                
                
            }
        }
    }
    
}
