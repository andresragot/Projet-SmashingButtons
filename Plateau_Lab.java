import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.io.File;
import java.io.*;
import java.util.* ; 


public class Plateau_Lab extends JFrame {  
	
	public JLabel [][] Cases;	
	
	public Plateau_Lab(String f, JLayeredPane e ) throws IOException{
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		LectureText lab = new LectureText(f);
		int m = lab.haut;		//Récupération de la hauteur du labyrinthe 
		int n = lab.larg; //Récupération de la largeur du labyrinthe 
		
        //Création du tableau contenant les cases du labyrinthe 
        Cases= new JLabel [m][n];	
        
        //Images utilisées pour l'interface graphique 
		File ImageMur= new File("muros.png");
		ImageIcon IconMur = new ImageIcon(new ImageIcon(ImageMur.getAbsolutePath()).getImage().getScaledInstance(800/n, (dim.height-90)/m, Image.SCALE_DEFAULT));
		
        /*File ImageDepart= new File("depart.png");
		ImageIcon IconDepart = new ImageIcon(new ImageIcon(ImageDepart.getAbsolutePath()).getImage().getScaledInstance(800/n, (dim.height-90)/m, Image.SCALE_DEFAULT));*/
        
        File ImageVide= new File("vide.jpg");
		ImageIcon IconVide = new ImageIcon(new ImageIcon(ImageVide.getAbsolutePath()).getImage().getScaledInstance(800/n, (dim.height-90)/m, Image.SCALE_DEFAULT));
        
		File ImageSortie= new File("sortie.png");
		ImageIcon IconSortie = new ImageIcon(new ImageIcon(ImageSortie.getAbsolutePath()).getImage().getScaledInstance(800/n, (dim.height-90)/m, Image.SCALE_DEFAULT));
		
        for (int i=0; i<Cases[0].length;i++){
			for(int j=0; j<Cases.length;j++){
				if(lab.tab[j][i]==0 || lab.tab[j][i]==2){	//Si la case du labyrinthe est égale à 0 (case vide) ou 2 (case départ) 
                    Cases [j][i]= new JLabel(IconVide);
				}
				else if(lab.tab[j][i]==3){
					Cases [j][i]= new JLabel(IconSortie); //Si la case du labyrinthe est égale à 3 (sortie) 
				}
				else if(lab.tab[j][i]==1){
					Cases [j][i]= new JLabel(IconMur);	//Si la case du labyrinthe est égale à 1 (mur)
				}
				Cases[j][i].setBounds(i*800/n, j*(dim.height-100)/m, 800/n, (dim.height-70)/m);
				e.add(Cases[j][i]);
				e.moveToFront(Cases[j][i]);	//permt d'assurer la bonne superposition des JLabel
			}
		}
	} 
}

