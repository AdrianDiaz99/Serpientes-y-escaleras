package serpientesyescalerasapp;

/*Este programa representa el juego de serpientes y escaleras
Diaz Orozco Jesus Adrian
20 de noviembre de 2018
Clemente Garcia Gerardo
Estructura de datos*/

/*class Casilla{
    public int NoCasilla;
    public char TipoCasilla; //N, T, S, E.
    public int Posiciones;
    Casilla(int NoCasilla, char TipoCasilla,int Posiciones){
        this.NoCasilla=NoCasilla;
        this.TipoCasilla=Character.toUpperCase(TipoCasilla);
        this.Posiciones=Posiciones;
    }
}

public class SerpientesEscaleras {
    ListaDBL<Casilla>Tablero;

    SerpientesEscaleras(){
        Tablero=new ListaDBL();
        
        GeneraTablero();
        ImprimeTablero();
        Juega();
    }
    
    public void ImprimeTablero(){
        for(NodoDBL<Casilla>Aux=Tablero.getFrente();Aux!=null;Aux=Aux.getSig()){
            System.out.print(Aux.Info.NoCasilla+" "+Aux.Info.TipoCasilla+" "+Aux.Info.Posiciones+"\t|\t");
            if(Aux.Info.NoCasilla%10==0)
                System.out.println("\n_______________________________________________________________________"
                        + "___________________________________________________________________________________");
        }
        System.out.println();
    }
    
    public void Juega(){
        
        NodoDBL<Casilla>Jugadores[]=new NodoDBL[Rutinas.nextInt(2, 10)];
        
        for(int i=0;i<Jugadores.length;i++)
            Jugadores[i]=Tablero.getFrente();
       
        int dados,turno=0;
        
        while(true){
            dados=Rutinas.nextInt(2, 12);
            int casillaInicio=Jugadores[turno].Info.NoCasilla;
            int lugares=0;
            
            for(int i=0;i<dados;i++){//Cambiar al retroceder
                if(Jugadores[turno]==Tablero.getFin()){
                    for(int j=0;j<dados-i;j++)
                        Jugadores[turno]=Jugadores[turno].getAnt();
                    break;
                }
                Jugadores[turno]=Jugadores[turno].getSig();
            }
            
            int casillaFinal=Jugadores[turno].Info.NoCasilla;
            char tipoNodo=Jugadores[turno].Info.TipoCasilla;
            int posiciones=Jugadores[turno].Info.Posiciones;
            
            switch(Jugadores[turno].Info.TipoCasilla){
                case 'S':
                    for(int i=0;i<posiciones;i++)
                        Jugadores[turno]=Jugadores[turno].getAnt();
                    break;
                        
                case 'E':
                    for(int i=0;i<posiciones;i++)
                        Jugadores[turno]=Jugadores[turno].getSig();
                    break;
            }
            
            
            System.out.println("Turno: "+(turno+1));
            System.out.println("Dados: "+dados);
            System.out.println("Casilla Actual: "+casillaInicio);
            System.out.println("Nueva Casilla : "+casillaFinal);
            System.out.println("Tipo de casilla: "+tipoNodo);
            System.out.println("Movimiento adicional: "+posiciones);
            System.out.println("Casilla Final: "+Jugadores[turno].Info.NoCasilla);
            
            if(casillaFinal==100){
                System.out.println("HA GANADO EL JUGADOR "+(turno+1));
                break;
            }
            
            System.out.println();
            
            if(turno==Jugadores.length-1){
                turno=0;
                continue;
            }
            turno++;
        }
    }
    
    public void GeneraTablero(){
        for(int i=1;i<=100;i++){
            Tablero.InsertaFin(new Casilla(i,'N',0));
        }
        
        GeneraEscaleras();
        GeneraSerpientes();
        
    }
    
    public void GeneraEscaleras(){
        for(int i=0;i<5;i++){
            
            int nodoEscalera=Rutinas.nextInt(15,70);
            NodoDBL<Casilla>Aux=Tablero.getFrente();
            
            for(int j=0;j<nodoEscalera;j++){
                Aux=Aux.getSig();
            }
            
            if(Aux.Info.TipoCasilla != 'N'){
                i--;
                continue;
            }
            
            Aux.Info.TipoCasilla='E';
            NodoDBL<Casilla>Aux2=Aux;
                
            while(Aux2.Info.TipoCasilla != 'N'){
                
                Aux2=Aux;
                int posiciones=Rutinas.nextInt(5,20);
                Aux.Info.Posiciones=posiciones;
                
                for(int j=0;j<posiciones;j++){
                    Aux2=Aux2.getSig();
                }
                
            }
            
            Aux2.Info.TipoCasilla='T';
        }

    }
    
    public void GeneraSerpientes(){
        for(int i=1;i<=5;i++){
            
            int nodoSerpiente=Rutinas.nextInt(30,95);
            NodoDBL<Casilla>Aux=Tablero.getFrente();
            
            for(int j=0;j<nodoSerpiente;j++)
                Aux=Aux.getSig();
            
            if(Aux.Info.TipoCasilla!='N'){
                i--;
                continue;
            }
            
            Aux.Info.TipoCasilla='S';
            NodoDBL<Casilla>Aux2=Aux;
            
            while(Aux2.Info.TipoCasilla!='N'){
                
                Aux2=Aux;
                int posiciones=Rutinas.nextInt(5, 20);
                Aux2.Info.Posiciones=posiciones;
                
                for(int j=0;j<posiciones;j++)
                    Aux2=Aux2.getAnt();
            }
            Aux2.Info.TipoCasilla='T';
            
        }
    }
    
    public static void main(String[] args) {
    new SerpientesEscaleras();
    }
    
}
*/