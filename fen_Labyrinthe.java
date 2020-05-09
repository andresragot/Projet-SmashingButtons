import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.Timer; 
import java.io.File;
import java.io.*;
import java.util.* ; 
import javax.swing.JOptionPane;


public class fen_Labyrinthe extends JFrame implements ActionListener{

	//Decalaration des elements graphiques de la fenetre  
	private JLabel TimerLabel;
    
    private JButton Score;	
    private JButton Jouer; 	
    private JButton Avatar1;
	private JButton Avatar2;
	private JButton Avatar3;
	private JButton Avatar4; 
    
    private JOptionPane msg1, msg3, msg4, msg5, msg6, msg7, msg8, msg9;
    
	private JPanel Conteneur;
	private JLayeredPane Labyrinthe;	//Utilisation d'un JLayeredPane pour superposer les JLabel (image joueur )
    private ComboBox taille;
    
    //Declaration des attributs de la fenetre
 	private joueur j;					//Initialisation des variables utiles à la représentation du joueur et au compte de ses points 
    private int joueurAffiche = 0;  	// Retient si un personnage est affiché et si oui, lequel 
    private int compteurPoint =0;		//Retient les points du joueur 
    
    private int [][] Lab; 				//Initialisation du tableau représentant le labyrinthe et de sa largeur
	private int hauteur;
	private int largeur;
    
	private boolean fenetreFinAffiche=false;	
	private Dimension dim ;
    
    
	public fen_Labyrinthe(Start Menu) {
		
		dim = Toolkit.getDefaultToolkit().getScreenSize();
		int d=dim.height-60;			// Création des variables nécessaires à l'adaptation de l'interface à l'écran de l'utilisateur
		int c=d-d/3; 					// Hauteur disponible en prenant en compte les espaces
		int h=(int)(c/9);				// Donne hauteur des boutons
		int esp= (int)(d*3/100); 		// Taille espacement
		
		this.setTitle("Jeu Smashing buttons");
		this.setBounds (300,0,1000,d);
		this.setResizable(false);	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Score = new JButton ("Score");		
		Font pol = new Font(" Arial ",Font.BOLD + Font.PLAIN,25);
		Score.setFont(pol);
		Score.setBounds(20,7*esp+6*h,150,h);
		Score.setBackground(Color.red);
		//jsp comment faire pour avoir un petit encadré avec genre les pièces récupérés sur le chemin pour le score
		
		TimerLabel = new JLabel ("Timer");
		TimerLabel.setFont(pol);
		TimerLabel.setBounds(20,8*esp+7*h,150,h);
		TimerLabel.setBackground(Color.black);
		TimerLabel.setForeground(Color.red);
		TimerLabel.setOpaque(true);
		TimerLabel.setHorizontalAlignment(JLabel.CENTER);
		TimerLabel.setVerticalAlignment(JLabel.CENTER);
		       
        Jouer =new JButton("Jouer");
        Font poli = new Font(" Arial ",Font.BOLD + Font.PLAIN,20);   
        Jouer.setFont(poli);  
        Jouer.setBounds(50,5*esp+4*h,100,h); 
        Jouer.addActionListener(this);
        //Jouer.addKeyListener(this);
		
		File ImAvatar1 = new File("ImAvatar1.png");
		File ImAvatar2 = new File("ImAvatar2.png");
		File ImAvatar3 = new File("ImAvatar3.png");
		File ImAvatar4 = new File("ImAvatar4.png");
		
		Avatar1 = new JButton(new ImageIcon(new ImageIcon(ImAvatar1.getAbsolutePath()).getImage().getScaledInstance(50,60, Image.SCALE_DEFAULT)));	
		Avatar1.setBounds(20,2*esp+h,60,h);	
		Avatar1.addActionListener(this);
        //Avatar1.addKeyListener(this);
        
		Avatar2 = new JButton(new ImageIcon(new ImageIcon(ImAvatar2.getAbsolutePath()).getImage().getScaledInstance(50,60, Image.SCALE_DEFAULT)));	
		Avatar2.setBounds(115,2*esp+h,60,h);	
		Avatar2.addActionListener(this);
        //Avatar2.addKeyListener(this);
        
        Avatar3 = new JButton(new ImageIcon(new ImageIcon(ImAvatar3.getAbsolutePath()).getImage().getScaledInstance(50,60, Image.SCALE_DEFAULT)));	
		Avatar3.setBounds(20,3*esp+2*h,60,h);	
		Avatar3.addActionListener(this);
        //Avatar3.addKeyListener(this);
        
        Avatar4 = new JButton(new ImageIcon(new ImageIcon(ImAvatar4.getAbsolutePath()).getImage().getScaledInstance(50,60, Image.SCALE_DEFAULT)));	
		Avatar4.setBounds(115,3*esp+2*h,60,h);
		Avatar4.addActionListener(this);
        //Avatar4.addKeyListener(this);

		
		JLabel Titre = new JLabel ("<html>"+" Choisissez un avatar"+"<br>"+""+"<html>");
		Font police = new Font(" Arial ",Font.BOLD + Font.PLAIN,18);
		Titre.setFont(police);
		Titre.setBounds(0,esp,200,h);
		Titre.setHorizontalAlignment(JLabel.CENTER);
		Titre.setVerticalAlignment(JLabel.CENTER);
		
		Labyrinthe = new JLayeredPane();
		Labyrinthe.setLayout(null);
		Labyrinthe.setBounds(0,0,800,dim.height-100);	
		Labyrinthe.setBackground(Color.black);
				
		taille = new ComboBox(Labyrinthe);
		
        //Ajout de tous les éléments au panel Infos puis au panel "principal" Conteneur
		JPanel Infos = new JPanel();
		Infos.setLayout(null);
		Infos.setBounds(800,0,200,dim.height-100);
		Infos.add(Titre);
		Infos.add(Score);
		Infos.add(TimerLabel);
        Infos.add(Jouer);
		Infos.add(Avatar1);
		Infos.add(Avatar2);
		Infos.add(Avatar3);
		Infos.add(Avatar4);
		Infos.add(taille.p);
		
		Conteneur = new JPanel();
		Conteneur.setLayout(null);
		Conteneur.setBounds(0,0,1000,dim.height-100);
		Conteneur.add(Labyrinthe);
		Conteneur.add(Infos);
        
		
		//addKeyListener(this); 			// Je demande à ce que ce soit ma fenetre qui intercepte les touches du clavier
		this.add(Conteneur);
        this.requestFocusInWindow();
		setVisible(true);

	}
    
