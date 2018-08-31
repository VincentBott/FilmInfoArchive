package FilmArchive;
import java.util.ArrayList;

public class Comments {
    private ArrayList<String> comments = new ArrayList<>();
    private ArrayList<Integer> rate = new ArrayList<Integer>();

    public void setComments(String comments) {
        if(!comments.equals("")) this.comments.add(comments);
        else throw new IllegalArgumentException("Please write a comment");
    }

    public void setRate(int rate) {
        if(rate<=10 && rate >=0) this.rate.add(rate);
        else throw new IllegalArgumentException("Please enter a value between 0-10");
    }

    public ArrayList<String> getComments() {
        return comments;
    }

    public ArrayList<Integer> getRate() {
        return rate;
    }
}
