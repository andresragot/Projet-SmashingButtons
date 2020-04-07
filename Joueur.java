public class Joueur extends Entite{
    
    public boolean enVie = true; //Represente si le joueur est vivant ou non, true => vivant, false => mort
    private int PV; // Nombre de points de vie du joueur
    public String nomPerso;
    //public int deplacement; nombre de case où le joueur peut se déplacer en 1 tour (dans toute une ligne ou toute une colonne)

    
    public Joueur(String nomPerso, int x, int y, int Haut, int Larg, int PV){
        super(x,y, Haut, Larg);
        this.PV=PV;
        this.nomPerso=nomPerso;
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
    	if(pv <= 0)
    	{
    		this.PV = 0;
    		this.enVie= false;
    	}
    	else
    		this.PV=pv;
    }

    /**
     * toString
     */
     public String toString() {
    	 return "Joueur: "+this.nomPerso+"\nPoints de vie: "+this.PV;
     }
     


}
