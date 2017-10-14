/**
 * main file, constructs panels
 */
package robot;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import static javax.swing.BoxLayout.PAGE_AXIS;
import javax.swing.ButtonModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author martinajireckova
 */
public class GUI_FRAME extends JFrame{
   
    
    public static GUI_Panel_settings settings = new GUI_Panel_settings();
    public static GUI_Panel_terminal terminal = new GUI_Panel_terminal();
    public static GUI_Panel_buttons buttonPanel = new GUI_Panel_buttons();
    
    public GUI_FRAME() throws IOException{
    
        setTitle("Console");
        setSize(710,500);
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container pane = this.getContentPane();
        this.setLayout(new BoxLayout(pane, PAGE_AXIS)); //whole frame, 
        
        JPanel panelup = new GUI_Panel_intro(); 
        pane.add(panelup);
        
        
        JPanel contain = new JPanel(); //bottom panel, left panel + right panel
        FlowLayout f = new FlowLayout(FlowLayout.LEFT);
        f.setHgap(50);
        contain.setLayout(f);
       
        JPanel leftPanel = new JPanel(); //left panel
        leftPanel.setLayout(new BoxLayout(leftPanel,PAGE_AXIS));
        
        //buttonPanel = new GUI_Panel_buttons();//new button panel
        
        //terminal = new GUI_Panel_terminal();//new terminal panel
        
        leftPanel.add(buttonPanel);
        leftPanel.add(terminal);//add buttons on top and terminal down
        
        contain.add(leftPanel);//left panel == terminalPanel + buttons
        
        settings = new GUI_Panel_settings();//right panel declaration = settings panel
        
        contain.add(settings);//contain.add(settingsPanel);
        
        pane.add(contain);
        
        
        
    }
   public static void main (String [] args) throws IOException{
       
       JFrame frame = new GUI_FRAME();
       frame.setVisible(true);
       
       //connect
       settings.connect.addActionListener(
                new ActionListener(){
                    
                    public void actionPerformed(ActionEvent event){
                            settings.address = settings.addinput.getText();
                        try {
                        // destination, port
                           settings.s = new Socket(settings.address,6667);
                           settings.outToServer = new PrintWriter(settings.s.getOutputStream()); // write to Robot --> server
                           settings.inputROBOT = new BufferedReader(new InputStreamReader(settings.s.getInputStream())); // input from server
                           terminal.terminal.append("Connected to: " + settings.address + "\n");
                            
                        } catch (IOException ex) {
                            Logger.getLogger(GUI_Panel_settings.class.getName()).
                                    log(Level.SEVERE, null, ex);
                        }
                      
                    }
               }
        );  
       //disconnect
        settings.disconnect.addActionListener(
                new ActionListener(){
                        
                    public void actionPerformed(ActionEvent event){
                        settings.outToServer.close();
                        try {
                            settings.inputROBOT.close();
                        } catch (IOException ex) {
                            Logger.getLogger(GUI_Panel_settings.class.getName()).
                                    log(Level.SEVERE, null, ex);
                        }
                    }
                });
       
       
        //BUTTON TIMER forward
      int timerDelay = 100;
      final Timer timer = new Timer(timerDelay , new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent event){
                       settings.outToServer.write("1" + "\n");
                       settings.outToServer.flush();
                       terminal.terminal.append("sent 1 forward" + "\n");
                    }
      });

      
      final ButtonModel bModel = buttonPanel.up.getModel();
      bModel.addChangeListener(new ChangeListener() {

         @Override
         public void stateChanged(ChangeEvent cEvt) {
            if (bModel.isPressed() && !timer.isRunning()) {
               timer.start();
            } else if (!bModel.isPressed() && timer.isRunning()) {
               timer.stop();
            }
         }
           
      });
       //BUTTON TIMER backward
      int timerDelay2 = 100;
      final Timer timer2 = new Timer(timerDelay2 , new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent event){
                       settings.outToServer.write("0" + "\n");
                       settings.outToServer.flush();
                       terminal.terminal.append("sent 0 backward" + "\n");
                    }
      });

      
      final ButtonModel bModel2 = buttonPanel.down.getModel();
      bModel2.addChangeListener(new ChangeListener() {

         @Override
         public void stateChanged(ChangeEvent cEvt) {
            if (bModel2.isPressed() && !timer2.isRunning()) {
               timer2.start();
            } else if (!bModel2.isPressed() && timer2.isRunning()) {
               timer2.stop();
            }
         }
           
      });
      //BUTTON TIMER left
      final Timer timer3 = new Timer(timerDelay , new ActionListener() {

         @Override
        public void actionPerformed(ActionEvent event){
                       settings.outToServer.write("2" + "\n");
                       settings.outToServer.flush();
                       terminal.terminal.append("sent 2 left" + "\n");
                    }
      });

      
      final ButtonModel bModel3 = buttonPanel.left.getModel();
      bModel3.addChangeListener(new ChangeListener() {

         @Override
         public void stateChanged(ChangeEvent cEvt) {
            if (bModel3.isPressed() && !timer3.isRunning()) {
               timer3.start();
            } else if (!bModel3.isPressed() && timer3.isRunning()) {
               timer3.stop();
            }
         }
           
      });
      
      //BUTTON TIMER right
      final Timer timer4 = new Timer(timerDelay , new ActionListener() {

         @Override
        public void actionPerformed(ActionEvent event){
                       settings.outToServer.write("3" + "\n");
                       settings.outToServer.flush();
                       terminal.terminal.append("sent 3 right" + "\n");
                    }
      });

      
      final ButtonModel bModel4 = buttonPanel.right.getModel();
      bModel4.addChangeListener(new ChangeListener() {

         @Override
         public void stateChanged(ChangeEvent cEvt) {
            if (bModel4.isPressed() && !timer4.isRunning()) {
               timer4.start();
            } else if (!bModel4.isPressed() && timer4.isRunning()) {
               timer4.stop();
            }
         }
           
      });
      
    
}
}
