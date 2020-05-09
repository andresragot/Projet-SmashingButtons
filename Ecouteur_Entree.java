import java.awt.event.*;
import java.util.*;
import javax.swing.JOptionPane;

public class Ecouteur_Entree implements ActionListener{
    
    //Attribut de la classe
	private Start Menu;
    private fen_Labyrinthe fen_Lab;
    private JOptionPane jop1;
    
	//Constructeur de la classe
	public Ecouteur_Entree(Start Menu) {
		this.Menu= Menu;
	}
    
    //actionPerformed indique les instructions a executer au clic du bouton
    public void actionPerformed(ActionEvent e){
			Menu.hide();
            fen_Lab = new fen_Labyrinthe(Menu);
            
            //Boîte du message d'information
            jop1 = new JOptionPane();
            jop1.showMessageDialog(null,"Selectionnez tout d'abord une taille de labyrinthe grace au menu déroulant puis appuyez sur le bouton Jouer. \n Ensuite, selectionnez l'avatar de votre choix. \n Pour vous déplacer dans le labyrinthe, utilisez les flèches directionnelles du clavier. \n Bonne partie !","Informations", JOptionPane.INFORMATION_MESSAGE);
    }
}
