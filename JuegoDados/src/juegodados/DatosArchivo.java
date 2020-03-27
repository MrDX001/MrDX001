/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegodados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bryant
 */
public class DatosArchivo {

    private String ruta;
    private File datos;

    public DatosArchivo() {
        this.ruta = "datos.txt";
        this.datos = new File(this.ruta);
        this.crearArchivo();
    }

    private void crearArchivo() {
        try {
            datos.createNewFile();
        } catch (IOException ex) {
            System.out.println("An error occurred." + ex);
        }
    }

    public ControlArchivo crearJugador(Jugador prevJug) {
        ControlArchivo res = new ControlArchivo(false, "Error al crear jugador");
        ArrayList<Jugador> listaJug = new ArrayList<>();
        try {
            FileInputStream fi = new FileInputStream(this.datos);
            ObjectInputStream oi = new ObjectInputStream(fi);
            if (fi.available() > 0) {
                ArrayList<Jugador> jugadoresBd = (ArrayList<Jugador>) oi.readObject();
                for (Jugador jug : jugadoresBd) {
                    if (jug.getUsuario().equals(prevJug.getUsuario())) {
                        res.setMensaje("Error el usuario ya existe!");
                        return res;
                    } else {
                        listaJug.add(jug);
                    }
                }
            }
            oi.close();
            fi.close();

        } catch (FileNotFoundException e) {
            System.out.println("No existe el archivo");
        } catch (IOException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println("Error clase no encontrada");
        } catch (Exception e) {
            System.out.println("Error desconocido");
        }
        
        try {
            FileOutputStream f = new FileOutputStream(this.datos);
            ObjectOutputStream o = new ObjectOutputStream(f);

            listaJug.add(prevJug);
            o.writeObject(listaJug);

            o.close();
            f.close();
            res.setRespuesta(true);

            return res;
        } catch (FileNotFoundException e) {
            System.out.println("No existe el archivo");
        } catch (IOException e) {
            System.out.println(e);
        }
        return res;
    }
    public ControlArchivo iniciarSesion(String usuario, String pass){
        ControlArchivo res = new ControlArchivo();
        try {
            FileInputStream fi = new FileInputStream(this.datos);
            ObjectInputStream oi = new ObjectInputStream(fi);
            if (fi.available() > 0) {
                ArrayList<Jugador> jugadoresBd = (ArrayList<Jugador>) oi.readObject();
                for (Jugador jug : jugadoresBd) {
                    if (jug.getUsuario().equals(usuario) && jug.getPass().equals(pass)) {
                        res.setJug(jug);
                        res.setRespuesta(true);
                        return res;
                    } 
                }
            }
            oi.close();
            fi.close();
            res.setMensaje("Error no se ha encontrado el usuario");
            res.setRespuesta(false);
            return res;
        } catch (FileNotFoundException e) {
            System.out.println("No existe el archivo");
        } catch (IOException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println("Error clase no encontrada");
        }

        
        return res;
    }
    public ControlArchivo terminarJuego(Juego juego) {
        ControlArchivo res = new ControlArchivo(false, "Error al modificar Saldo");
        ArrayList<Jugador> listaJug = new ArrayList<>();
        try {
            FileInputStream fi = new FileInputStream(this.datos);
            ObjectInputStream oi = new ObjectInputStream(fi);
            if (fi.available() > 0) {
                ArrayList<Jugador> jugadoresBd = (ArrayList<Jugador>) oi.readObject();
                for (Jugador jug : jugadoresBd) {
                    if (jug.getUsuario().equals(juego.getJug1().getUsuario())) {
                        jug.setSaldo(juego.getJug1().getSaldo() + juego.getValApostado());
                        if(juego.getEstado() == 1){
                            jug.setJuegosGanados(juego.getJug1().getJuegosGanados() + 1);
                        }
                        else if(juego.getEstado() == 2){
                            jug.setJuegosPerdidos(juego.getJug1().getJuegosPerdidos()+ 1);
                        }
                        listaJug.add(jug);
                        res.setJug(jug);
                        
                    } else {
                        listaJug.add(jug);
                    }
                }
            }
            oi.close();
            fi.close();

        } catch (FileNotFoundException e) {
            System.out.println("No existe el archivo");
        } catch (IOException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println("Error clase no encontrada");
        }
        try {
            FileOutputStream f = new FileOutputStream(this.datos);
            ObjectOutputStream o = new ObjectOutputStream(f);

            o.writeObject(listaJug);

            o.close();
            f.close();
            res.setRespuesta(true);

            return res;
        } catch (FileNotFoundException e) {
            System.out.println("No existe el archivo");
        } catch (IOException e) {
            System.out.println(e);
        }
        return res;
    }
    public ControlArchivo cambiarSaldo(Jugador jug1, int nuevoSaldo) {
        ControlArchivo res = new ControlArchivo(false, "Error al modificar saldo");
        ArrayList<Jugador> listaJug = new ArrayList<>();
        try {
            FileInputStream fi = new FileInputStream(this.datos);
            ObjectInputStream oi = new ObjectInputStream(fi);
            if (fi.available() > 0) {
                ArrayList<Jugador> jugadoresBd = (ArrayList<Jugador>) oi.readObject();
                for (Jugador jug : jugadoresBd) {
                    if (jug.getUsuario().equals(jug1.getUsuario())) {
                        jug.setSaldo(nuevoSaldo);
                        listaJug.add(jug);
                        res.setJug(jug);
                        
                    } else {
                        listaJug.add(jug);
                    }
                }
            }
            oi.close();
            fi.close();

        } catch (FileNotFoundException e) {
            System.out.println("No existe el archivo");
        } catch (IOException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println("Error clase no encontrada");
        }
        try {
            FileOutputStream f = new FileOutputStream(this.datos);
            ObjectOutputStream o = new ObjectOutputStream(f);
            
            o.writeObject(listaJug);

            o.close();
            f.close();
            res.setRespuesta(true);

            return res;
        } catch (FileNotFoundException e) {
            System.out.println("No existe el archivo");
        } catch (IOException e) {
            System.out.println(e);
        }
        return res;
    }

}
