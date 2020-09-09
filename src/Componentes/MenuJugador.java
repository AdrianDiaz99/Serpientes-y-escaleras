/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Componentes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class MenuJugador extends JPanel{
    
    private JLabel nombre;
    private JButton color;
    
    public MenuJugador(String nombre, Color c){
        setLayout(new GridLayout(0,1));
        setBackground(Color.LIGHT_GRAY);
        
        this.nombre=new JLabel(nombre);
        this.color=new JButton();
        color.setBackground(c);
        
        add(this.nombre);
        add(this.color);
    }
    
    public String getNombre(){
        return nombre.getText();
    }
    public void setNombre(String nombre){
        this.nombre.setText(nombre);
    }
    public JButton getColor(){
        return color;
    }
    
    
}