    //je n'ai pas réussi à faire des ecouteurs à part, ca compile pas mais essayez à votre tour si vous y arrivez
    public void actionPerformed ( ActionEvent e){      
        if(e.getSource() == Score){		//Indique les modalités d'obtention des points 
			msg1.showMessageDialog(null,"Lorsque vous atteignez la sortie d'un labyrinthe, vous gagnez 1 point. \n Si vous empruntez le chemin le plus court, vous gagnez 3 points","Information", JOptionPane.INFORMATION_MESSAGE);
		}
		
		if((e.getSource() == Avatar1) && (joueurAffiche == 0 )&& (Lab != null)){		//Placement de l'image du personnage suivant le bouton appuyé si aucun personnage n'est présent sur l'écran et si un labyrinthe est affiché 
			File ImAvatar1= new File("ImageAvatar1.png");
			j.Image = new JLabel(new ImageIcon(new ImageIcon(ImAvatar1.getAbsolutePath()).getImage().getScaledInstance(800/largeur,800/hauteur, Image.SCALE_DEFAULT)));	
			j.Image.setBounds(j.l*800/Lab[0].length,j.c*(dim.height-100)/Lab.length,1000/Lab[0].length,1000/Lab.length); 
			Labyrinthe.add(j.Image);
			Labyrinthe.moveToFront(j.Image);
            repaint();
            joueurAffiche = 1; 
		}
        if((e.getSource() == Avatar2) && (joueurAffiche == 0 )&& (Lab != null)){		//Placement de l'image du personnage suivant le bouton appuyé si aucun personnage n'est présent sur l'écran et si un labyrinthe est affiché 
			File ImAvatar2= new File("ImageAvatar2.png");
			j.Image = new JLabel(new ImageIcon(new ImageIcon(ImAvatar2.getAbsolutePath()).getImage().getScaledInstance(800/largeur,900/hauteur, Image.SCALE_DEFAULT)));	
			j.Image.setBounds(j.l*800/Lab[0].length,j.c*(dim.height-100)/Lab.length,1000/Lab[0].length,1000/Lab.length);	
            Labyrinthe.add(j.Image);
			Labyrinthe.moveToFront(j.Image);
            repaint();
            joueurAffiche = 2; 
		}
        if((e.getSource() == Avatar3) && (joueurAffiche == 0 )&& (Lab != null)){		//Placement de l'image du personnage suivant le bouton appuyé si aucun personnage n'est présent sur l'écran et si un labyrinthe est affiché 
			File ImAvatar3= new File("ImageAvatar3.png");
			j.Image = new JLabel(new ImageIcon(new ImageIcon(ImAvatar3.getAbsolutePath()).getImage().getScaledInstance(800/largeur,800/hauteur, Image.SCALE_DEFAULT)));	
			j.Image.setBounds(j.l*800/Lab[0].length,j.c*(dim.height-100)/Lab.length,1000/Lab[0].length,1000/Lab.length);
			Labyrinthe.add(j.Image);
			Labyrinthe.moveToFront(j.Image);
            repaint();
            joueurAffiche = 3; 
		}
		if((e.getSource() == Avatar4) && (joueurAffiche == 0 )&& (Lab != null)){		//Placement de l'image du personnage suivant le bouton appuyé si aucun personnage n'est présent sur l'écran et si un labyrinthe est affiché 
			File ImAvatar4= new File("ImageAvatar4.png");
			j.Image = new JLabel(new ImageIcon(new ImageIcon(ImAvatar4.getAbsolutePath()).getImage().getScaledInstance(800/largeur,900/hauteur, Image.SCALE_DEFAULT)));	
			j.Image.setBounds(j.l*800/Lab[0].length,j.c*(dim.height-100)/Lab.length,1000/Lab[0].length,1000/Lab.length);
			Labyrinthe.add(j.Image);
			Labyrinthe.moveToFront(j.Image);
            repaint();
            joueurAffiche = 4; 
		}
        if(e.getSource() == Jouer){
			try{
				String s = taille.getIndex()+".txt";
				LectureText lab = new LectureText(s);		//Initialisation du nouveau labyrinthe
				if(lab.fichierBon ==false){					//Informe l'utilisateur de l'erreur
                    if( lab.Colonne != 0  ){
						msg3.showMessageDialog(null, "Erreur de lecture ! Le fichier txt n'est pas correct. \n Le chiffre situe a la ligne "+ (lab.Ligne) + " et a la colonne "+ (lab.Colonne) + " n'est pas conforme.","Erreur", JOptionPane.ERROR_MESSAGE);
					}else if (lab.nbSortie != 1 && lab.nbSortie != 0){
						msg4.showMessageDialog(null, "Erreur de lecture ! Le fichier txt n'est pas correct. \n Le nombre de sorties indiqué n'est pas egal a 1.","Erreur", JOptionPane.ERROR_MESSAGE);
					}else if ( lab.nbEntree != 1){
						msg5.showMessageDialog(null, "Erreur de lecture ! Le fichier txt n'est pas correct. \n Le nombre d'entree indiqué n'est pas egal a 1.","Erreur", JOptionPane.ERROR_MESSAGE);
					}else if ( lab.nbLigneFausse == lab.haut){
						msg6.showMessageDialog(null, "Erreur de lecture ! Le fichier txt n'est pas correct. \n Le nombre de colonnes total n'est pas celui indique sur la premiere ligne du fichier txt. ","Erreur", JOptionPane.ERROR_MESSAGE);
					}else if ( lab.Ligne != 0){
						msg7.showMessageDialog(null, "Erreur de lecture ! Le fichier txt n'est pas correct. \n Le nombre de caracteres de la ligne "+ (lab.Ligne) +" n'est pas celui indique sur le premiere ligne.","Erreur", JOptionPane.ERROR_MESSAGE);
					}else {
						msg8.showMessageDialog(null, "Erreur de lecture ! Le fichier txt n'est pas correct. \n Le nombre de lignes total n'est pas celui indiqué sur la premiere ligne du fichier txt. ","Erreur", JOptionPane.ERROR_MESSAGE);
					}
				}else if (lab.fichierBon ==true){
					Labyrinthe.removeAll();
					taille.actionPerformed(e);			// Lance l'affichage du labyrinthe 
					Lab = lab.tab;
					hauteur = lab.haut;
					largeur = lab.larg;	
					joueurAffiche = 0;					//Initialisation des différents paramètres pour pouvoir enchaîner les parties 
					fenetreFinAffiche =false ;	
					TimerLabel.setText("Timer");
					j =new joueur(lab.ligneDepart,lab.colonneDepart); //Placement du personnage à l'entrée du labyrinthe
					j.c = lab.colonneDepart;				
					j.l =lab.ligneDepart;
					repaint();
				}
					
			} catch (FileNotFoundException s) {		// Conditions pour ne pas lire une ligne vide et s'arrêter à la fin de la ligne
				s.printStackTrace();
				msg9.showMessageDialog(null, "Le fichier txt contenant le labyrinthe n'a pas ete trouve !","Erreur", JOptionPane.ERROR_MESSAGE);
			} catch (IOException s) {
				s.printStackTrace();
			}
			
		}
	}
    
	public void finDeJeu (){
			
			CompteurPoints();		//Compte les points du joueur 
			
			JFrame fin = new JFrame("Partie finie");		//Crée la fenêtre de fin 
			fin.setBounds(400,150,650,550);
			fin.setResizable(false);	
			
			JLabel Titre = new JLabel (" Vous avez atteint la sortie du labyrinthe ! GG! ");
			Font police = new Font(" Cambria ",Font.BOLD + Font.PLAIN,18);
			Titre.setFont(police);
			Titre.setBounds(70,20,500,50);
			
			fin.setLayout(null);
			
			fin.add(Titre);
			fin.setVisible(true);
			
			fenetreFinAffiche =true ; 
			
			Score.setText("Felicitations ! Votre score est actuellement de: "+compteurPoint);	//Met à jour le bouton score 
			Font pol = new Font(" Arial ",Font.BOLD + Font.PLAIN,18);
			Score.setFont(pol);
		}
		
	public void CompteurPoints (){
	}
		

    
    public void paint(Graphics g){
		   super.paint(g);
	}
    
	
}

