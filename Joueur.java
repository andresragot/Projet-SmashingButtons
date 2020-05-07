import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import javax.swing.ImageIcon;

public class Joueur{
    //attributs
    private int c; //Numero de colonne dans le plateau
    private int l; //Numero de ligne dans le plateau
    private int x0; //Numero de colonne de la position initale du joueur
    private int y0; //Numero de ligne de la position initiale du joueur
    private boolean sorti; //Affiche true si le joueur a atteint la CASE_ARRIVEE
    private int nbLignes;
    private int nbColonnes;
    private Plateau labyrinthe;
    private int PV; // Nombre de points de vie du joueur
    public boolean enVie; //Represente si le joueur est vivant ou non, true => vivant, false => mort
    public String nomPerso;
    

    //Constructeur
    public Joueur(Plateau laby){
        // initialisation des attributs
        labyrinthe=laby;
        int[][] maCarte=labyrinthe.getCarte();
        nbLignes = maCarte.length;
        nbColonnes = maCarte[0].length;
        sorti=false;
        PV=2;
        
        // Recherche des coordonnées de départ sur la carte pour initialiser c et l         
        for(int i=0;i<maCarte.length;i++){
            for(int j=0;j<maCarte[i].length; j++){
                if(maCarte[i][j]==2){
                    c=j;
                    l=i;
                }
            }
        }
        
    }
    
    
    public boolean aGagné(){ //Le joueur a atteint la CASE_ARRIVEE
        return sorti;
    }
    
    public void sortir(){
        sorti=true;
    }    
    
    // Deplacements du joueur
    public void setDepart() { 
        c=x0;
        l=y0;
    }
    
    public void bouger(int deltaC, int deltaL) {
        if((enVie==true) & !sorti){
            int newC=c+deltaC;
            int newL=l+deltaL;

            if(labyrinthe.getCarte()[newL][newC] == Plateau.CASE_MUR) {
                System.out.println("Présence d'un mur, déplacement impossible");
            } else {
                c=newC;
                l=newL;

                if(labyrinthe.getCarte()[l][c] == Plateau.CASE_ARRIVEE) {
                    sortir();
                    System.out.println("Bravo! Vous avez réussi ce niveau!");
                }
            }
        }
    }
    
    //Methode mettant à jour les points de vie du joueur
    public void modifPV(int modif){
        PV=PV+modif;
    }
    
    /**
    @param g Surface sur laquelle se dessiner
    @param w Largeur de la surface
    @param h Hauteur de la surface
    */
    public void dessiner(Graphics g, int w, int h) { //remplacer par drawimage
        int x1 = c*w/nbColonnes;
        int y1 = l*h/nbLignes;

        if(enVie ==true) {
            g.setColor(Color.BLUE);
        } else {
            g.setColor(Color.DARK_GRAY);
        }
        g.fillOval(x1,y1,w/nbColonnes,h/nbLignes);
    }
    
    /*public paintComponent(Graphics g, int w, int h){
        int x1 = c*w/nbColonnes;
        int y1 = l*h/nbLignes;
        super.paintComponent(g);
        g.drawImage(player,100,75, null);
    }*/
    
    /**
     * Getter pour la variable c
     * @return c int : colonne où se trouve le joueur
     */
    public int getC(){
        return this.c;
    }

    /**
     * Getter pour la variable l
     * @return l int : ligne où se trouve le joueur
     */
    public int getL(){
        return this.l;
    }  
    
    /**
     * Getter pour la variable PV
     * @return PV int : nombre de points de vie du personnage
     */
    public int getPV(){
        return this.PV;
    }

     /**
     * Setter pour la variable PV
     * @param pv int: Met à jour le nombre de points de vie du personnage
     */
    public void setPV( int pv){
    	if(pv <= 0){
    		this.PV = 0;
    		this.enVie= false;
    	}else{
    		this.PV=pv;
        }
    }

    /**
     * toString
     */
     public String toString() {
        return "Joueur: "+this.nomPerso+"\nPoints de vie: "+this.PV;
     }

}
