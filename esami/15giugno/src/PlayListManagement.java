import java.util.ArrayList;

class PlayList {
    private ArrayList<Integer> playlist = new ArrayList<>();

    public synchronized boolean add(int song){
        if (playlist.contains(song))
            return false;
        if (playlist.size()>=10)
            return false;

        playlist.add(song);
        return true;
    }

    public synchronized void print() {
        System.out.println(playlist);
    }


}

public class PlayListManagement extends Thread {
    private int thread;
    private PlayList playlist;

    public PlayListManagement(int thread, PlayList playlist){
        this.thread=thread;
        this.playlist=playlist;
    }

    @Override
    public void run() {
        System.out.println(thread + " - " + 12 + ": " + playlist.add(12));
        System.out.println(thread + " - " + 5 + ": " + playlist.add(5));
        System.out.println(thread + " - " + thread + ": " + playlist.add(thread));
    }

    public static void main(String[] args) throws InterruptedException {
        PlayList pl = new PlayList();
        PlayListManagement p0 = new PlayListManagement(0,pl);
        PlayListManagement p1 = new PlayListManagement(1,pl);
        pl.add(23);
        pl.add(21);
        pl.add(10);
        p0.start();
        p1.start();
        sleep(1000);
        pl.print();
    }
}