import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.util.LinkedList;
import javax.swing.ImageIcon;

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
    private JLabel labelPseudo;
    private JTextField champSaisiePseudo;
    
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
        
        labelPseudo = new JLabel("Pseudo :");
        champSaisiePseudo = new JTextField("",20);
        
        bouton2 = new JButton ("Avatar");
        bouton3 = new JButton ("Jouer");
        fen_Jeu = new Fenetre_Jeu(this);
        bouton2.addActionListener(new Ecouteur2(this));
        bouton3.addActionListener(new Ecouteur3(this));
    
        
        JPanel conteneurPrincipal1 = new JPanel();
        conteneurPrincipal1.setBackground(Color.MAGENTA);
        this.add(conteneurPrincipal1);
        conteneurPrincipal1.add(labelPseudo);
        conteneurPrincipal1.add(champSaisiePseudo);
        
        JPanel conteneurPrincipal2 = new JPanel();
        conteneurPrincipal2.setBackground(Color.MAGENTA);
        this.add(conteneurPrincipal2);
        conteneurPrincipal2.add(bouton2);
        conteneurPrincipal2.add(bouton3);


    //Menus déroulants      
        this.test1.add(item1);
        this.test1.add(item2);
        this.test1.add(item3);  

        this.test2.add(item4);
        this.test2.add(item5);
    
    
    //Rendre la fenêtre visible
        this.setVisible(true);
  }
}
