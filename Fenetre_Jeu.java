import java.awt.*;
import javax.swing.*;
import java.util.*;
import javax.swing.ImageIcon;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


public class Fenetre_Jeu extends JFrame{
    
    //Declaration des elements graphiques de la fenetre
    private	JMenuBar barreMenus;
    
    private JMenu menu;
    
    private JMenuItem pause;
    private JMenuItem reprendre;
    private JMenuItem restaurer;

    
    //Declaration des attribus de la fenetre
    private Plateau labyrinthe;
    private Joueur j;
    
    /**
     * Constructeur de la classe Fenetre_Jeu
     */
    public Fenetre_Jeu(Fenetre_Menu Menu){
        
        super("Smashing buttons");
        labyrinthe = new Plateau();
        labyrinthe.setBackground(Color.BLACK);
        
        JPanel panneauPrincipal = new JPanel (new BorderLayout());
        panneauPrincipal.setBackground(Color.WHITE);
        panneauPrincipal.add(labyrinthe, BorderLayout.CENTER);
        
        this.setContentPane(panneauPrincipal);
        this.setSize(600,200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Creation barre des menus & son ajout sur la fenetre
        JMenuBar barreMenus = new JMenuBar();
        this.setJMenuBar(barreMenus);
    
        //creation du menu "Menu" et ses options
        JMenu menu = new JMenu("Menu");
        barreMenus.add(menu);
        JMenuItem pause = new JMenuItem("Pause");
        menu.add(pause);
        pause.addActionListener(new EcouteurMenu(this));
        JMenuItem reprendre = new JMenuItem("Reprendre");
        menu.add(reprendre);
        reprendre.addActionListener(new EcouteurMenu(this));
        JMenuItem restaurer = new JMenuItem("Restaurer");
        menu.add(restaurer);
        restaurer.addActionListener(new EcouteurMenu(this));
        
        /*public void paintComponent(Graphics g, int w, int h){
        int x1 = c*w/nbColonnes;
        int y1 = l*h/nbLignes;
        super.paintComponent(g);
        g.drawImage(player,100,75, null);
        }*/
        
        // Rendre fenetre visible
        this.setVisible(true);
    }

}











