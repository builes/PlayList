
/**
 * The SinglyLinkedPlaylistManager class is responsible for managing a playlist of songs using a Singly linked list structure.
 * It provides methods to add, remove, and navigate through songs in the playlist.
 * This class supports checking for duplicate songs, moving to the next or previous song,
 * and displaying the current playlist.
 */
public class SinglyLinkedPlaylistManager {
    class Node {
        Song song; //Holds the data for each node, which in this case is a Song object.
        Node next; //A reference to the next node in the list, allowing traversal forward.

        Node(Song song) {
            this.song = song;
            this.next = null;
        }
    }
    private Node head;
    private Node current;

    public SinglyLinkedPlaylistManager() {
        head = null;
        current = null;
    }

    // Method to add a song to the playlist
    public void addFavoriteSong(Song newSong) {
        // Step 1: Check if the playlist is empty. If so, set the new node as the head and initialize current to the head.
        Node songNode = new Node(newSong);
        if (head == null) {
            head = songNode; // Set the new node as the head
            current = head; // Initialize current to the head
            System.out.println(newSong.getTitle() + " added to the playlist.");
            return;
        }

        // Step 2: Check for duplicates. If the song already exists, skip the addition and notify the user.
        Node temp = head; // Start from the head of the list
        while (temp != null) {
            if (temp.song.getTitle().equals(newSong.getTitle()) &&
                    temp.song.getArtist().equals(newSong.getArtist())) {
                System.out.println("The song is already in your playlist.");
                return;
            }
            if (temp.next == null) break; // Stop at the last node
            temp = temp.next;
        }

        // Step 3: Add the new node to the end of the list if no duplicates are found.
        temp.next = songNode;
        System.out.println(newSong.getTitle() + " added to the playlist.");
    }

    private boolean isDuplicate(Song song) {
        Node current = head;
        while (current != null) {
            if (current.song.getTitle().equals(song.getTitle()) && current.song.getArtist().equals(song.getArtist())) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // Method to remove a song from the playlist based on the given index
    public void removeFavoriteSong(int index) {
        //  if the index is less than 1. If so, print "Invalid index." and return.
        if (index < 1) {
            System.out.println("Invalid index.");
            return;
        }

        // if the playlist is empty (head == null). If so, print "Playlist is empty." and return.
        if (head == null) {
            System.out.println("Playlist is empty.");
            return;
        }

        // Handle the case where the index is 1 (the first song).
        // If the index is 1, print the title of the removed song and update head to the next node.
        if (index == 1) {
            System.out.printf("The song %s was deleted%n", head.song.getTitle());
            head = head.next; // Move head to the next node.
            return; // Exit the method after removing the first song.
        }

        // Traverse the playlist using a loop, keeping track of current, previous, and count.
        Node current = head; // Start with the head of the playlist.
        Node previous = null; // Initialize previous as null.
        int count = 1; // Start counting from 1.

        // Search for the node at the specified index.
        while (current != null && count < index) {
            previous = current; // Keep track of the current node as the previous node.
            current = current.next; // Move current to the next node.
            count++; // Increment the count.
        }

        // If current is null after the loop, it means the index is invalid.
        if (current == null) {
            System.out.println("Invalid index.");
            return; // Exit the method as the index is out of bounds.
        }

        // If a valid node is found, adjust previous.next to remove the current node.
        System.out.printf("The song %s was deleted%n", current.song.getTitle()); // Print the title of the removed song.
        previous.next = current.next; // Bypass the current node to remove it from the playlist.
    }


    // Method to display all songs with index
    public void displayFavoriteSongs() {
        // if the playlist is empty by verifying if head == null.
        if(head == null){
            System.out.println("Playlist is empty");
            return;
        }

        // Initialize current to head and index to 1.
        // Use a while loop to iterate through the playlist, printing each song’s index and details.
        Node current = head;
        int index = 1;
        while (current != null){
            System.out.println(current.song);
            index ++;
            current = current.next;
        }
    }

    // Method to play the next song in the playlist
    public void playNextFavoriteSong() {
        // check if there is no next song by verifying if current == null or current.next == null.
        if(current == null || current.next == null){
            System.out.println("No next song in the playlist.");
            return;
        }
        // f there is a next song, update current to current.next. print the details of the now playing song.
        current = current.next;
        System.out.println("Playing: " + current.song);
    }

    // Method to play the previous song in the playlist
    public void playPreviousFavoriteSong() {
        // Check if the playlist is empty or if the current song is the head
        // If `current` is `null` or `current` is pointing to `head`, there is no previous song to play.
        if (head == null || current == head) {
            System.out.println("There is no previous song to play");
            return;
        }

        // Initialize a temporary node `temp` to start from the head of the list
        Node temp = head;

        // Traverse the list to find the node just before `current`
        // This involves iterating through the list until `temp.next` is `current`
        while (temp.next != current) {
            temp = temp.next;
        }

        // Set `current` to `temp`, effectively moving back one song
        current = temp;

        // Print the song details of the new `current` node
        System.out.println("Playing " + current.song);
    }


    // Method to start playing from the first song in the playlist
    public void setCurrentToFirst() {
        current = head;
        if (current != null) {
            System.out.println("Now playing: " + current.song);
        } else {
            System.out.println("Playlist is empty.");
        }
    }

    // Check if playlist is empty
    public boolean isEmpty() {
        return head == null;
    }
}

