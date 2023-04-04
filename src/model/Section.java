package model;

public class Section {
    private String title;
    private int popularity;

    public Section() {
        this.title = "?";
        this.popularity = -1;
    }
    public Section(String title, int popularity) {
        this.title = title;
        this.popularity = popularity;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPopularity() {
        return popularity;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

    @Override
    public String toString() {
        return ("Title = " + this.title + "\nPopularity = " + this.popularity + "%");
    }
}
