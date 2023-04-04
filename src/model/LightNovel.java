package model;

public class LightNovel extends Product {
    private String artist;
    private int pages, volumes;

    public LightNovel() {

    }

    public LightNovel(String name, int price, Section section, Author author, String artist, int pages, int volumes) {
        super(name, price, section, author);
        this.artist = artist;
        this.pages = pages;
        this.volumes = volumes;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getVolumes() {
        return volumes;
    }

    public void setVolumes(int volumes) {
        this.volumes = volumes;
    }

    @Override
    public String toString()
    {
        return (super.toString() + "\nArtist = " + this.artist + "\nNumber of pages = " + this.pages + "\nNumber of volumes = " + this.volumes);
    }
}
