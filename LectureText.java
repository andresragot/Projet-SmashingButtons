import java.io.*;
import java.util.* ; 


public class LectureText {
	
	File f;
	int[][] tab;
	int haut;
	int larg;
	boolean fichierBon=true; // Inititalisation des variables informant l'utilisateur de l'erreur rencontrée
	int Ligne;
	int Colonne;
	int nbSortie=0;
	int nbEntree=0;
	int nbLigneFausse;
	int ligneDepart;
	int colonneDepart;
	
	public LectureText ( String s) throws IOException{
		
		this.f= new File (s);
		BufferedReader br = new BufferedReader(new FileReader(f));			//Lit le text
		String line = br.readLine();										//Enregistre la première ligne
		String token = " ";													//Declare l'élément utlisé pour séparer les caractères des lignes
		StringTokenizer stringTokenizer = new StringTokenizer(line, token); //Découpe la ligne par caractère 
		
		haut=Integer.parseInt((String) stringTokenizer.nextElement());  		// Enregistre la hauteur du labyrinthe 
		larg=Integer.parseInt((String) stringTokenizer.nextElement());			// Enregistre la largeur du labyrinthe 
		
		int caractere;
		tab = new int[haut][larg];		// Crée un tableau qui servira de labytinthe, 1 correspond à un mur, 0, 2 ou 3 à une case vide
		
		StringTokenizer st = new StringTokenizer(line, " ");	//Sépare la ligne lue en plusieurs string. La séparation se fait lorsqu'on lit le caractère espace 
		   
		try {	//Boucle permetant de lire le text en respectant les conditions présentes au sien du catch
			if( fichierCorrect()==true){
				for (int i = 0; i < haut; i++) {
					line = br.readLine();
					st= new StringTokenizer (line," ");
					for (int j= 0; j< larg; j++){
						caractere = Integer.parseInt((String) st.nextElement());
						tab[i][j] = caractere;		//Enregistre les caractères du fichier texte dans le tableau Labyrinthe
						if (caractere != 1 && caractere != 0 && caractere != 3 && caractere != 2){
							Colonne=j+1;			// Retient la case où se situe l'erreur
							Ligne=i+1;
							fichierBon=false;
						}
						if (caractere == 3){		//Compte le nombre de sortie
							nbSortie ++;
						}
						if(caractere == 2){			//Compte le nombre d'entree et retient sa position 
							nbEntree++;
							ligneDepart=j;
							colonneDepart=i;
						}
					}
				}
				if (nbSortie !=1 || nbEntree !=1 ){
					fichierBon=false;
				}
			}else{
				fichierBon=false;
			}

		} catch (FileNotFoundException e) {	// Conditions pour ne pas lire une ligne vide et s'arrêter à la fin de la ligne
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}	
	
	public  boolean fichierCorrect() throws IOException{
		
		boolean b = true ;										
		int nbligne =0;
		BufferedReader br = new BufferedReader(new FileReader(f));	//Lit le text
		String line = br.readLine();	// Enregistre la première ligne
		try{
			while(line != null){
				line = br.readLine();
				nbligne ++;
				if(line != null && line.length() !=larg*2-1){	//Vérifie que la longueur des lignes soient correctes. On compare à larg*2-1 car line.length() prend en compte les espaces, ce qui n'est pas le cas de larg
					b=false;
					nbLigneFausse++;
					Ligne = nbligne;
				}
			}
			
		} catch (FileNotFoundException e) {		//Conditions pour ne pas lire une ligne vide et s'arrêter à la fin de la ligne
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(nbligne != haut+1){		//On compare à haut+1 car haut ne prend pas en compte la première ligne indiquant la hauteur et la largeur du labyrinthe
			b=false;
		}
			
		return b;
	}

}
