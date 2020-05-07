import java.awt.*;
import javax.swing.*;
import java.util.*;
import javax.imageio.*;
import java.io.File;
import javax.swing.ImageIcon;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Fenetre_Menu extends JFrame {
    
    //Declaration des éléments graphiques de la fenetre
    private JLabel labelPseudo;
    private JTextField champSaisiePseudo;
    
    private JLabel fondEcran;
    private JLabel Bienvenue;
	private JLabel Title;
    
    private JPanel panneauPrincipal;
    
    private JButton Jouer;

    /**
     * Constructeur de la classe Fenetre_Menu
     */
    public Fenetre_Menu(){        
        this.setTitle("Menu Principal");
        this.setSize(500,600);
        this.setResizable(false); //empeche l'utilisateur de redimensionner la fenetre
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);        
        
        /*labelPseudo = new JLabel("Pseudo :");
        champSaisiePseudo = new JTextField("",20);*/
        
        Jouer = new JButton ("Jouer");
        Jouer.setBounds(125,490,250,70); //permet l'emplacement du coin supérieur gauche setBounds(int x, int y, int largeur, int hauteur)
        Jouer.setBackground(Color.orange);
        Jouer.addActionListener(new Ecouteur3(this));
                
        File ImageFond = new File("fond_hori.jpg");
		
		ImageIcon icon = new ImageIcon(new ImageIcon(ImageFond.getAbsolutePath()).getImage().getScaledInstance(500, 600, Image.SCALE_DEFAULT));
        
        fondEcran = new JLabel (icon);
		fondEcran.setBounds(0,0,500,600);
        
        /*fondEcran = new JLabel();
        ImageIcon fond = new ImageIcon(this.getClass().getResource("fond_hori.jpg"));
        fondEcran.setIcon(fond);
        fondEcran.setVisible(true);
        panneauPrincipal.add(fondEcran);*/
        
        Bienvenue = new JLabel("Bienvenue dans");
		Bienvenue.setBounds(50,20,400,50);
		Font police1 = new Font(" Cambria ",Font.BOLD + Font.PLAIN,30);
		Bienvenue.setFont(police1);
        Bienvenue.setHorizontalAlignment(JLabel.CENTER);
		
		Title = new JLabel("Smashing Buttons");
        Title.setBounds(50,70,400,50);
		Font police2 = new Font("Cambria ",Font.BOLD + Font.PLAIN,30);
		Title.setFont(police2);
        Title.setHorizontalAlignment(JLabel.CENTER);
        
    //Ajout de tous les éléments au panneau principal
        panneauPrincipal = new JPanel(new BorderLayout());
        panneauPrincipal.setBackground(Color.WHITE);
        panneauPrincipal.add(Bienvenue);
        panneauPrincipal.add(Title);
        panneauPrincipal.add(Jouer);
        panneauPrincipal.add(fondEcran);
        this.add(panneauPrincipal);
        //panneauPrincipal.add(labelPseudo);
        //panneauPrincipal.add(champSaisiePseudo);    
    
    //Rendre la fenêtre visible
        this.setVisible(true);
  }
}
