import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import java.util.*;
import java.util.LinkedList;
import javax.swing.ImageIcon;
//
import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;
//

public class Affichage {
	
    private String nomJeu;
    
    private int hauteur;//lignes
    private int largeur; //colonnes 
	
	private JFrame leJFrame;
	private Canvas canvas;
	
	public Affichage (String nom, int hauteur, int largeur){
		nomJeu = nom;
		this.hauteur = hauteur;
		this.largeur = largeur;
		
		creerAffichage();
	} 
	
	public void creerAffichage(){
		
		//Operations sur le Jframe
		leJFrame = new JFrame(nomJeu);
		
		leJFrame.setSize(largeur, hauteur);
		leJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		leJFrame.setVisible(true);
		leJFrame.setResizable(false);
		leJFrame.setLocationRelativeTo(null);
		
		//le setUp du canvas
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(largeur, hauteur));
		canvas.setMinimumSize(new Dimension(largeur, hauteur));
		canvas.setMaximumSize(new Dimension(largeur, hauteur));
		canvas.setFocusable(false);
		
		leJFrame.add(canvas); 
		leJFrame.pack();
	
	}
	
	public Canvas getCanvas(){
		return canvas;
	}
    public JFrame getFrame(){
		return leJFrame;
	}
}
    











