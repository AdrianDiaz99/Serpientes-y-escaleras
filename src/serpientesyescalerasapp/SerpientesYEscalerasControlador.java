
package serpientesyescalerasapp;

import java.awt.event.*;

public class SerpientesYEscalerasControlador implements ActionListener, KeyListener{
    
    SerpientesYEscalerasVista vista;
    SerpientesYEscalerasModelo modelo;
    
    public SerpientesYEscalerasControlador(SerpientesYEscalerasVista vista, SerpientesYEscalerasModelo modelo){
        this.modelo=modelo;
        this.vista=vista;
        vista.dibujaSerpYEsc( modelo.getSerpYEsc() );
    }
    
    public void actionPerformed(ActionEvent e){
        
        if(e.getSource()==vista.getMenuTirar().getTirar()){
            vista.moverJugador(modelo.Juega());
        }
        if(e.getSource()==vista.getNombre().getCambiar()){
            vista.actualizarNombre(vista.getNombre().getTexto());
        }
        
        for(int i=0;i<vista.getBtnsJug().length;i++){
            
            if(e.getSource() == vista.getBtnsJug()[i] ){
                
                vista.activaPanelNombre(i);
                return;
                
            }
            
        }
        
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
