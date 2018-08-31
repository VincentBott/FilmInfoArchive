package FilmArchive;

import javax.sound.midi.Soundbank;
import java.io.Console;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class MainMenu {
    private int kies;
    private boolean loopstate = true;

    Operatie operatie = new Operatie();
    LezenSchriven lezen = new LezenSchriven();
    Scanner scanner = new Scanner(System.in);
    FilmID film;

    public void mainmenu() {
        while (this.loopstate) {
            System.out.println("please choose one of the followings");
            System.out.printf("1. List the films%n2. Add a film%n3. Search%n================%n");
            this.kies = Integer.parseInt(scanner.nextLine());
            switch (this.kies) {
                case 1:
                    this.listFilms();
                    loopstate = false;
                    break;
                case 2:
                    this.addFilms();
                    loopstate = false;
                    break;
                case 3:
                    this.searchFilm();
                    loopstate = false;
                    break;
                default:
                    loopstate = true;
                    break;
            }
        }

    }

    public void listFilms() {
        lezen.readfilminfo();
        int i = 0;
        int choise;
        String list = "";
        //ArrayList<FilmID> films = new ArrayList<>();
        for (FilmID f : lezen.readfilminfo()) {
            list = String.format("[%d] %s(%s)%n", i, f.getName(), f.getReleasedate());
            System.out.print(list);
            i++;
        }
        System.out.printf("Enter the film number to go further actions:(enter 9 for the previous menu)%n");
        choise = Integer.parseInt(scanner.nextLine());
        if (choise == 9) mainmenu();
        FilmID chosenfilm = lezen.readfilminfo().get(choise);
        filmMenu(chosenfilm);
    }
    public void listFilmObjects(ArrayList<FilmID> films) {
        int i = 0;
        int choise;
        String list = "";
        for (FilmID f : films) {
            list = String.format("[%d] %s(%s)%n", i, f.getName(), f.getReleasedate());
            System.out.print(list);
            i++;
        }
        System.out.printf("Enter the film number to go further actions:(enter 9 for the previous menu)%n");
        choise = Integer.parseInt(scanner.nextLine());
        if (choise == 9) mainmenu();
        FilmID chosenfilm = films.get(choise);
        filmMenu(chosenfilm);
    }
    private void filmMenu(FilmID chosenfilm) {
        System.out.printf("=============%n%s%n=================%n", chosenfilm.getName());
        System.out.println("1. remove film      2.See details     3.Previous menu    9. for the main menu");
        int choise = Integer.parseInt(scanner.nextLine());
        if (choise == 1) {
            lezen.removeFilm(chosenfilm);
        } else if (choise == 2) {
            seeFilmInfo(chosenfilm);
        } else if (choise == 3) {
            listFilms();
        } else if (choise == 9) mainmenu();
    }

    private void seeFilmInfo(FilmID film) {
        System.out.println("============================");
        System.out.printf("film name: %s%n",film.getName());
        System.out.printf("Director: %s%n",film.getReleasedate());
        System.out.printf("Release Date: %d%n",film.getReleasedate());
        System.out.printf("Actors: %s%n",film.getArtistsinString());
        String summary = film.getSummary().replaceAll("(.{30})", "$1\n");
        System.out.printf("summary: %s%n",summary);
        System.out.printf("Genre: %s%n",film.getType());
        System.out.println("============================");
        System.out.println("previous menu [0], main menu [9]");
        String command = "open.bat";
        try {
            Runtime.getRuntime().exec(command);
        }
        catch (IOException ee){
            System.out.println(ee.getMessage());
        }
        String choise = scanner.nextLine();
        if(choise.equals("0")) filmMenu(film);
        else mainmenu();
        }

    private void searchFilm() {
        ArrayList<FilmID> films = new ArrayList<>();
        System.out.printf("=============%n Search (film/director/actrist/year/genre)%n");
        System.out.println("previous menu enter (0), main menu (9)%n");
        String search = scanner.nextLine();
        if(search.equals("0")) mainmenu();
        else if(search.equals("9")) mainmenu();
        films = operatie.searchFilm(search);
        if(films.isEmpty()){
            System.out.println("no films is found. Please search again.");
            searchFilm();
        }
        listFilmObjects(films);

    }

    public void addFilms() {
        System.out.println("please enter the following informations about the film");
        operatie.addFilm(this.scanner);

    }
}

