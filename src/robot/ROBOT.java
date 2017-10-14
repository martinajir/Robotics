/*
 * Main program that controls the robot, version 1
 */
package robot;
import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Martina Jireckova
 */
public class ROBOT {

    public static void main(String[] args) throws IOException {
       
        Socket s = new Socket("localhost", 6667);
        //OutputStreamWriter writer;
        //writer = new OutputStreamWriter(s.getOutputStream());
        DataOutputStream outToServer = new DataOutputStream(s.getOutputStream());
        BufferedReader inputROBOT = new BufferedReader(new InputStreamReader(s.getInputStream()));
        
        while(true){
        Scanner inputU = new Scanner(System.in);
        outToServer.writeInt(inputU.nextInt());
        outToServer.flush(); 
        System.out.println(inputROBOT.read());
        }   
    }
    
}
