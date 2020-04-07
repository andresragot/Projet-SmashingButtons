public class Entite{
    
    //Propriétés caractérisant une entité
    public int x; //Position en x de l'entité (ligne)
    public int y; //Position en y de l'entité (colonne)
    public int haut;
    public int larg;
    private int nbEntites;
    
    //Constructeur
    public Entite(int x, int y, int haut, int larg){
        this.x=x;
        this.y=y;
        this.haut=haut;
        this.larg= larg;
    }
    
}
