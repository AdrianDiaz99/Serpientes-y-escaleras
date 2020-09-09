/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Componentes;

/**
 *
 * @author adria
 */

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class JCambiarNombre extends JPanel implements KeyListener{
    
    private JButton cambiar;
    private JTextField texto;
    private int tam;
    
    public JCambiarNombre(int tam){
        cambiar=new JButton("Cambiar");
        texto=new JTextField();
        this.tam=tam;
        setLayout(new GridLayout(0,1,5,5));
        add(cambiar);
        add(texto);
        texto.addKeyListener(this);
    }
    
    public JButton getCambiar(){
        return cambiar;
    }
    
    public String getTexto(){
        return texto.getText();
    }

    public void keyTyped(KeyEvent e) {
        if(texto.getText().length()==tam){
            e.consume();
            return;
        }
    }

    public void keyPressed(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
    }
    
}
