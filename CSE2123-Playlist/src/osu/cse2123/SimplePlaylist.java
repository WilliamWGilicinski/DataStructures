package osu.cse2123;

/**
 * An implementation of the Playlist interface
 *
 * @author YOUR NAME HERE
 * @version DATE HERE
 *
 */
import java.util.LinkedList;
import java.util.Queue;

public class SimplePlaylist implements Playlist {

    Queue<Track> playlist = new LinkedList<>();

    /**
     * No-argument constructor - creates an empty PlayList
     *
     * @postcond playlist object is empty
     */
    public SimplePlaylist() {
        // TODO: Your code here
    }

    @Override
    public Track getTrack() {
        Track temp = this.playlist.remove();
        return temp;
    }

    @Override
    public Track peekAtTrack() {
        Track temp = this.playlist.element();
        return temp;
    }

    @Override
    public void addTrack(Track track) {
        this.playlist.add(track);
    }

    @Override
    public boolean isEmpty() {
        boolean empty = true;
        if (this.playlist.size() > 0) {
            empty = false;
        }
        return empty;
    }

}
