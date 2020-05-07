import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import javax.swing.ImageIcon;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Plateau extends JPanel{
        
    private Image Vide;
    private Image Mur;
    private Image Arrivee;
    private Image Depart;
    
    private final int[][] CARTE = {        
        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
        {1,0,0,0,0,0,0,1,0,0,0,0,0,0,3,1},
        {1,0,0,0,1,0,0,1,0,0,0,1,1,0,1,1},
        {1,0,0,1,0,1,0,0,0,0,1,1,0,0,0,1},
        {1,0,0,1,0,0,0,0,0,0,0,1,1,0,0,1},
        {1,2,0,1,0,0,0,0,0,0,0,0,0,0,0,1},
        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
    };
        
    // Création des objets du labyrinthe qu'on place dans une liste
    private Clavier key;
    
    public Clavier getClavier(){
        return key;
    }
    
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
        
        File ImageMur= new File("mur.png");
        File ImageVide = new File("vide.png");
        File ImageSortie= new File("arrivee.png");
        //File ImageDepart = new File("depart.png");
        try{
            Mur = ImageIO.read(new File(ImageMur.getAbsolutePath()));
            Vide = ImageIO.read(new File(ImageVide.getAbsolutePath()));
            Arrivee = ImageIO.read(new File(ImageSortie.getAbsolutePath()));
        } catch(IOException e){
            e.printStackTrace();
        }
        add(new JLabel(new ImageIcon(Mur)));
        add(new JLabel(new ImageIcon(Vide)));
        add(new JLabel(new ImageIcon(Arrivee)));
    }
    
    
    public void paint(Graphics g) {
        super.paint(g);
        int haut = getHeight();
        int larg = getWidth();
        
        for(int i=0;i<CARTE.length;i++) {
        int y1 = i*haut/CARTE.length;
        int h = haut/CARTE.length;
        for(int j=0;j<CARTE[0].length;j++) {
            if (CARTE[i][j]==0) {
                //g.setColor(COULEUR_CASE_VIDE);
                g.drawImage(Vide,0,0,null);
            } else if(CARTE[i][j]==1) {
                g.drawImage(Mur,0,0,null);
            } else if(CARTE[i][j]==2) {
            } else if(CARTE[i][j]==3) {
                g.drawImage(Arrivee,0,0,null);
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
