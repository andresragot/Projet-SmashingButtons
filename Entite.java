import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Entite {
    // Attributs
    private Color maCouleur;
    private int c;
    private int l;
    private int nbLignes;
    private int nbColonnes;
    private int deltaVie;

    // Constructeur
    public Entite(int[][] carte, Color couleur, int Vie){
        c=0; 
        l=0;
        while(carte[l][c]!=Plateau.CASE_VIDE) {
            c = (int)(carte[0].length * Math.random());
            l = (int)(carte.length * Math.random());
        }

        maCouleur=couleur;
        deltaVie=Vie;
        nbLignes = carte.length;
        nbColonnes = carte[0].length;
    }


    public void Action(Joueur joueur){ 
        if(joueur.getC()==c && joueur.getL()==l){
            joueur.modifPV(deltaVie);
        }
    }

    public void dessiner(Graphics g,int w, int h){
        int x1 = c*w/nbColonnes;
        int y1 = l*h/nbLignes;

        int larg = w/nbColonnes;
        int haut = h/nbLignes;

        g.setColor(maCouleur);
        g.fillRect(x1,y1,larg,haut);
    }
    
    // Getters
    public int getNbLignes(){
        return nbLignes;
    
    }
    
    public int getNbColonnes(){
        return nbColonnes;
    }
}
