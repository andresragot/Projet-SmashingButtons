import java.awt.event.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.JMenuItem;

public class EcouteurMenu implements ActionListener{
 
	private Fenetre_Jeu fen_Jeu;
    
    private JMenuItem pause;
    private JMenuItem reprendre;
    private JMenuItem restaurer;
	
	public EcouteurMenu(Fenetre_Jeu fen_jeu) {
		this.fen_Jeu = fen_jeu;
	}
    
    //actionPerformed indique les instructions a executer au clic du bouton
    public void actionPerformed(ActionEvent e){
        /*if(e.getSource() == pause){
        }
        if(e.getSource() == reprendre) {
        }
        if(e.getSource()== restaurer){
        repaint();
        }*/
        }
    }
