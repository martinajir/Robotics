/*
 * set the IP address and the socket to use
 */
package robot;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.Socket;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author martinajireckova
 */
public class GUI_Panel_settings  extends JPanel{
    
    public JLabel ipadd;
    public String address = "localhost";
    public JButton connect;
    public JButton disconnect;
    public JTextField addinput;
    public PrintWriter outToServer;
    public BufferedReader inputROBOT;
    public Socket s;
    
    public GUI_Panel_settings(){
        
        this.setLayout(new GridLayout(14,1));
        ipadd = new JLabel("IP address: ");
        ipadd.setFont(new Font("Calibri",Font.PLAIN,15));
        
        addinput = new JTextField();
        addinput.setFont(new Font("Calibri",Font.PLAIN,15));
        addinput.setPreferredSize(new Dimension(200,20));
        
        connect = new JButton("Connect");
        disconnect = new JButton("Disconnect");
       
        
        this.add(ipadd);
        this.add(addinput);
        this.add(connect);
        this.add(disconnect);
    }
  
    
}
