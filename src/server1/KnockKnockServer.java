/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package server1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Juhu
 */

public class KnockKnockServer {
    public static void main(String[] args) throws IOException {
        
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(80);
        } catch (IOException e) {
            System.out.println("Could not listen on port: 4444.");
            System.exit(1);
        }
        
        System.out.println("Listening on 4444");
        Socket clientSocket = null;
        try {
            clientSocket = serverSocket.accept();
        } catch (IOException e) {
            System.out.println("Accept failed.");
            System.exit(1);
        }
        
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        clientSocket.getInputStream()));
        String inputLine, outputLine = null;
        
        outputLine = "SISURNA!";

        
        while ((inputLine = in.readLine()) != null) {
            System.out.println(inputLine);
            System.out.println(outputLine);
            out.println(outputLine);
            if (outputLine.equals("Bye."))
                break;
        }
        out.close();
        in.close();
        clientSocket.close();
        serverSocket.close();
    }
}

