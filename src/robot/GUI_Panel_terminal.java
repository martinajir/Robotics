/*
 * terminal panel which should write out what the program does
 * bottom left
 */
package robot;

import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author martinajireckova
 */
public class GUI_Panel_terminal extends JPanel {
    
    
    public JTextArea terminal;
    
    public GUI_Panel_terminal(){
        
        
        terminal = new JTextArea(5,1);
        terminal.setLineWrap(true);
        terminal.append("Disconnected" + "\n");
        
        JScrollPane scroll = new JScrollPane(terminal);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setPreferredSize(new Dimension(250,200));
        this.add(scroll);
           
    }

}
