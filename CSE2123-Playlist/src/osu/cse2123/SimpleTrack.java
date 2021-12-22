package osu.cse2123;

/**
 * An implementation of the PlayListTrack interface
 *
 * @author William Gilicinski
 * @version March 22, 2021
 *
 */
public class SimpleTrack implements Track {

    private String name;
    private String album;
    private String artist;

    public SimpleTrack() {
        this.name = "";
        this.album = "";
        this.artist = "";
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getArtist() {
        return this.artist;
    }

    @Override
    public void setArtist(String artist) {
        this.artist = artist;
    }

    @Override
    public String getAlbum() {
        return this.album;
    }

    @Override
    public void setAlbum(String album) {
        this.album = album;
    }

    @Override
    public boolean equals(Object obj) {
        boolean same = false;
        //Looks to see if the object is the exact same one
        if (this == obj) {
            same = true;
            //els if checks if the obj is of type SimpleTrack
        } else if (obj instanceof SimpleTrack) {
            //Creates an object that has the values of obj
            //and checks if all the values are the same.
            Track temp = (SimpleTrack) obj;
            if (this.name.equals(temp.getName())) {
                if (this.artist.equals(temp.getArtist())) {
                    same = this.album.equals(temp.getAlbum());
                }
            }
        }
        return same;
    }

    @Override
    public String toString() {
        return ("'" + this.artist + " / " + this.name + " / " + this.album
                + "'");
    }

    @Override
    public int hashCode() {
        return this.artist.hashCode() + this.album.hashCode()
                + this.name.hashCode();
    }

}
