package musicapp;
public class Song {
    //defining data members a song object will have
    private String name;
    private String genre;
    
    //constructor used to create a Song object
    public Song(String name, String genre){
        this.name = name;
        this.genre = genre;
    }
    public Song(String name){
        this.name = name;
        genre = "";
    }
    public Song(){
        name = "";
        genre = "";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
    
    
}
