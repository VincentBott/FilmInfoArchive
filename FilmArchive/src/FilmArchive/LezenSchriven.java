package FilmArchive;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class LezenSchriven {


    private final String FILENAAM = "filmlist.txt";
    private StringBuilder addtext = new StringBuilder();

    public void writeFilmInfo(FilmID aa) {
        addtext.append(aa.getName());
        addtext.append(",");
        addtext.append(aa.getDirector());
        addtext.append(",");
        addtext.append(aa.getReleasedate());
        addtext.append(",");
        addtext.append("::");
        addtext.append(aa.getArtistsinString());
        addtext.append("::");
        addtext.append(",");
        addtext.append(aa.getSummary());
        addtext.append(",");
        addtext.append(aa.getType());
        addtext.append("\n");

        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream("filmlist.txt", true), "utf-8"))) {
            writer.append(addtext.toString());
        } catch (IOException ee) {
            //doe niets
        }
    }

    public ArrayList<FilmID> readfilminfo() {

        ArrayList<FilmID> films = new ArrayList<>();
        FilmID film;
        try (BufferedReader br = new BufferedReader(new FileReader(FILENAAM))) {
            for (String line; (line = br.readLine()) != null; ) {
                String[] parsedTextLine = parseLine(line);
                // for (String aa : parsedTextLine) {
                //   System.out.println(aa);
                //}
                film = new FilmID();
                film.setName(parsedTextLine[0]);
               // System.out.println("name setted: " + parsedTextLine[0]);
                film.setDirector(parsedTextLine[1]);
                //System.out.println("director setted: " + parsedTextLine[1]);
                film.setReleasedate(Integer.parseInt(parsedTextLine[2]));
                //System.out.println("release date  setted: " + parsedTextLine[2]);
                film.setArtistsInStrings(parseActors(line));
                //System.out.println("actors are setted"+parseActors(line));
                //System.out.println(film.getArtistsinString());
                film.setSummary(parsedTextLine[4]);
                //System.out.println("summary is setted: " + parsedTextLine[4]);
                film.setType(parsedTextLine[5]);
                //System.out.println("genre is setted: " + parsedTextLine[5]);

                films.add(film);
            }
        } catch (IOException ee) {
            //doe niets
        }
        return films;
    }

    public String[] parseLine(String text) {
        String delims = "[,]";
        String[] tokens = text.split(delims);
        return tokens;
    }

    //// takes the whole line and gives the artists in Arraylist
    public String parseActors(String text) {

        String actortssplitted = text.substring(text.indexOf("::") + 2, text.lastIndexOf("::"));
        String delims2 = "[:]";
        String[] tokens2 = actortssplitted.split(delims2);
        String actorsInString = "";
        //to check if it is properly done
        for (String aa : tokens2) {
            actorsInString += aa + ":";
        }
        return actorsInString;
    }

    public static FilmID searchFilm(FilmID aa) {
        return null;

    }
    public void removeFilm(FilmID film){

    }

}
