package osu.cse2123;

/**
 * A simulator of an MP3 player using the Playlist and Track interfaces.
 *
 * @author William Gilicinski
 * @version March 25, 2021
 *
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MusicPlayerSimulator {

    /**
     * Gets the name of the file that contains the information to get a playlist
     * started.
     *
     * @param reader
     * @return inputName
     */
    public static String getInput(Scanner reader) {
        System.out.println("Enter database filename: ");
        String inputName = reader.nextLine();
        return inputName;
    }

    /**
     * Scans the file that the user entered and makes a playlist out of all the
     * information
     *
     * @param inputName
     * @return playlist
     * @throws FileNotFoundException
     */
    public static Playlist createPlaylist(String inputName)
            throws FileNotFoundException {
        Playlist playlist = new SimplePlaylist();
        File inputData = new File(inputName);
        Scanner fileScan = new Scanner(inputData);
        while (fileScan.hasNext()) {
            String lineScan = fileScan.nextLine();
            String[] tempArr = lineScan.split(",");
            Track temp = new SimpleTrack();
            temp.setName(tempArr[0]);
            temp.setArtist(tempArr[1]);
            temp.setAlbum(tempArr[2]);
            playlist.addTrack(temp);
        }
        fileScan.close();
        return playlist;
    }

    /**
     * Displayes what song is currently playing and what will play after it
     *
     * @param playlist
     */
    public static Track showPlaying(Playlist playlist) {
        Track current = playlist.getTrack();
        System.out.println("Currently playing: " + current.toString());
        if (!playlist.isEmpty()) {
            Track next = playlist.peekAtTrack();
            System.out.println("Next track to play: " + next.toString());
        }
        return current;
    }

    /**
     * Asks the user to enter either a P, A, or Q. This will repeat until the
     * user enters a valid response and will return a number 0-2 with the
     * corresponding response.
     *
     * @param reader
     * @return answer 0 - play next track 1 - add a new track 2 - quit
     */
    public static int postTrackInput(Scanner reader) {
        System.out.println("[P]lay next track");
        System.out.println("[A]dd a new track");
        System.out.println("[Q]uit");

        int answer = 0;
        boolean valid = false;

        while (!valid) {
            String input = reader.nextLine();
            if (input.length() == 1) {
                if (input.equalsIgnoreCase("P")) {
                    answer = 0;
                    valid = true;
                } else if (input.equalsIgnoreCase("A")) {
                    answer = 1;
                    valid = true;
                } else if (input.equalsIgnoreCase("Q")) {
                    answer = 2;
                    valid = true;
                } else {
                    System.out.println("Invalid answer");
                }
            } else {
                System.out.println("Invalid answer");
            }
        }

        System.out.println(">");

        return answer;
    }

    /**
     * Adds a track to the playlist if the user wants
     *
     * @param reader
     * @param playlist
     * @updates playlist
     */
    public static void addTrack(Scanner reader, Playlist playlist) {
        //Gets the information from the user
        System.out.print("Track name: ");
        String trackName = reader.nextLine();
        System.out.print("Artist name: ");
        String artistName = reader.nextLine();
        System.out.print("Album name: ");
        String albumName = reader.nextLine();

        Track newSong = new SimpleTrack();

        //Creates a new track with the information
        newSong.setName(trackName);
        newSong.setArtist(artistName);
        newSong.setAlbum(albumName);

        //Prints out the information that the user entered
        System.out.println("Track: " + newSong.getName());
        System.out.println("Artist: " + newSong.getArtist());
        System.out.println("Album: " + newSong.getAlbum());

        System.out.print("Are you sure you want to add this track [y/n]? ");

        //Verifies if the user wants to add the track or not and will ask until
        //the user enters a valid response.
        boolean valid = false;
        boolean readyToAdd = false;
        while (!valid) {
            String input = reader.nextLine();
            if (input.equalsIgnoreCase("y")) {
                readyToAdd = true;
                valid = true;
            } else if (input.equalsIgnoreCase("n")) {
                valid = true;
            } else {
                System.out.println("Enter a valid response");
            }
        }
        if (readyToAdd) {
            playlist.addTrack(newSong);
        }
    }

    /**
     * Prints out the remaining tracks in the playlist after the user wants to
     * stop listening or their are no more tracks
     *
     * @param playlist
     */
    public static void endMessage(Playlist playlist) {
        System.out.println("Tracks remaining in play list");
        System.out.println(
                "------------------------------------------------------------");
        int count = 1;
        while (!playlist.isEmpty()) {
            System.out.println(count + " - " + playlist.getTrack().toString());
        }
    }

    public static void showPlaying2(Track temp, Playlist playlist) {
        System.out.println("Currently playing: " + temp.toString());
        Track peek = playlist.peekAtTrack();
        System.out.println("Next track to play: " + peek.toString());
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner reader = new Scanner(System.in);
        String fname = getInput(reader);
        Playlist playlist = createPlaylist(fname);
        boolean advance = true;
        Track temp = showPlaying(playlist);
        while (advance) {
            int input = postTrackInput(reader);

            if (input == 0) {
                if (playlist.isEmpty()) {
                    advance = false;
                    System.out.println("Playlist is empty");
                } else {
                    temp = showPlaying(playlist);
                }
            } else if (input == 1) {
                addTrack(reader, playlist);
                showPlaying2(temp, playlist);
            } else {
                advance = false;
            }
        }
        endMessage(playlist);

        reader.close();
    }

}
