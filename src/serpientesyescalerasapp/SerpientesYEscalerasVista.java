
package serpientesyescalerasapp;

import javax.swing.*;
import java.awt.*;
import Componentes.*;
import java.util.Random;

public class SerpientesYEscalerasVista extends JFrame{
    
    private CasillaV [] casillas;
    private MenuJugador[]menuJug;
    private JCambiarNombre nombre;
    private JMenuTirar menuTirar;
    private int iCambiarNombre;
    Color[] c = {Color.GREEN, Color.MAGENTA, Color.ORANGE, Color.PINK, Color.RED,
        Color.WHITE, Color.BLUE, Color.RED, Color.CYAN, Color.YELLOW, new Color(185, 122, 87),
        new Color(255, 0, 255), new Color(64, 128, 128)};
    
    Color cNar, cClaro;
    Font f;
    
    public void moverJugador(Pila<Integer>movtos){
        int casillaPosicion,turno;
        menuTirar.getTirar().setEnabled(false);
        
        movtos.Retira();
        casillaPosicion=movtos.Dr-1;
        movtos.Retira();
        turno=movtos.Dr;
        movtos.Retira();
        
        menuTirar.setDados(movtos.Dr+"");
        menuTirar.update(menuTirar.getGraphics());
        
        while(movtos.Retira()){
            try{
                Thread.sleep(200);
            }catch(Exception e){
                
            }
            
            //casillas[casillaPosicion].getJugadores()[turno].setBackground(CasillaV.getColorDefault());
            casillas[casillaPosicion].getJugadores()[turno].update(casillas[casillaPosicion].getJugadores()[turno].getGraphics());
            casillas[casillaPosicion].getJugadores()[turno].setVisible(false);
            casillaPosicion+=movtos.Dr;
            casillas[casillaPosicion].getJugadores()[turno].setBackground(c[turno]);
            casillas[casillaPosicion].getJugadores()[turno].update(casillas[casillaPosicion].getJugadores()[turno].getGraphics());
            casillas[casillaPosicion].getJugadores()[turno].setVisible(true);
        }    
        if(movtos.Dr==0){
            JOptionPane.showMessageDialog(null, "HA GANADO EL JUGADOR #"+(turno+1), "FELICIDADES", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
        
        if(turno==menuJug.length-1)
        menuTirar.setTurno(1); 
        else
        menuTirar.setTurno((turno+2)); 
        menuTirar.setDados("***");
        menuTirar.getTirar().setEnabled(true);
    }
    
    public void dibujaSerpYEsc(Tipos[][]serpYEsc){
        for(int i=0;i<serpYEsc.length;i++){
            for(int j=0;j<serpYEsc[i].length;j++){
                if(i==0){
                    casillas[serpYEsc[i][j].getNoCasilla()].getCasilla().setIcon(Rutinas.AjustarImagen("Escalera.JPG", 45, 50));
                    JLabel tot=new JLabel(serpYEsc[i][j].getPosiciones()+"");
                    tot.setFont(new Font("Arial BLACK",Font.BOLD,15));
                    tot.setSize(45,20);
                    casillas[serpYEsc[i][j].getNoCasilla()].getCasilla().setLayout(null);
                    casillas[serpYEsc[i][j].getNoCasilla()].getCasilla().add(tot);
                }else{
                    casillas[serpYEsc[i][j].getNoCasilla()].getCasilla().setIcon(Rutinas.AjustarImagen("Serpiente.JPG", 45, 50));
                    JLabel tot=new JLabel(serpYEsc[i][j].getPosiciones()+"");
                    tot.setFont(new Font("Arial BLACK",Font.BOLD,15));
                    tot.setSize(45,20);
                    casillas[serpYEsc[i][j].getNoCasilla()].getCasilla().setLayout(null);
                    casillas[serpYEsc[i][j].getNoCasilla()].getCasilla().add(tot);
                    
                }
            }
        }
    }
    
    public JMenuTirar getMenuTirar(){
        return menuTirar;
    }
    
    public JButton[]getBtnsJug(){
        JButton[]botonesJugador=new JButton[menuJug.length];
        
        for(int i=0;i<menuJug.length;i++)
            botonesJugador[i]=menuJug[i].getColor();
        
        return botonesJugador;
    }
    
    public JCambiarNombre getNombre(){
        return nombre;
    }
    
    public void actualizarNombre(String nvoNombre){
        menuJug[iCambiarNombre].setNombre(nvoNombre);
        nombre.setVisible(false);
        menuTirar.getTirar().setEnabled(true);
    }
    
    public void activaPanelNombre(int i){
        iCambiarNombre=i;
        menuTirar.getTirar().setEnabled(false);
        nombre.setVisible(true);
    }
    
    public SerpientesYEscalerasVista(int totJugadores){
        super("Serpientes y escaleras");
        
        cNar=new Color(252,231,148);
        cClaro=new Color(244,131,55);
        f=new Font("AR BLANCA",Font.BOLD,40);
        nombre=new JCambiarNombre(12);
        menuJug=new MenuJugador[totJugadores];
        
        hazInterfaz();
        hazComplemento();
        
    }

    public void hazInterfaz() {
        this.getContentPane().setBackground(Color.WHITE);
        setSize(1300, 1030);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(0, 10));
        casillas = new CasillaV[100];
        llenaCasillas();
    }
    
    private void llenaCasillas(){
        boolean band=true;
        Pila<CasillaV>aux=new Pila();
        
        for( int i = casillas.length - 1 ; i >= 0 ; i -= 10 ){
            for(int j = i ; j > i - 10 ; j-- ){
                casillas[j]=new CasillaV();
                casillas[j].getCasilla().setFont(f);
                casillas[j].getCasilla().setText( ( j + 1 ) + "");
                
                if(j % 2 == 0)
                    casillas[j].getCasilla().setBackground(cNar);
                else
                    casillas[j].getCasilla().setBackground(cClaro);
                
                if(band){
                    add(casillas[j]);
                    continue;
                }
                
                aux.Inserta(casillas[j]);
            }
            while(aux.Retira())
                add(aux.Dr);
            band=!band;
        }
    }
    
    public void hazComplemento(){
        
        for(int i=0;i<casillas.length;i++){
            casillas[i].asignaJugadoresACasillas(menuJug.length);
        }
        
        for(int i=0;i<menuJug.length;i++){
            
            
            switch(i){
                case 0:menuJug[0]=new MenuJugador("Jugador #"+(i+1), c[0] ); break;                
                case 1:menuJug[1]=new MenuJugador("Jugador #"+(i+1), c[1] ); break;
                case 2:menuJug[2]=new MenuJugador("Jugador #"+(i+1), c[2] ); break;
                case 3:menuJug[3]=new MenuJugador("Jugador #"+(i+1), c[3] ); break;
                case 4:menuJug[4]=new MenuJugador("Jugador #"+(i+1), c[4] ); break;
                case 5:menuJug[5]=new MenuJugador("Jugador #"+(i+1), c[5] ); break;
                case 6:menuJug[6]=new MenuJugador("Jugador #"+(i+1), c[6] ); break;
                case 7:menuJug[7]=new MenuJugador("Jugador #"+(i+1), c[7] ); break;
                case 8:menuJug[8]=new MenuJugador("Jugador #"+(i+1), c[8] ); break;                
                case 9:menuJug[9]=new MenuJugador("Jugador #"+(i+1), c[9] ); break;
                case 10:menuJug[10]=new MenuJugador("Jugador #"+(i+1), c[10] ); break;
                case 11:menuJug[11]=new MenuJugador("Jugador #"+(i+1), c[11] ); break;
            }
            
            add(menuJug[i]);
            
                casillas[0].getJugadores()[i].setBackground(c [i] );
                casillas[0].getJugadores()[i].setVisible(true);
            
        }
        
        menuTirar=new JMenuTirar();
        
        add(menuTirar);
        add(nombre);
        nombre.setVisible(false);
    }

    public void setControlador(SerpientesYEscalerasControlador c){
        menuTirar.getTirar().addActionListener(c);
        nombre.getCambiar().addActionListener(c);
        for(int i=0;i<getBtnsJug().length;i++){
            getBtnsJug()[i].addActionListener(c);
        }
    }
    
    public void muestra(){
        setVisible(true);
    }
}
