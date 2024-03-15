package musicapp;
public class Song {
    //defining data members a song object will have
    private String name;
    
    //constructor used to create a Song object
    public Song(String name){
        this.name = name;
    }
    public Song(){
        name = "";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
