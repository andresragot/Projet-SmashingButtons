import java.awt.event.*;
import java.util.*;

public class Ecouteur3 implements ActionListener{
 
	private Fenetre_Jeu fen_Jeu;
	private Fenetre_Menu Menu;
	
	public Ecouteur3(Fenetre_Menu Menu) {
		this.Menu = Menu;
	}
    
    //actionPerformed indique les instructions a executer au clic du bouton
    public void actionPerformed(ActionEvent e){
		Menu.hide();
        fen_Jeu = new Fenetre_Jeu(Menu);
    }
}
