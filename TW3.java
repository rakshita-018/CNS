import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class TW3 {

    public static final String HOSTNAME = "localhost";
    public static final int PORT = 80;

    public static void main(String[] args) throws UnknownHostException, IOException {
           try(Socket clientSocket = new Socket(HOSTNAME, PORT);
            InputStreamReader isr = new InputStreamReader(clientSocket.getInputStream());
            BufferedReader reader = new BufferedReader(isr);
            PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(),true)){

                System.out.println("Connected to " + HOSTNAME + " on port " + PORT); 
                
                String data = "Hello\nBye";
                System.out.println("Sending to server:\n" + data); 
                writer.println(data);

                String line;
                while((line = reader.readLine()) != null){
                    System.out.println("client recevied: " + line);
                }

           }
    }
}



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPEchoServer {

    public static final int PORT = 80;

    public static void main(String[] args) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Listing on port " + PORT);

            while(true){
                try(Socket socket = serverSocket.accept();
                InputStreamReader isr = new InputStreamReader(socket.getInputStream());
                BufferedReader reader = new BufferedReader(isr);
                PrintWriter writer = new PrintWriter(socket.getOutputStream(), true)){
   
                    System.out.println("Connection accepted"); 
   
                    String line;
                    while((line = reader.readLine()) != null){
                        System.out.println("Server received: " + line + " sending to client");
                        writer.println(line);

                        if(line.equals("Bye")){
                            break;
                        }
                    }
                }
            }
        }

    }
}
