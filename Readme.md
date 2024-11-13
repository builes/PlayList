# Playlist Manager

This project is a comprehensive playlist manager implemented in Java. It allows users to manage their favorite songs using either a singly linked list or a doubly linked list. The project includes classes for managing the playlist, representing songs, and handling user input through a menu-driven interface.

The singly linked list and doubly linked list were created without using the LinkedList class from Java's standard library.

## Table of Contents
- [Overview](#overview)
- [Classes](#classes)
    - [Main.java](#mainjava)
    - [Song.java](#songjava)
    - [SinglyLinkedPlaylistManager.java](#singlylinkedplaylistmanagerjava)
    - [DoublyLinkedPlaylistManager.java](#doublylinkedplaylistmanagerjava)
- [Menu Options](#menu-options)
- [Example Usage](#example-usage)


## Overview
The Playlist Manager project is designed to help users manage their favorite songs efficiently. Users can add, remove, and navigate through songs in their playlist. The project supports two types of playlist management:
- Singly Linked List
- Doubly Linked List

## Classes

### Main.java
This is the entry point of the application. It provides a menu-driven interface for the user to interact with the playlist manager. The user can choose to add, remove, display, and navigate through songs in the playlist.

### Song.java
This class represents a song with attributes such as title, artist, duration, and genre. It includes getters and setters for these attributes and overrides the `toString` method for displaying song details.

### SinglyLinkedPlaylistManager.java
This class manages a playlist using a singly linked list. It provides methods to add, remove, and navigate through songs in the playlist. The class supports checking for duplicate songs, moving to the next or previous song, and displaying the current playlist.

### DoublyLinkedPlaylistManager.java
This class manages a playlist using a doubly linked list. It provides methods to add, remove, and navigate through songs in the playlist, allowing traversal in both directions. The class maintains the current song being played and allows users to move to the next or previous song in the list.


## Menu Options
- **1. Add a new song to favorites:** Displays a list of available songs and prompts the user to select one to add to the playlist.
- **2. Remove a song from favorites:** Prompts the user to enter the index of the song to remove from the playlist.
- **3. Display favorite songs list:** Displays all songs currently in the playlist.
- **4. Play next favorite song:** Moves to the next song in the playlist and displays its details.
- **5. Play previous favorite song:** Moves to the previous song in the playlist and displays its details.
- **6. Start playing from the first favorite song:** Resets the current song to the first song in the playlist and displays its details.
- **7. Exit:** Exits the application.

## Example Usage
```sh
Favorite Song List Manager
1. Add a new song to favorites
2. Remove a song from favorites
3. Display favorite songs list
4. Play next favorite song
5. Play previous favorite song
6. Start playing from the first favorite song
7. Exit
Enter your choice: 1
Available Songs:
1. Song{title='Song 1', artist='Artist A', duration=210, genre='Pop'}
2. Song{title='Song 2', artist='Artist B', duration=180, genre='Rock'}
3. Song{title='Song 3', artist='Artist C', duration=240, genre='Jazz'}
4. Song{title='Song 4', artist='Artist D', duration=200, genre='Classical'}
Enter the number of the song to add: 1
Song 1 added to the playlist.