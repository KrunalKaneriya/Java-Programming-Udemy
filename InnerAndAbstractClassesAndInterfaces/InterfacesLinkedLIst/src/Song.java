public class Song {
    private String title;
    private double duration;

    public Song(String title,double duration) {
        this.title = title;
        this.duration = duration;
    }

    public void setSongtitle(String title) {
        this.title = title;
    }

    public void setSongduration(double duration) {
        this.duration = duration;
    }

    public String getSongtitle() {
        return this.title;
    }

    public double getSongduration() {
        return this.duration;
    }

    public String toString() {
        return  this.title + " : "+ this.duration;

    }


    

   

}