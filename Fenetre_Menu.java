import java.awt.*;
import javax.swing.*;
import java.util.*;

public class Fenetre_Menu extends JFrame {
    
    //Declaration des attributs de la fenetre
    private JMenuBar menuBar = new JMenuBar();
    private JMenu test1 = new JMenu("Fichier");
    private JMenu test2 = new JMenu("Jeu");

    private JMenuItem item1 = new JMenuItem("Sauvegarder");
    private JMenuItem item2 = new JMenuItem("Restaurer");
    private JMenuItem item3 = new JMenuItem("Quitter");
    private JMenuItem item4 = new JMenuItem("Suspendre");
    private JMenuItem item5 = new JMenuItem("Reprendre");


    //Declaration des éléments graphiques de la fenetre
    private JButton bouton1;
    private JButton bouton2;
    private JButton bouton3;
    private Fenetre_Jeu fen_Jeu;


    /**
     * Constructeur de la classe Fenetre_Menu
     */
    public Fenetre_Menu(){
        this.setTitle("Menu Principal");
        this.setSize(400,400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        
        bouton1 = new JButton ("Pseudo");
        bouton2 = new JButton ("Avatar");
        bouton3 = new JButton ("Jouer");
        fen_Jeu = new Fenetre_Jeu(this);
        bouton1.addActionListener(new Ecouteur1(this));
        bouton2.addActionListener(new Ecouteur1(this));
        bouton3.addActionListener(new Ecouteur1(this));

        
        JPanel conteneurPrincipal = new JPanel(new FlowLayout());
        conteneurPrincipal.setBackground(Color.GREEN);
        this.add(conteneurPrincipal);
        conteneurPrincipal.add(bouton1);
        conteneurPrincipal.add(bouton2);
        conteneurPrincipal.add(bouton3);


    //Menus déroulants      
        this.test1.add(item1);
        this.test1.add(item2);
        this.test1.add(item3);  

        this.test2.add(item4);
        this.test2.add(item5);

        this.menuBar.add(test1);
        this.menuBar.add(test2);
        this.setJMenuBar(menuBar);
    
    
    //Rendre la fenêtre visible
        this.setVisible(true);
  }
}
