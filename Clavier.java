import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Clavier extends JFrame implements KeyListener{

    public static boolean[] clavier;
    public static boolean up, down, left, right;
    
    public Clavier(){
        clavier = new boolean[256];
    }
    
    public void update(){
        up = clavier[KeyEvent.VK_UP];
        down = clavier[KeyEvent.VK_DOWN];
        left = clavier[KeyEvent.VK_LEFT];
        right = clavier[KeyEvent.VK_RIGHT];
    }
    
    /**
	 * on fait une action lorsqu'on appuie sur une touche du clavier
	 */
    public void keyPressed(KeyEvent event){
        clavier[event.getKeyCode()] = true;
    }
    
    /**
	 * on fait une action lorsqu'on relache sur une touche du clavier
	 */
    public void keyReleased(KeyEvent event){
        clavier[event.getKeyCode()] = false; //pas sure
    }
    
    
    public void keyTyped(KeyEvent event){
        
    }
    
    
}
