
package Componentes;

import javax.swing.*;
import java.awt.*;
public class CasillaV extends JPanel{
    
    private JButton casilla;
    private JButton[]jugadores;
    private JPanel sur,norte,este,oeste;
    private static final Color COLOR_DEFAULT=Color.LIGHT_GRAY;
    
    
    public CasillaV(){
        casilla=new JButton();
        sur=new JPanel();
        sur=new JPanel();
        norte=new JPanel();
        este=new JPanel();
        oeste=new JPanel();
        hazInterfaz();
    }
    
    public void hazInterfaz(){
        setLayout(new BorderLayout());
        
        sur.setLayout(new GridLayout(0,5));
        
        add(sur,BorderLayout.SOUTH);
        add(casilla,BorderLayout.CENTER);
    }
    public void asignaJugadoresACasillas(int totJugadores){        
        jugadores=new JButton[totJugadores];
        for(int i=0;i<jugadores.length;i++){
            jugadores[i]=new JButton();
            jugadores[i].setBackground(COLOR_DEFAULT);
                sur.add(jugadores[i]);
            jugadores[i].setVisible(false);
        }
    }
    
    public JButton getCasilla(){
        return casilla;
    }
    public JButton[] getJugadores(){
        return jugadores;
    }
    public static Color getColorDefault(){
        return COLOR_DEFAULT;
    }
}
