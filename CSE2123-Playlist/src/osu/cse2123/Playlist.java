package osu.cse2123;
/**
 * A simple interface for music play lists
 *
 * @author Jeremy Morris
 * @version 20201001
 */
public interface Playlist {

    /**
     * Returns the current track in the play list and removes it from the play
     * list, advancing to the next track. 
     * 
     * @precond the playlist is not empty
     * @return the current track in the play list
     */
    public Track getTrack();

    /**
     * Returns the current track in the play list without removing it.
     *
     * @precond the playlist is not empty
     * @return the current track in the play list
     */
    public Track peekAtTrack();

    /**
     * Appends another track to the end of the play list
     *
     * @param track track to be appened to the end of the list
     * @postcond the track is added to the end of the playlist
     */
    public void addTrack(Track track);

    /**
     * Identifies if the playlist is empty or not.
     * 
     * @return true if the playlist is empty, false otherwise
     */
    public boolean isEmpty();
}