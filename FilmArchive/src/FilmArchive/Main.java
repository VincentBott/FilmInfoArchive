package FilmArchive;

import java.awt.*;
import java.io.Console;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.ConsoleHandler;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LezenSchriven lazen = new LezenSchriven();
        //MainMenu hh = new MainMenu();
        System.out.print("hsdhsadh jshdkjhsa kdjhsak djsakj hdkjsa%nksjdksajdlkas%nslkdjsalkjd%n");
        System.out.print("\u001b[2J");
        //hh.mainmenu(scanner);
        ArrayList<String> actors = new ArrayList<>();
        actors.add("Leonardo DiCaprio");
        actors.add("Kate Winslet");
        actors.add("Billy Zane");
        actors.add("Kathy Bates");

        FilmID film = new FilmID("Titanic","James Cameron",1997,actors,"A seventeen-year-old aristocrat falls in love with a kind but poor artist aboard the luxurious, ill-fated R.M.S. Titanic.","Drama/Romance");
        lazen.writeFilmInfo(film);
        lazen.readfilminfo();


        // write your code here
    }
}