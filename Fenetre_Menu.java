import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Fenetre_Menu extends JFrame {
  private JMenuBar menuBar = new JMenuBar();
  private JMenu test1 = new JMenu("Fichier");
  //private JMenu test2 = new JMenu("Restaurer");
  private JMenu test3 = new JMenu("Jeu");

  private JMenuItem item1 = new JMenuItem("Sauvegarder");
  private JMenuItem item5 = new JMenuItem("Restaurer");
  private JMenuItem item2 = new JMenuItem("Quitter");
  private JMenuItem item3 = new JMenuItem("Suspendre");
  private JMenuItem item4 = new JMenuItem("Reprendre");

  public static void main(String[] args){
    Fenetre_Menu Menu = new Fenetre_Menu();
  }

  public Fenetre_Menu(){
    this.setSize(400, 200);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);

    //Initialisation des menus      
    this.test1.add(item1);
    this.test1.add(item5);
    this.test1.add(item2);  


    this.test3.add(item3);
    this.test3.add(item4);

    this.menuBar.add(test1);
    this.menuBar.add(test3);
    this.setJMenuBar(menuBar);
    this.setVisible(true);
  }
}
