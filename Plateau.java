import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import javax.swing.ImageIcon;

public class Plateau extends JPanel{
    // Constantes définissant le jeu
    public static final Color COULEUR_CASE_VIDE = Color.WHITE;
    public static final Color COULEUR_CASE_MUR = Color.BLACK;
    public static final Color COULEUR_CASE_DEPART = Color.LIGHT_GRAY;
    public static final Color COULEUR_CASE_ARRIVEE = Color.MAGENTA;

    public static final int CASE_VIDE = 0;
    public static final int CASE_MUR = 1;
    public static final int CASE_DEPART = 2;
    public static final int CASE_ARRIVEE = 3;
    
    private final int[][] CARTE = {            //compléter avec le truc d'Andres
        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
        {1,0,0,0,0,0,0,1,0,0,0,0,0,0,3,1},
        {1,0,0,0,1,0,0,1,0,0,0,1,1,0,1,1},
        {1,0,0,1,0,1,0,0,0,0,1,1,0,0,0,1},
        {1,0,0,1,0,0,0,0,0,0,0,1,1,0,0,1},
        {1,2,0,1,0,0,0,0,0,0,0,0,0,0,0,1},
        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
    };

    // Création des objets du labyrinthe qu'on place dans une liste
    private Joueur joueur;
    private LinkedList<Entite> listEntite;
    
    public Joueur getjoueur(){
        return joueur;
    }
    
    public int[][] getCarte(){
        return CARTE;
    }

    public Plateau() {
        joueur=new Joueur(this);        
        listEntite=new LinkedList<Entite>();
        listEntite.add(new Monstre1(CARTE)); //creation d'un monstre
        listEntite.add(new Etoile(CARTE)); // creation des etoiles bonus
        listEntite.add(new Pieces(CARTE)); // creation des pieces d'or
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int haut = getHeight();
        int larg = getWidth();

        for(int i=0;i<CARTE.length;i++) {
        int y1 = i*haut/CARTE.length;
        int h = haut/CARTE.length;
        for(int j=0;j<CARTE[0].length;j++) {
            if       (CARTE[i][j]==CASE_VIDE) {
                g.setColor(COULEUR_CASE_VIDE);
            } else if(CARTE[i][j]==CASE_MUR) {
            g.setColor(COULEUR_CASE_MUR);
            } else if(CARTE[i][j]==CASE_DEPART) {
            g.setColor(COULEUR_CASE_DEPART);
            } else if(CARTE[i][j]==CASE_ARRIVEE) {
            g.setColor(COULEUR_CASE_ARRIVEE);
            }
            int x1 = j*larg/CARTE[0].length;
            int l = larg/CARTE[0].length;
            g.fillRect(x1,y1,l,h);
            }
        }

        for(int i=0;i<listEntite.size();i++) { //permet d'afficher les objets de la liste Entite
             listEntite.get(i).dessiner(g,larg,haut);
        }

        joueur.dessiner(g,larg,haut);
    }
  
}
