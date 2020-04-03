/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Estudiantes
 */
public class GUI extends JFrame implements ActionListener, FocusListener{

    private JButton Sumar;
    private JButton Restar;
    private JButton Multiplicar;
    private JButton Dividir;
    private JButton Conjugado;
    private JButton Norma;
    private JButton Resultado;
    
    private JTextField NumeroReal;
    private JTextField NumeroImaginario;
    
    
    
    private JLabel lbMas1;
    private JLabel lbMas2;
    private JLabel TextoResultado;
    private JLabel TextoReal1;
    private JLabel EspacioImaginario1;
    private JLabel TextoReal2;
    private JLabel EspacioImaginario2;
    private JLabel TextoI1;
    private JLabel TextoI2;
    private Complejo comp1;
    private String tipoOpera;
    
    public GUI(){
        this.getContentPane().setBackground(Color.orange);
        tipoOpera = new String("");
        comp1 = new Complejo();
        Sumar = new JButton("+");
        Restar = new JButton("-");
        Multiplicar = new JButton("*");
        Dividir = new JButton("/");
        Conjugado = new JButton("Conjugado");
        Norma = new JButton("Norma");
        
        Resultado = new JButton("=");
                
        NumeroReal = new JTextField("0");
        NumeroImaginario = new JTextField("0");
        
                
        TextoReal1 = new JLabel("Real");
        TextoReal2 = new JLabel("Real");
        EspacioImaginario1 = new JLabel("Imaginario");
        EspacioImaginario2 = new JLabel("Imaginario");
        TextoI1 = new JLabel("i");
        TextoI2 = new JLabel("i");
        lbMas1 = new JLabel("+");
        lbMas2 = new JLabel("+");
        TextoResultado = new JLabel("Resultado");
        
        
        
        this.getContentPane().setLayout(null);
        
        this.setBounds(100, 100, 260 , 300);
        
        this.getContentPane().add(TextoReal1);
        TextoReal1.setBounds(15,15,100,30);
        
        this.getContentPane().add(EspacioImaginario1);
        EspacioImaginario1.setBounds(125,15,100,30);
        
        this.getContentPane().add(NumeroReal);
       NumeroReal.setBounds(15,45,100,30);
       NumeroReal.setHorizontalAlignment(JTextField.CENTER);
        
        this.getContentPane().add(lbMas1);
        lbMas1.setBounds(115,45,10,30);
        
        this.getContentPane().add(NumeroImaginario);
        NumeroImaginario.setBounds(125,45,100,30);
        NumeroImaginario.setHorizontalAlignment(JTextField.CENTER);
        
        
        this.getContentPane().add(TextoI1);
        TextoI1.setBounds(230,45,15,30);
        
        
        this.getContentPane().add(Sumar);
        Sumar.setBounds(15,80,100,30);
        
        this.getContentPane().add(Restar);
        Restar.setBounds(125,80,100,30);

        this.getContentPane().add(Multiplicar);
        Multiplicar.setBounds(15,115,100,30);
        
        this.getContentPane().add(Dividir);
        Dividir.setBounds(125,115,100,30);
        
        this.getContentPane().add(Conjugado);
        Conjugado.setBounds(15,150,100,30);
        
        this.getContentPane().add(Norma);
        Norma.setBounds(125,150,100,30);
        
        this.getContentPane().add(TextoResultado);
        TextoResultado.setBounds(15,195,215,30);
        
        this.getContentPane().add(Resultado);
        Resultado.setBounds(65,115,115,30);
        Resultado.setVisible(false);
        
        
        this.setTitle("CALCULADORA COMPLEJOS");
        this.setResizable(false);
        
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Sumar.addActionListener(this);
        Sumar.setActionCommand("sumar");
        
        Restar.addActionListener(this);
        Restar.setActionCommand("restar");
        
        Multiplicar.addActionListener(this);
        Multiplicar.setActionCommand("multiplicar");
        
        Dividir.addActionListener(this);
        Dividir.setActionCommand("dividir");
        
        Conjugado.addActionListener(this);
        Conjugado.setActionCommand("conjugada");
        
        Norma.addActionListener(this);
        Norma.setActionCommand("norma");
        
        
        Resultado.addActionListener(this);
        Resultado.setActionCommand("igual");
        
       NumeroReal.addFocusListener(this);
        NumeroImaginario.addFocusListener(this);
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getActionCommand().equals("sumar") || e.getActionCommand().equals("restar") || e.getActionCommand().equals("multiplicar") || e.getActionCommand().equals("dividir")){
            try
            {
                comp1.setParteReal(Float.parseFloat(NumeroReal.getText()));
                comp1.setParteImaginario(Float.parseFloat(NumeroImaginario.getText()));
               NumeroReal.setText("0");
                NumeroImaginario.setText("0");
                this.mostarIgual();
            }catch(NumberFormatException err){
                JOptionPane.showMessageDialog(null, "Ha ingresado un valor invalido!", "Error", JOptionPane.ERROR_MESSAGE);
            }
            catch(Exception err){
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error desconocido", "Error", JOptionPane.ERROR_MESSAGE);
                System.out.println(err);
            }
        }
            
