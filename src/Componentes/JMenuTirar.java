/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Componentes;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class JMenuTirar extends JPanel{
    private JLabel turno,dados;
    private JPanel panTurno,panDados;
    private JButton tirar;
    Font f;
    
    public JMenuTirar(){
        setLayout(new GridLayout(0,1));
        
        turno=new JLabel("1");
        dados=new JLabel("***");
        panTurno=new JPanel();
        panDados=new JPanel();
        tirar=new JButton("Tirar");
        f=new Font("Arial",Font.PLAIN,20);
        turno.setFont(f);
        dados.setFont(f);
        
        tirar.setFont(new Font("AR ESSENCE",Font.PLAIN,28));
        panTurno.setLayout(new GridLayout(0,2));
        panDados.setLayout(new GridLayout(0,2));
        
        panTurno.add(new JLabel("Turno: ",SwingConstants.CENTER));
        panTurno.add(turno);
        panDados.add(new JLabel("Dados: ",SwingConstants.CENTER));
        panDados.add(dados);
        
        add(panTurno);
        add(panDados);
        add(tirar);
    }
    
    public void setDados(String dados){
        this.dados.setText(dados);
    }
    public void setTurno(int turno){
        this.turno.setText(turno+"");
    }
    public JButton getTirar(){
        return tirar;
    }
    
}
