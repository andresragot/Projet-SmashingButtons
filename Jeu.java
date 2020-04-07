public class Jeu {

	private int[][] Level1 = { {0,0,0,0,0,0,0,0,0} , 
                        {0,2,0,0,0,0,1,1,0} ,
                        {0,1,0,1,1,0,1,1,0} ,
                        {0,1,1,1,1,1,0,1,0} ,
                        {0,0,0,1,1,0,0,1,0} ,
                        {0,1,1,1,1,1,1,1,3} ,
                        {0,0,0,0,0,0,0,0,0} };
                    
	private int[][] Level2 = { {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0} ,
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
 	
	public int ligne;
	public Joueur joueur;
	public int niveauActuel;
	public int colonne;
	public int[][] plateau;
	public int[] hello;


	public int comptePoint(){
		return 2;
	}
	
	public void addEntite(Entite type){
	}

	public void bouger(int x, int y){
	}
	
	public boolean colision(){
		return false;
	}
	

	public boolean bougerPossible(int x, int y){
		return true;
	}

	public void enleverV(Joueur J){
		int PV = J.getPV()-1;
		J.setPV(PV);
	}

	public int[] positionDepart(int i){
		return hello;
	}

	public boolean JeuFini(Joueur J){
		return J.getPV()==0;
	}

	public void playSound(String sound){
	}
	
}

