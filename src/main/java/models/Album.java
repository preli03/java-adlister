package models;

public class Album {
    private int id;
    private String albumName;
    private String artistName;
    private int sales;

    // Getters and setters
    // ...

    @Override
    public String toString() {
        return "Album [id=" + id + ", albumName=" + albumName + ", artistName=" + artistName + ", sales=" + sales + "]";
    }

    public void setAlbumName(String thriller) {

    }

    public void setId(int id) {

        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setArtistName(String michaelJackson) {

    }

    public void setSales(int i) {

    }
}
