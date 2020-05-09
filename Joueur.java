import javax.swing.*;

public class Joueur {

	public int c;  //numéro de colonne de la position du joueur 
	public int l;  //numéro de ligne de la position du joueur 
	public JLabel Image;
	public Jeu lejeu;
        
	public Joueur (Jeu jeu,int colonne, int ligne){
		lejeu = jeu;
		c = colonne; 
		l = ligne; 
	}
	
	public float getX(){
		return x;
	}
	
	public float getY(){
		return y;
	}
	
	public void changementLigne(int nb){
		
		l =l+nb;
	}
	
	public void changementColonne(int nb){
		
		c =c+nb;
	}
    
}
