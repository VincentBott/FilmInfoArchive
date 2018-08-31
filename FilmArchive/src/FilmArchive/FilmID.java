package FilmArchive;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public class FilmID {
    private String name;
    private String director;
    private int releasedate;
    private ArrayList<String> artists = new ArrayList<>();
    private String summary;
    private String type;
public FilmID(){
    //doe niets
}
    public FilmID(String name, String director, int releasedate, ArrayList<String> artists, String summary, String type) {
        this.name = name;
        this.director = director;
        this.releasedate = releasedate;
        this.summary = summary;
        this.type = type;
        this.artists = artists;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void setDirector(String director) {
        this.director = director;
    }

    public void setReleasedate(int releasedate) {
        this.releasedate = releasedate;
    }

    public void setArtists(ArrayList<String> artists) {
        this.artists = artists;
    }
    public void setArtistsInStrings(String artists){

    String delims = "[:]";
    String[] tokens = artists.split(delims);
    this.artists.addAll(Arrays.asList(tokens));
        //System.out.println("setartistinStrings"+this.artists);
        //System.out.println("setartistinStrings"+tokens);

    }

    public void setSummary(String summary) {
    summary.replace(","," ");  ////since the line is parsed with commas they have to be removed.
    this.summary = summary;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getDirector() {
        return this.director;
    }

    public int getReleasedate() {
        return releasedate;
    }

    public ArrayList<String> getArtists() {
        return artists;
    }
    public String getArtistsinString() {
    String actorsInText ="";
    for(String aa: artists){
       actorsInText += aa+":";
    }
    return actorsInText;
    }

    public String getSummary() {
        return summary;
    }

    public String getType() {
        return type;
    }
}
