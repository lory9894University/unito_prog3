import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newFixedThreadPool(2);
        try {
            ServerSocket server = new ServerSocket(8080);

            while (true) {
                Runnable connection = new Connection(server.accept());
                exec.execute(connection);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

class Connection implements Runnable{
    static int client = 0;
    int clientMe;
    Socket socket = null;
    ObjectInputStream inStream = null;
    ObjectOutputStream outStream = null;

    public Connection(Socket socket) {
        this.socket = socket;
        clientMe=client;
        client++;
    }

    @Override
    public void run() {
        System.out.println("client connected :" + clientMe);
        try {
            InputStream inStream = socket.getInputStream();
            Scanner in = new Scanner(inStream);
            OutputStream outStream = socket.getOutputStream();
            PrintWriter out = new PrintWriter(outStream, true /* autoFlush */);

            System.out.println(in.nextLine());

            for (int i = 0; i <10 ; i++) {
                Thread.sleep(1000);
                out.println(i);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
