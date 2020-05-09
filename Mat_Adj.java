import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.io.File;
import java.io.*;
import java.util.* ; 
import javax.swing.JOptionPane;


	public class Mat_Adj {
	
		int[] sommetsAEmprunter;
        
        private JOptionPane jop2;
        private JOptionPane jop3;
	
		public Mat_Adj( int[][]lab ){
		
			int nbsommets=0;
				for( int i=0; i<lab.length; i++){	//Compte le nombre de sommets du labyrinthe (cases où il est possible de se déplacer)
					for ( int j=0; j< lab[0].length; j++){
						if (lab[i][j]==0 || lab[i][j]==3  || lab[i][j]==2){
							nbsommets=nbsommets+1;
						}
					}
				}	
			
			int [][] matAdj= LabToMatrice(lab);			// Création de la matrice d'adjacence correspondant au labyrinthe
			
			int [] col = new int [nbsommets];
			col[0]=1;
			for ( int i=1; i<col.length; i++){
				col[i]=0;					//Tous les sommets sont blancs, donc non visités, sauf le tout premier
			}	
			int	[] d = new int [nbsommets];
			d[0]=0;
			for (int j=1; j<d.length; j++){			//Initialise la distance au sommet très grande
				d[j]=nbsommets+1;
			}
			int [] Pi= new int [nbsommets*nbsommets];
			int sommet=0;
			int nbsommetsrelies=-1;
			int nbRep = 0;
			while(col[col.length-1]==0 && nbRep< nbsommets*2){	// Tant que le dernier sommet n'a pas été découvert ou si le nombre de répétition est trop important 
				nbRep++;
				int dmin=nbsommets+1;
				for (int i =0; i< nbsommets; i++){
					if ( d[i]< dmin && col[i]==1){	// Condition départ : trouve un sommet gris dont la distance au départ est la plus petite possible 
						dmin=d[i];
						sommet =i;
					} 
				}
				for( int j =0; j<matAdj[sommet].length; j++){
					if (matAdj[sommet][j] ==1  && col[j]!=2){ // Vérifie s'il existe bien un chemin entre notre sommet et le sommet j et si la case n'a pas été découverte 
						nbsommetsrelies= nbsommetsrelies+1;	 
						if( col[j]==0){
							col[j]=1;
						}					
						Pi[nbsommetsrelies]=sommet;						//Retient les sommets visités 
						if ( d[j] > d[sommet]+matAdj[sommet][j]){		//Mise à jour de la distance au départ 
							d[j]= d[sommet]+matAdj[sommet][j];			
						}			 
					}
				}
				col[sommet]=2;
			}
			if(nbRep == nbsommets*2 ){	
                jop2 = new JOptionPane();
				jop2.showMessageDialog(null, "Votre labyrinthe ne possede aucune sortie !","Erreur", JOptionPane.ERROR_MESSAGE);
			} else{
			
				sommetsAEmprunter= new int [nbsommets];						
				sommetsAEmprunter[0]=nbsommets-1;
				int dernierecase= sommetsAEmprunter[0];
				int dmini = d[sommetsAEmprunter[0]];
				int nbValPi=1;
				int compteur=0;
				while (Pi[nbValPi] != 0){		//Compte le nombre de sommets retenus
					nbValPi=nbValPi+1;
				}
				int nbRep2 =0;
				while ( dernierecase!= 0 && nbRep2 < nbValPi*10){  //Tant que l'on a pas atteint le départ ou tant que l'on est pas bloqué dans la boucle 
					nbRep2++;
					for ( int h=nbValPi; h>0; h--){
						if ( matAdj[dernierecase][Pi[h]]==1){
							if(d[Pi[h]]< dmini){					// Si la distance à l'entrée est plus faible que la distance minimale actuelle 
								dmini=d[Pi[h]];
								dernierecase=Pi[h];
								if ( dernierecase != sommetsAEmprunter[compteur]){
									compteur = compteur +1;
									sommetsAEmprunter[compteur]=dernierecase;			//Conserve dans le tableau le numéro des sommets à emprunter 
								}
							}
						}
					}
				}
				if(nbRep2 == nbValPi*10){
                    jop3 = new JOptionPane();
					jop3.showMessageDialog(null, "Votre labyrinthe possede beaucoup trop de possibilites !","Erreur", JOptionPane.ERROR_MESSAGE);
					sommetsAEmprunter= null;			//Suppression du tableau pour éviter le dessin d'un début de chemin 
				}
			}
	}
	public static int [][] LabToMatrice (int [][] lab1) {
		
		int nbsommets=0;
		int[][]lab2= new int [lab1.length][lab1[0].length];
		int c=-1; // sauvegarde le numéro du sommet			   
		for (int i=0; i<lab1.length; i++){
			for ( int j=0; j<lab1[i].length; j++){
				if (lab1[i][j]!=1 ){ 				// Si c'est un passage, donc un sommet de notre matrice d'adjacence 
					nbsommets= nbsommets+1;
					c=c+1;
					lab2[i][j]=c;					// On numérote chaque sommet
				}else {
					lab2[i][j]=-1;					// Avec 1, cela ne fonctionne pas car 1 correspond déjà à un numéro de sommet
				}
			}
		}
		
		int[][]matAdj=new int [nbsommets][nbsommets];
		
		for ( int i=0; i<lab2.length; i++){
			for ( int j=0; j<lab2[i].length; j++){
				if ( lab2[i][j]!=-1){				//Si c'est bien un sommet
						if  (i!=lab2.length-1){		//Vérifie la possibilité d'accès aux voisins 
							if (lab2[i+1][j]!=-1 ){		
								matAdj[lab2[i][j]][lab2[i+1][j]]=1;
								matAdj[lab2[i+1][j]][lab2[i][j]]=1;
							}
						}
						if (i!=0){
							if( lab2[i-1][j]!=-1 ){
								matAdj[lab2[i][j]][lab2[i-1][j]]=1;
								matAdj[lab2[i-1][j]][lab2[i][j]]=1;
							}
						}
						if ( j!= lab2[i].length-1){
							if(lab2[i][j+1]!=-1){
								matAdj[lab2[i][j]][lab2[i][j+1]]=1;
								matAdj[lab2[i][j+1]][lab2[i][j]]=1;
							}	
						}
						if (j!=0){
							if(lab2[i][j-1]!=-1){
								matAdj[lab2[i][j]][lab2[i][j-1]]=1;
								matAdj[lab2[i][j-1]][lab2[i][j]]=1;
							}
								
						}
					}
				}
			}
			for(int i=0; i< matAdj.length; i++){
				for ( int j=0; j<matAdj[i].length; j++){
					if ( j==i){
					matAdj[i][j]=0;	// Pas de passage (on ne peut pas aller d'une case à elle-même)
					}
				}
			}
			return matAdj;	
		}
	
}
