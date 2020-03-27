
package juegodados;


public class ControlArchivo {
    private Boolean respuesta;
    private String mensaje;
    private Jugador jug;

    public ControlArchivo(){
        this.respuesta = false;
        this.mensaje = "";
        this.jug = new Jugador();
    }
    public ControlArchivo(Boolean respuesta, String mensaje){
        this.respuesta = respuesta;
        this.mensaje = mensaje;
        this.jug = new Jugador();
    }
    public ControlArchivo(Boolean respuesta, String mensaje, Jugador jug){
        this.respuesta = respuesta;
        this.mensaje = mensaje;
        this.jug = jug;
    }
    
    public Boolean getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(Boolean respuesta) {
        this.respuesta = respuesta;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Jugador getJug() {
        return jug;
    }

    public void setJug(Jugador jug) {
        this.jug = jug;
    }
        
    
}
