public class Entite{
    
    //Propriétés caractérisant une entité
    private int x; 
    private int y; 
    private int Haut;
    private int Larg;
    private int nbEntites;
    
    //Constructeur
    public Entite(int x, int y, int Haut, int Larg){
        this.x=x;
        this.y=y;
        this.Haut=Haut;
        this.Larg= Larg;
    }

    /**
     * Getter pour la variable x
     * @return x int : Position en x de l'entité (ligne)
     */
    public int getx(){
        return this.x;
    }

     /**
     * Setter pour la variable x
     * @param x int
     */
    public void setx( int x){
    	this.x=x;
    }
    
    /**
     * Getter pour la variable y
     * @return y int : Position en y de l'entité (colonne)
     */
    public int gety(){
        return this.y;
    }

     /**
     * Setter pour la variable y
     * @param y int
     */
    public void sety(int y){
    	this.y=y;
    }
    
    /**
     * Getter pour la variable Haut
     * @return Haut int : hauteur de l'entité 
     */
    public int getHaut(){
        return this.Haut;
    }

     /**
     * Setter pour la variable Haut
     * @param Haut int
     */
    public void setHaut( int Haut){
    	this.Haut=Haut;
    }
    
    /**
     * Getter pour la variable Larg
     * @return Larg int : largeur de l'entité 
     */
    public int getLarg(){
        return this.Larg;
    }

     /**
     * Setter pour la variable Larg
     * @param Larg int
     */
    public void setLarg( int Larg){
    	this.Larg=Larg;
    }

}
