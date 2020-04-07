public class Plateau {
	
public int ligne;
public int niveauActuel;
public int colonne;
public int[][] plateau;

public int[][] Level1 = { {0,0,0,0,0,0,0,0,0} , 
                        {0,2,0,0,0,0,1,1,0} ,
                        {0,1,0,1,1,0,1,1,0} ,
                        {0,1,1,1,1,1,0,1,0} ,
                        {0,0,0,1,1,0,0,1,0} ,
                        {0,1,1,1,1,1,1,1,3} ,
                        {0,0,0,0,0,0,0,0,0} };
                    
public int[][] Level2 = { {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0} ,
                        {0,0,0,1,0,1,1,0,1,1,1,1,1,1,0} ,
                        {0,1,0,1,1,1,1,0,1,0,0,0,1,1,0} ,
                        {0,1,1,1,1,0,1,0,1,1,1,0,1,1,0} ,
                        {0,1,0,0,0,0,1,0,1,1,1,0,1,1,0} ,
                        {0,1,1,1,1,0,1,0,1,1,1,0,1,1,0} ,
                        {0,0,0,1,1,0,1,1,0,1,0,1,1,1,0} ,
                        {0,2,1,1,0,1,1,1,0,1,0,1,1,0,0} ,
                        {0,1,1,0,1,1,1,0,1,1,1,0,1,1,3} ,
                        {0,1,1,0,1,0,0,0,1,1,1,0,1,1,0} ,
                        {0,1,1,0,1,1,1,1,1,0,1,1,0,0,0} ,
                        {0,1,1,1,0,1,0,1,1,0,1,1,1,0,0} ,
                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0} };
 
public void addEntite(Entite type){
}

public void bouger(int x, int y){
}

public boolean bougerPossible(int x, int y){
}

public void enleverV(Joueur J){
	int PV = J.getPV()-1;
	J.setPV(PV);
}

public int[] positionDepart(int i){
}	
	
	
}

