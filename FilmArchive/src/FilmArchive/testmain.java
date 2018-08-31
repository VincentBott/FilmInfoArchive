package FilmArchive;

import java.util.ArrayList;
import java.util.Scanner;

public class testmain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LezenSchriven lezen = new LezenSchriven();
        MainMenu menu = new MainMenu();
        Operatie operatie = new Operatie();
       //FilmID film = new FilmID("Titanic","James Cameron",1997,actors,"A seventeen-year-old aristocrat falls in love with a kind but poor artist aboard the luxurious, ill-fated R.M.S. Titanic.","Drama/Romance");
       //System.out.println(film.getArtistsinString());
        //film.setArtistsInStrings();
        //final String ANSI_CLS = "\u001b[2J";
        menu.mainmenu();


    }
}
