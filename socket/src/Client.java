import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.*;

public class Client {
    public static void main(String[] args) {
        try{
            Socket connection = new Socket("127.0.0.1",8080);
            System.out.println("connected to "+ connection.toString());
            try{
                InputStream inStream = connection.getInputStream();
                Scanner in = new Scanner(inStream);
                OutputStream outStream = connection.getOutputStream();
                PrintWriter out = new PrintWriter(outStream, true /* autoFlush */);

                out.println("Hi, i'm client and i'm sending you this");

                for (int i = 0; i <10 ; i++) {
                    System.out.println(in.nextLine());
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                connection.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

