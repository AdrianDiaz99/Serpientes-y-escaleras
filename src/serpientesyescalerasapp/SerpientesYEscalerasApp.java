
package serpientesyescalerasapp;

public class SerpientesYEscalerasApp {

    public static void main(String[] args) {
        int totJugadores=2;
                //Rutinas.nextInt(2,10);
        SerpientesYEscalerasModelo modelo=new SerpientesYEscalerasModelo(totJugadores);
        SerpientesYEscalerasVista vista=new SerpientesYEscalerasVista(totJugadores);
        SerpientesYEscalerasControlador controlador=new SerpientesYEscalerasControlador(vista,modelo);
        vista.setControlador(controlador);
        vista.muestra();
    }
    
}
