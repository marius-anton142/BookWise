package model;

public class Game extends Product {
    private String platform;
    private boolean multiplayerSupport;

    public Game() {

    }

    public Game(String name, int price, Section section, Author author, String platform, boolean multiplayerSupport) {
        super(name, price, section, author);
        this.platform = platform;
        this.multiplayerSupport = multiplayerSupport;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public boolean isMultiplayerSupport() {
        return multiplayerSupport;
    }

    public void setMultiplayerSupport(boolean multiplayerSupport) {
        this.multiplayerSupport = multiplayerSupport;
    }

    @Override
    public String toString()
    {
        return (super.toString() + "\nPlatform = " + this.platform + "\nMultiplayer Support = " + this.multiplayerSupport);
    }
}
