import java.util.ArrayList;
import java.util.LinkedList;


public class Album {
    private String albumName;
    private songlist songs;
    // ArrayList<Song>songs;


    public Album(String albumName) {
        this.albumName = albumName;
        this.songs = new songlist();
    }

    public boolean addSong(String title,double duration) {

        return this.songs.add(new Song (title,duration));
        // if(findSong(title) == null) {
        //     this.songs.add(new Song (title,duration));
        //     return true;
        // } 
        // return false;
    }

    public boolean addToPlaylist(String title,LinkedList<Song>playlist) {
        Song checkedSong = this.songs.findsong(title);
        if(checkedSong!=null) {
            playlist.add(checkedSong);
            return true;
        }
        System.out.println("The Song is not Found in the ALbums..\nCannot Add Song to the playlist..");
        return false;
    } 




    // private Song findSong(String title) {
    //     for(Song checkedSong:songlist) {
    //         if(checkedSong.getSongtitle().equals(title))
    //         return checkedSong;
    //     }
    //     return null;
    // }

    


    /**
     * @return String return the albumName
     */
    public String getAlbumName() {
        return albumName;
    }

    /**
     * @param albumName the albumName to set
     */
    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    private class songlist {
        private ArrayList<Song>songlist = new ArrayList<Song>();

        
        public boolean add(Song song) {
            if(songlist.contains(song)) {
                System.out.println("Song Already Added..");
                return false;
            }

            this.songlist.add(song);
            System.out.println("Song "+ song.getSongtitle() + " Added..");
            return true;
        }

        public Song findsong(String title) {
            for(Song checkedsong : songlist) {
                if(checkedsong.getSongtitle().equals(title))
                    return checkedsong;
            }
            return null;
        }
    }



}