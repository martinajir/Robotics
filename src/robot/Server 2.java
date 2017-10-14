/*
 * Implement on robot
 * .
 */


package robot;

import java.io.*;
import java.net.*;

class Server2
{
   public static void main(String argv[]) throws Exception
      {

            ServerSocket welcomeSocket = new ServerSocket(6667); //communication port
            Socket connectionSocket = welcomeSocket.accept();
            BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream())); //read from client
           // PrintWriter outToClient = new PrintWriter(connectionSocket.getOutputStream()); //write to client
       
       // serialport   
       String portname = "com1"; 
       Process p = null;
       
       Runtime rt = Runtime.getRuntime();
       String cmd[] = {
            "c:\\windows\\system32\\cmd.exe", "/c",
            "c:\\windows\\system32\\mode.com", portname,
            };
      
       p = rt.exec( cmd );
  
  if( p.waitFor() != 0 ) {
    System.out.println("Error executing command: " + cmd );
    System.exit( 0 );
    }
   
    FileOutputStream fos = new FileOutputStream( portname );
    SerialCommands console = new SerialCommands(fos);
   
          
            
            // action
            while(true)
            {
                String s = inFromClient.readLine(); 
            	
                switch(s){
                    case "1": console.forward();
                             // outToClient.write("evalw\n");        
                        break;
                    case "0": console.backward();
                              // outToClient.write("evals\n");
                        break;
                    case "2": console.left();
                           // outToClient.write("evala\n");
                        break;
                    case "3": console.right();
                       // outToClient.write("evald\n");
                        break;
                    case "stahp": console.stop();
                        //outToClient.write("evalstp\n");
                        break;
                    case "exit":
                       // outToClient.write("e\n");
                        break;
                        
                    default: //outToClient.write("evalwtf\n");
                }
             
                
               // outToClient.write(s + "\n");
            	//outToClient.flush();  
            }
      }
}