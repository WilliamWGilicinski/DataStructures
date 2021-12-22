package osu.cse2123;

/**
 * A simple interface for music tracks.
 *
 * @author Jeremy Morris
 * @version 20201001
 */

public interface Track {

    /**
     * @return the name of the track
     */
    public String getName();

    /**
     * Sets the name of the song
     *
     * @param name String to set the name to
     */
    public void setName(String name);

    /**
     * @return the name of the artist who created the track
     */
    public String getArtist();

    /**
     * Sets the name of the artist
     *
     * @param artist String to set the artist name to
     */
    public void setArtist(String artist);

    /**
     * @return the name of the album the song comes from
     */
    public String getAlbum();

    /**
     * Sets the name of the album the song comes from
     *
     * @param album String to set the album name to
     */
    public void setAlbum(String album);
}