        else if(e.getActionCommand().equals("conjugada")){
            try
            {
                Complejo res = new Complejo();
                comp1.setParteReal(Float.parseFloat(NumeroReal.getText()));
                comp1.setParteImaginario(Float.parseFloat(NumeroImaginario.getText()));
                res = comp1.conjugado();
               NumeroReal.setText("0");
                NumeroImaginario.setText("0");
                TextoResultado.setText(res.imprimir());
            }catch(NumberFormatException err){
                JOptionPane.showMessageDialog(null, "Ha ingresado un valor invalido!", "Error", JOptionPane.ERROR_MESSAGE);
            }
            catch(Exception err){
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error desconocido", "Error", JOptionPane.ERROR_MESSAGE);
                System.out.println(err);
            }
        }
        else if(e.getActionCommand().equals("norma")){
            try
            {
                comp1.setParteReal(Float.parseFloat(NumeroReal.getText()));
                comp1.setParteImaginario(Float.parseFloat(NumeroImaginario.getText()));
               NumeroReal.setText("0");
                NumeroImaginario.setText("0");
                TextoResultado.setText( String.valueOf(comp1.norma()));
            }catch(NumberFormatException err){
                JOptionPane.showMessageDialog(null, "Ha ingresado un valor invalido!", "Error", JOptionPane.ERROR_MESSAGE);
            }
            catch(Exception err){
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error desconocido", "Error", JOptionPane.ERROR_MESSAGE);
                System.out.println(err);
            }
        }
        else if(e.getActionCommand().equals("igual")){
            try
            {
                Complejo res = new Complejo();
                if(tipoOpera == "sumar"){
                    res = comp1.suma(new Complejo(Float.parseFloat(NumeroReal.getText()), Float.parseFloat(NumeroImaginario.getText())));
                }
                else if(tipoOpera == "restar"){
                    res = comp1.resta(new Complejo(Float.parseFloat(NumeroReal.getText()), Float.parseFloat(NumeroImaginario.getText())));
                }
                else if(tipoOpera == "multiplicar"){
                    res = comp1.resta(new Complejo(Float.parseFloat(NumeroReal.getText()), Float.parseFloat(NumeroImaginario.getText())));
                }
                else if(tipoOpera == "dividir"){
                    res = comp1.resta(new Complejo(Float.parseFloat(NumeroReal.getText()), Float.parseFloat(NumeroImaginario.getText())));
                }
                TextoResultado.setText(res.imprimir());
               NumeroReal.setText("0");
                NumeroImaginario.setText("0");
                this.mostarDemas();
            }catch(NumberFormatException err){
                JOptionPane.showMessageDialog(null, "Ha ingresado un valor invalido!", "Error", JOptionPane.ERROR_MESSAGE);
            }
            catch(Exception err){
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error desconocido", "Error", JOptionPane.ERROR_MESSAGE);
                System.out.println(err);
            }
        }
        tipoOpera = e.getActionCommand();
    }

    private void mostarIgual(){
        Resultado.setVisible(true);
        Sumar.setVisible(false);
        Restar.setVisible(false);
        Multiplicar.setVisible(false);
        Dividir.setVisible(false);
        Conjugado.setVisible(false);
        Norma.setVisible(false);
        
    }
    private void mostarDemas(){
        Resultado.setVisible(false);
        Sumar.setVisible(true);
        Restar.setVisible(true);
        Multiplicar.setVisible(true);
        Dividir.setVisible(true);
        Conjugado.setVisible(true);
        Norma.setVisible(true);
        
    }

    @Override
    public void focusGained(FocusEvent e) {
        if(e.getSource().equals(NumeroReal) &&NumeroReal.getText().equals("0")){
           NumeroReal.setText("");
        }
        if(e.getSource().equals(NumeroImaginario) && NumeroImaginario.getText().equals("0")){
            NumeroImaginario.setText("");
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        if(e.getSource().equals(NumeroReal) &&NumeroReal.getText().equals("")){
           NumeroReal.setText("0");
        }
        if(e.getSource().equals(NumeroImaginario) && NumeroImaginario.getText().equals("")){
            NumeroImaginario.setText("0");
        }
    }
   
}
