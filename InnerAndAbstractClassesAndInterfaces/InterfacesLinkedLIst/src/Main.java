import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<Album>albums = new ArrayList<Album>();
        
        Album starboy = new Album ("Starboy");
        starboy.addSong("Starboy", 3.50);
        starboy.addSong("Party Monster", 4.09);
        starboy.addSong("False Alarm", 3.40);
        starboy.addSong("Reminder", 3.38);
        starboy.addSong("Rockin", 3.52);
        starboy.addSong("Secrets", 4.25);
        starboy.addSong("I Feel It Coming", 4.29);

        Album revival = new Album("Revival");
        revival.addSong("Revival", 4.06);
        revival.addSong("Kill Em With Kindness", 3.37);
        revival.addSong("Hands To Myself", 3.20);
        revival.addSong("Good For You", 3.41);
        revival.addSong("Survivors", 3.41);

        albums.add(starboy);
        albums.add(revival);

        LinkedList<Song>playlist = new LinkedList<Song>();
        starboy.addToPlaylist("Starboy", playlist);
        starboy.addToPlaylist("False Alarm", playlist);
        starboy.addToPlaylist("I Feel It Coming", playlist);
        albums.get(0).addToPlaylist("Rockin", playlist);
        revival.addToPlaylist("Kill Em With Kindness", playlist);
        revival.addToPlaylist("Hands To Myself", playlist);
        starboy.addToPlaylist("Secrets", playlist);
    
        play(playlist);
        

        
    }

    public static void play(LinkedList<Song>playlist) {
        ListIterator<Song> listIterator = playlist.listIterator();
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean isforward = true;

        if(playlist.size()==0) {
            System.out.print("There Are No Songs in Playlist!!!");
        
        } else {
            System.out.println("Now Playing: " + listIterator.next().toString());
        }

        while(!quit) {
            printMenu();
            int choice = scanner.nextInt();

            switch(choice) {
                case 0:
                    System.out.println("Exiting....");
                    quit = true;
                    break;
                case 1:
                    if(!isforward) {
                        if(listIterator.hasNext()) {
                            listIterator.next();
                            isforward = true;
                        
                        }
                    }
                    if(listIterator.hasNext()) {
                        System.out.println(listIterator.next().toString());
                    }   else {
                        System.out.println("Reached The End of Playlist..");
                        isforward = false;
                    }
                    break;  
                case 2:
                    if(isforward) {
                        if(listIterator.hasPrevious()) {
                            listIterator.previous();
                            isforward = false;
                        }
                    }
                    if(listIterator.hasPrevious()) {
                        System.out.println("Now Playing: " + listIterator.previous().toString());
                    } else {
                        System.out.println("Reached The Start of Playlist.");
                        isforward = true;
                    }

                    break;
                case 3:
                    if(isforward) {
                        if(listIterator.hasPrevious()) {
                            System.out.println("Now Replaying " + listIterator.previous().toString());
                            isforward = false;
                        } else {
                            System.out.println("We Are At The Starting of the List..");
                        }
                    } else {
                        if(listIterator.hasNext()) {
                            System.out.println("Now Replaying " + listIterator.next().toString());
                            isforward = true;
                        } else {
                            System.out.println("We Are at the End of the List..");
                        }
                    }
                    break;
                case 4:
                    printPlaylist(playlist);
                    break;
                case 5:
                    printMenu();
                    break;
                default:
                    System.out.println("Enter Choice Again..");


            }
        }
        scanner.close();
    }

    public static void printPlaylist(LinkedList<Song>playlist) {
        if(playlist.size()>=0) {
        for(int i=0;i<playlist.size();i++) {
            System.out.println(playlist.get(i).toString());
        }
    }
    else if (playlist.size()<0) {
        System.out.println("No Songs Added in Playlist");
        }
    }

    public static void printMenu() {
        System.out.println("0. Exit.");
        System.out.println("1. Play Next Track.");
        System.out.println("2. Play Previous Track.");
        System.out.println("3. Replay The Song");
        System.out.println("4. Print PlayList Tracks.");
        System.out.println("5. Print the Menu");
    }
    


}
