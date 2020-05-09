import javax.swing.*;    
import java.awt.event.*;   
import java.io.*;
import java.util.* ;  
import java.awt.*;

public class ComboBox extends JFrame implements ActionListener {    

	   public JPanel p ;
	   public JComboBox cb;
	   public JLayeredPane Ecran ;	//Ajout de cette variable pour pouvoir y accéder dans la méthode actionPerformed et pouvoir utiliser dessinlab
	   public String s;

        //Création du menu déroulant permettant de choisir la taille du labyrinthe 
		public ComboBox(JLayeredPane e){  
			
			Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();	
			int d=dim.height-60;	// Création des variables nécessaires à l'adaptation du menu déroulant à l'écran de l'utilisateur
			int c=d-d/3; 			// Hauteur disponible en prenant en compte les espaces
			int h=(int)(c/9);		// Donne hauteur des boutons
			int esp= (int)(d*3/100); // Taille espacement
			Ecran=e;	
            
			String taille[]={"Selectionner taille","10x10","20x20","30x30","40x40", "50x50"};        
			
            cb =new JComboBox(taille);    
			cb.setBounds(0, 0,150,h); 
                
            //Creation du panel p et ajout de tous les elements au panel
            p = new JPanel();
			p.setLayout(null);
		    p.setBounds(20,4*esp+3*h,200,250);	    
			p.add(cb);
			
		}
 
              
        public void actionPerformed (ActionEvent e) {  
				
				s =getIndex();	//Récupère le string selectionné dans la combobox 
				s +=".txt";
				
				try{		//Lance Plateau_Lab en utilisant le bon fichier txt 
					if (s.equals("10x10.txt")){
						Plateau_Lab a = new Plateau_Lab("10x10.txt", Ecran);
					}
					if (s.equals("20x20.txt")){
						Plateau_Lab a = new Plateau_Lab("20x20.txt", Ecran );
					}
					if (s.equals("30x30.txt")){
						Plateau_Lab a = new Plateau_Lab("30x30.txt", Ecran);
					}
					if (s.equals("40x40.txt")){
						Plateau_Lab a = new Plateau_Lab("40x40.txt", Ecran);
					}
					if (s.equals("50x50.txt")){
						Plateau_Lab a = new Plateau_Lab("50x50.txt" , Ecran); 
					}
				} catch (FileNotFoundException a) {		// Conditions pour ne pas lire une ligne vide et s'arrêter à la fin de la ligne
					a.printStackTrace();
				} catch (IOException a) {
					a.printStackTrace();
				}
		}
		
		public  String getIndex() {			// Méthode permettant de récupérer le contenu du menu déroulant 
			return((String) cb.getItemAt(cb.getSelectedIndex()));
		}              
}   
