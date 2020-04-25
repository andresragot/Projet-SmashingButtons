import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Entite {
    // Attributs
    private Color maCouleur;
    private int x;
    private int y;
    private int nbLignes;
    private int nbColonnes;
    private int deltaVie;

    // Constructeur
    public Entite(int[][] carte, Color couleur, int Vie){
        x=0; 
        y=0;
        while(carte[y][x]!=Plateau.CASE_VIDE) {
            x = (int)(carte[0].length * Math.random());
            y = (int)(carte.length * Math.random());
        }

        maCouleur=couleur;
        deltaVie=Vie;
        nbLignes = carte.length;
        nbColonnes = carte[0].length;
    }


    public void Action(Joueur joueur){ 
        if(joueur.getX()==x && joueur.getY()==y){
            joueur.modifPV(deltaVie);
        }
    }

    public void dessiner(Graphics g,int w, int h){
        int x1 = x*w/nbColonnes;
        int y1 = y*h/nbLignes;

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
