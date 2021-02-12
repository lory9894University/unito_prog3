public class Concurrence extends Thread {
    private static Integer i=0;
    private int thread;
    public Concurrence(int thread) {
        this.thread=thread;
    }
    public void run() {
        synchronized (i) {
            for (int j = 0; j < 3; j++) {
                int val = i.intValue();
                val++;
                i = Integer.valueOf(val);
                System.out.println(thread +": " + i);
            }
        }
    }
    public static void main(String[] args) {
        Integer number = Integer.valueOf(0);
        Concurrence first = new Concurrence(0);
        Concurrence second = new Concurrence(1);
        first.start();
        second.start();
    }
}