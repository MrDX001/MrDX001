/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegodados;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;
import java.util.TimerTask;
import java.util.Timer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Bryant
 */
public class GuiJugar extends JFrame implements ActionListener{
    private Timer timer;
    private TimerTask task;
    private int estado; 
    private DatosArchivo archivos;
    private JPanel panelJugar;
    private JLabel lbJuego;
    private JLabel lbValorApostado;
    private JButton btnVolver;
    private JButton btnLanzar;
    private ImageIcon imgDado1;
    private ImageIcon imgDado2;
    private JLabel lbDado1;
    private JLabel lbDado2;
    private Juego juego;
    private int contador;
    public GuiJugar(Juego juego){
        estado = 0;
        contador = 0;
        this.juego = juego;
        archivos = new DatosArchivo();
        Font fuenteTituloG = new Font("", Font.BOLD, 24);
        Font fuenteValor = new Font("", Font.BOLD, 20);
        panelJugar = new JPanel();
        panelJugar.setBackground(Color.DARK_GRAY);
        lbJuego = new JLabel("Juego # " + String.valueOf(juego.getJug1().getJuegosGanados() + juego.getJug1().getJuegosPerdidos() + 1));
        lbJuego.setForeground(Color.WHITE);
        btnVolver = new JButton("Volver");
        btnVolver.setBackground(java.awt.Color.LIGHT_GRAY);
        btnVolver.setForeground(Color.WHITE);
        btnLanzar = new JButton("Lanzar");
        btnLanzar.setBackground(java.awt.Color.LIGHT_GRAY);
        btnLanzar.setForeground(Color.WHITE);
        lbValorApostado = new JLabel("Valor apostado: " + String.valueOf(juego.getValApostado()));
        lbValorApostado.setForeground(Color.WHITE);
        imgDado1 = new ImageIcon("src/resource/dado1.png");        
        imgDado2 = new ImageIcon("src/resource/dado1.png");
        lbDado1 = new JLabel(imgDado1);
        lbDado2 = new JLabel(imgDado2);
        
        
        this.getContentPane().setLayout(null);
        this.setBounds(100, 100, 250, 400);
        this.getContentPane().add(panelJugar);
        
        panelJugar.setBounds(0, 0, 250, 400);
        panelJugar.setLayout(null);
        
        panelJugar.add(lbJuego);
        lbJuego.setFont(fuenteTituloG);
        lbJuego.setHorizontalAlignment(JLabel.CENTER);
        lbJuego.setBounds(15, 15, 220, 50);
        
        panelJugar.add(lbValorApostado);
        lbValorApostado.setFont(fuenteValor);
        lbValorApostado.setHorizontalAlignment(JLabel.CENTER);
        lbValorApostado.setBounds(15, 75, 220, 50);
        
        
        panelJugar.add(btnLanzar);
        btnLanzar.setBounds(15, 200, 220, 50);
        btnLanzar.setFont(fuenteTituloG);
        
        panelJugar.add(lbDado1);
        lbDado1.setBounds(50, 290, 50, 50);
        
        panelJugar.add(lbDado2);
        lbDado2.setBounds(150, 290, 50, 50);
        
        timer = new Timer();
        task = new TimerTask() {
            @Override
            public void run() {
                if(estado == 0){
                    
                }
                if(estado == 1 && contador<15){
                    Random r = new Random();
                    int dadoR1 = r.nextInt(juego.getDado1().getCaras()) + 1;
                    int dadoR2 = r.nextInt(juego.getDado2().getCaras()) + 1;
                    imgDado1 = new ImageIcon("src/resource/dado"+String.valueOf(dadoR1)+".png");
                    imgDado2 = new ImageIcon("src/resource/dado"+String.valueOf(dadoR2)+".png");
                    lbDado1.setIcon(imgDado1);
                    lbDado2.setIcon(imgDado2);
                    contador++;
                     
                }
                else if(estado == 1 && contador == 15){
                   estado = 2;
                    System.out.println(contador);
                }
                else if(estado == 2){
                    System.out.println(contador);
                    imgDado1 = new ImageIcon("src/resource/dado"+String.valueOf(juego.getDado1().getValor())+".png");
                    imgDado2 = new ImageIcon("src/resource/dado"+String.valueOf(juego.getDado2().getValor())+".png");
                    lbDado1.setIcon(imgDado1);
                    lbDado2.setIcon(imgDado2);
                    contador = 0;
                    if(juego.getEstado() == 1){
                        ControlArchivo res = archivos.terminarJuego(juego);
                        JOptionPane.showMessageDialog(null, "Has Ganado", "Has Ganado", JOptionPane.INFORMATION_MESSAGE);
                        timer.cancel();
                        dispose();
                        
                        GuiBienvenida juegoInt = new GuiBienvenida(res.getJug());
                    }
                    else if(juego.getEstado() == 2){
                        ControlArchivo res = archivos.terminarJuego(juego);
                        JOptionPane.showMessageDialog(null, "Has Perdido", "Has Perdidio", JOptionPane.ERROR_MESSAGE);
                        timer.cancel();
                        dispose();
                        
                        GuiBienvenida juegoInt = new GuiBienvenida(res.getJug());
                        
                    }
                    estado = 0;
                }
            }
        };
        timer.schedule(task, 0, 100);

        this.setTitle("Juego Dados");
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
               juego.terminarJuegoAntes();
               ControlArchivo res = archivos.terminarJuego(juego);
               GuiBienvenida juegoInt = new GuiBienvenida(res.getJug());
            }
        });
        
        this.btnLanzar.addActionListener(this);
        this.btnLanzar.setActionCommand("lanzar");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("lanzar")){
            juego.lanzar();
            estado = 1;
            contador = 0;
        }
    }
    
    
}
