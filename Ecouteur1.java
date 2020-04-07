import java.awt.event.*;
import java.util.*;

public class Ecouteur1 implements ActionListener{
    
    private Fenetre_Menu Menu;
    private Fenetre_Jeu fen_Jeu;
    
    public Ecouteur1(Fenetre_Menu Menu){
        this.Menu=Menu;
    }
    
    public void actionPerformed(ActionEvent e){
        Menu.hide();
        fen_Jeu = new Fenetre_Jeu(Menu);
    }
    
}
