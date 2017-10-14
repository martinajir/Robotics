/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robot;

/**
 *
 * @author Martina
 */
import java.io.*;
import java.net.*;

class Server
{
   public static void main(String argv[]) throws Exception
      {
         String clientSentence;
         ServerSocket welcomeSocket = new ServerSocket(6667);
         Socket connectionSocket = welcomeSocket.accept();
         BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
         DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
         
         
         while(true)
         {  
           outToClient.writeBytes("ANANAS");
           outToClient.flush();
           // clientSentence = inFromClient.readLine();
            //int clientInt = inFromClient.read();
            //outToClient.writeInt(clientInt);
            //outToClient.flush();
            
          
         }
      }
}