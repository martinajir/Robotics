/*
* Implement on controlling device
*/
package robot;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ROBOT2 {

    public static void main(String[] args) throws IOException {
       
        Socket s = new Socket("localhost",6667); // destination, port
        PrintWriter outToServer = new PrintWriter(s.getOutputStream()); // write to Robot --> server
        BufferedReader inputROBOT = new BufferedReader(new InputStreamReader(s.getInputStream())); // input from server
        Scanner inputU = new Scanner(System.in); //user input to server
        
        while(true)
        {           	
        	outToServer.write(inputU.nextLine()+"\n"); //line must end with linebreak "\n"
        	outToServer.flush();
               
        	System.out.println("Simon says:"+inputROBOT.readLine()); 
                
                
        }
        //inputU.close();
        //s.close();
    }
    
}
