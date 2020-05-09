import javax.swing.*;

public class joueur {

	public int c;  //numéro de colonne de la position du joueur 
	public int l;  //numéro de ligne de la position du joueur 
	public JLabel Image;
        
	public joueur (int colonne, int ligne){
		
		c = colonne; 
		l = ligne; 
	}
	
	public void changementLigne(int nb){
		
		l =l+nb;
	}
	
	public void changementColonne(int nb){
		
		c =c+nb;
	}
    
}
