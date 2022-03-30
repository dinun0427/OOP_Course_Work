import java.io.Serializable;



abstract class Driver implements Serializable{  //convert the object and in order to save a file
    String name;
    String location;
    String team;

    public String getName() {
        return name;
    }
    public String getLocation() {
        return location;
    }
    public String getTeam() {
        return team;
    }
}
