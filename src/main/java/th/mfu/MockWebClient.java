package th.mfu;

import java.io.*;
import java.net.*;

// call mockup server at port 8080
public class MockWebClient {
    public static void main(String[] args) {

        // TODO: Create a socket to connect to the web server on port 8080
        int port = 8080;
        String serverAddress = "localhost";

        try (Socket socket = new Socket(serverAddress, port);
                //:TODO Create input and output streams for the socket
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))){
            // Read the response from the web server and print out to console
            String userInput;
            while ((userInput = in.readLine()) != null) {
                System.out.println("Received from client: " + userInput);
                out.println("Client says: " + userInput);
            }
        // Close the socket
        } catch (IOException e) {
            System.err.println("Error occurred: " + e.getMessage());
        }
        // TODO: send an HTTP GET request to the web server
        String request = "GET / HTTP/1.1\r\nHost: localhost\r\n\r\n";
        System.out.println(request);

    }

}
