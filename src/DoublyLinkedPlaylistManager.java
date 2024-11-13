import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * The DoublyLinkedPlaylistManager class manages a playlist of songs using a doubly linked list structure.
 * This class allows for efficient addition, removal, and navigation of songs in the playlist.
 * Each song is represented by a Node, which contains links to both the next and previous songs,
 * enabling traversal in both directions. The class provides methods to add songs to the playlist,
 * remove songs by index, display all songs, and navigate through the playlist. It also maintains
 * the current song being played, allowing users to easily move to the next or previous song in the list.
 */

public class DoublyLinkedPlaylistManager {

    // Node class for doubly linked list
    class Node {
        Song song; // Holds the data for each node, which in this case is a Song object.
        Node next; // A reference to the next node in the list, allowing traversal forward.
        Node previous; // A reference to the previous node in the list, allowing traversal backward.

        /**
         * Constructs a new Node with the specified song.
         *
         * @param song the song to be stored in the node
         */
        Node(Song song) {
            this.song = song;
            this.next = null;
            this.previous = null;
        }
    }

    private Node head; // The head of the doubly linked list.
    private Node current; // The current node being played.

    /**
     * Constructs a new DoublyLinkedPlaylistManager with an empty playlist.
     */
    public DoublyLinkedPlaylistManager() {
        head = null;
        current = null;
    }

    /**
     * Adds a new song to the playlist.
     *
     * @param newSong the song to be added to the playlist
     */
    public void addFavoriteSong(Song newSong) {
        if (isDuplicate(newSong)) {
            System.out.println("Song already exists in the playlist.");
            return;
        }
        Node newNode = new Node(newSong);
        if (head == null) {
            head = newNode;
            current = head;
        } else {
            Node last = head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = newNode;
            newNode.previous = last;
        }
        System.out.println(newSong.getTitle() + " added to the playlist.");
    }

    /**
     * Checks if a song is already in the playlist.
     *
     * @param song the song to check for duplicates
     * @return true if the song is a duplicate, false otherwise
     */
    private boolean isDuplicate(Song song) {
        Node current = head;
        while (current != null) {
            if (current.song.getTitle().equals(song.getTitle()) && current.song.getArtist().equals(song.getArtist())) {
                return true; // Duplicate found
            }
            current = current.next;
        }
        return false; // No duplicate found
    }

    /**
     * Removes a song from the playlist by its index.
     *
     * @param index the index of the song to be removed
     */
    public void removeFavoriteSong(int index) {
        if (index < 1) {
            System.out.println("Invalid index.");
            return;
        }
        if (head == null) {
            System.out.println("Playlist is empty.");
            return;
        }
        if (index == 1) {
            System.out.println(head.song.getTitle() + " removed from the playlist.");
            head = head.next;
            if (head != null) {
                head.previous = null;
            }
            return;
        }
        Node current = head;
        int count = 1;
        while (current != null && count < index) {
            current = current.next;
            count++;
        }
        if (current == null) {
            System.out.println("Invalid index.");
        } else {
            System.out.println(current.song.getTitle() + " removed from the playlist.");
            if (current.previous != null) {
                current.previous.next = current.next;
            }
            if (current.next != null) {
                current.next.previous = current.previous;
            }
        }
    }

    /**
     * Displays all songs in the playlist with their index.
     */
    public void displayFavoriteSongs() {
        if (head == null) {
            System.out.println("Playlist is empty.");
            return;
        }
        Node current = head;
        int index = 1;
        while (current != null) {
            System.out.println(index + ". " + current.song);
            current = current.next;
            index++;
        }
    }

    /**
     * Plays the next song in the playlist.
     */
    public void playNextFavoriteSong() {
        if (current == null || current.next == null) {
            System.out.println("No next song in the playlist.");
        } else {
            current = current.next;
            System.out.println("Now playing: " + current.song);
        }
    }

    /**
     * Plays the previous song in the playlist.
     */
    public void playPreviousFavoriteSong() {
        if (current == head || current == null) {
            System.out.println("There are no more previous songs.");
        } else {
            current = current.previous;
            System.out.println("Now playing: " + current.song);
        }
    }

    /**
     * Starts playing from the first song in the playlist.
     */
    public void setCurrentToFirst() {
        current = head;
        if (current != null) {
            System.out.println("Now playing: " + current.song);
        } else {
            System.out.println("Playlist is empty.");
        }
    }

    /**
     * Checks if the playlist is empty.
     *
     * @return true if the playlist is empty, false otherwise
     */
    public boolean isEmpty() {
        return head == null;
    }
}