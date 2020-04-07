import java.awt.*;
import javax.swing.*;
import java.util.*;


public class Fenetre_Jeu extends JFrame{
    
    //Declaration des attributs de la fenetre
    private JMenuBar menuBar = new JMenuBar();
    private JMenu test1 = new JMenu("Fichier");
    private JMenu test2 = new JMenu("Menu");

    private JMenuItem item1 = new JMenuItem("Sauvegarder");
    private JMenuItem item2 = new JMenuItem("Restaurer");
    private JMenuItem item3 = new JMenuItem("Quitter");
    private JMenuItem item4 = new JMenuItem("Suspendre");
    private JMenuItem item5 = new JMenuItem("Reprendre");
    
    //Declaration des elements graphiques de la fenetre
    
    
    /**
     * Constructeur de la classe Fenetre_Jeu
     */
    public Fenetre_Jeu(Fenetre_Menu Menu){
        
        super("Smashing buttons");
        this.setSize(600,200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        JPanel conteneurPrincipal = new JPanel (new FlowLayout());
        conteneurPrincipal.setBackground(Color.WHITE);
        
        this.add(conteneurPrincipal);
        
        
        //Menus déroulants      
        this.test1.add(item1);
        this.test1.add(item2);
        this.test1.add(item3);  

        this.test2.add(item4);
        this.test2.add(item5);

        this.menuBar.add(test1);
        this.menuBar.add(test2);
        this.setJMenuBar(menuBar);
        
        // Rendre fenetre visible
        this.setVisible(true);
    }
    
}
    











