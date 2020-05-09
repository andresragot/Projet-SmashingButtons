import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.io.File;
import java.awt.Color;


public class Start extends JFrame {
	
    //Declaration des éléments graphiques de la fenetre
    private JLabel labelPseudo;
    private JTextField champSaisiePseudo;
    
    private JLabel fondEcran;
    private JLabel Bienvenue;
	private JLabel Title;
    
    private JPanel panneauPrincipal;
    
    private JButton Entree;

    /**
     * Constructeur de la classe Start
     */
    public Start(){        
        this.setTitle("Menu Principal");
        this.setSize(500,600);
        this.setResizable(false); // empeche l'utilisateur de redimensionner la fenetre
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null); // la fenêtre est centrée à l'écran
        
        Entree = new JButton ("Jouer");
        Entree.setBounds(148,495,200,70); //permet l'emplacement du coin supérieur gauche setBounds(int x, int y, int largeur, int hauteur)
        Entree.setBackground(Color.pink);
        Entree.addActionListener(new Ecouteur_Entree(this));
                
        File ImageFond = new File("fond_hori.jpg");
		
		ImageIcon icon = new ImageIcon(new ImageIcon(ImageFond.getAbsolutePath()).getImage().getScaledInstance(500, 600, Image.SCALE_DEFAULT));
        
        fondEcran = new JLabel (icon);
		fondEcran.setBounds(0,0,500,600);
        
        Bienvenue = new JLabel();
		Bienvenue.setBounds(55,10,400,50);
		Font police1 = new Font("Cambria",Font.BOLD + Font.ITALIC,30);
		Bienvenue.setFont(police1);
        //Bienvenue.setForeground(Color.RED);
        Bienvenue.setText("<html> <font color=yellow> Bienvenue dans </font> </html>" );
        Bienvenue.setHorizontalAlignment(JLabel.CENTER);
		
		Title = new JLabel();
        Title.setBounds(50,50,400,50);
		Font police2 = new Font("Cambria",Font.BOLD + Font.ITALIC,30);
		Title.setFont(police2);
        Title.setText("<html> <font color='yellow'> Smashing buttons </font> </html>" );
        Title.setHorizontalAlignment(JLabel.CENTER);
        
    //Ajout de tous les éléments au panneau principal
        panneauPrincipal = new JPanel(new BorderLayout());
        panneauPrincipal.setBackground(Color.WHITE);
        panneauPrincipal.add(Bienvenue);
        panneauPrincipal.add(Title);
        panneauPrincipal.add(Entree);
        panneauPrincipal.add(fondEcran);
        this.add(panneauPrincipal);
     
    
    //Rendre la fenêtre visible
        this.setVisible(true);
    }
	
}
