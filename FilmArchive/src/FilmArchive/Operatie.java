package FilmArchive;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import static com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table;

public class Operatie {
    LezenSchriven lezen = new LezenSchriven();

    public void addFilm(Scanner ss) {
        LezenSchriven rw = new LezenSchriven();
        ArrayList<String> actors = new ArrayList<>();
        FilmID film = new FilmID();
        System.out.println("Name:");
        film.setName(ss.nextLine());
        System.out.println("Director");
        film.setDirector(ss.nextLine());
        System.out.println("release year");
        int year = Integer.parseInt(ss.nextLine());
        film.setReleasedate(year);
        boolean artistDone = true;
        String actor;
        System.out.println("enter the actrists of the film <Return> to stop :");
        actor = ss.nextLine();
        while (artistDone) {
            actors.add(actor);
            System.out.println("Enter the actrists of the film<Return> to stop :");
            actor = ss.nextLine();
            if (actor.equals("")) artistDone = false;
        }
        film.setArtists(actors);
        System.out.println("Summary :");
        film.setSummary(ss.nextLine());
        System.out.println("type: ");
        film.setType(ss.nextLine());
        rw.writeFilmInfo(film);

    }

    public ArrayList<FilmID> searchFilm(String st) {
        ArrayList<FilmID> films = lezen.readfilminfo();
        ArrayList<FilmID> filmsfound = new ArrayList<>();
        for (FilmID f : films) {
            if (f.getName().toLowerCase().contains(st.toLowerCase())) filmsfound.add(f);
            else if (f.getArtistsinString().toLowerCase().contains(st.toLowerCase())) filmsfound.add(f);
            else if (f.getDirector().toLowerCase().contains(st.toLowerCase())) filmsfound.add(f);
            else if (f.getType().toLowerCase().contains(st.toLowerCase())) films.add(f);
            else if (Integer.toString(f.getReleasedate()).equalsIgnoreCase(st)) filmsfound.add(f);
        }
        return filmsfound;
    }

    public String html_generator()    {
        String html;
        private StringBuilder addtext = new StringBuilder();
        addtext.append("<!DOCTYPE html>< html ><head ><meta charset =\"UTF-8\">< title > Film Archive</title ></head ><body >");
        addtext.append(" <table width = 100 % >");
        addtext.append("<table width = 100 % ><thead ><tr ><th colspan = 2 > ");
        addtext.append("=========Film name==========");
        addtext.append("</th ></tr >");
        addtext.append("</thead ><tfoot ><tr ></td ></tr ></tfoot ><tbody ><tr >");
        addtext.append("<td width = 40 % > Director </td ><td rowspan = 4 width = 60 % > Picture goes here</td ></tr >");
        addtext.append("<tr ><td > Actors </td ></tr ><tr ><td > release year</td ></tr ><tr ><td > genre </td ></tr >");
        addtext.append("<tr ><td colspan = 2 > summary </td ></tr ></tbody ></table ></body ></html > ");




return HTML;
    }
}
