/*
 * welcome screen
 */
package robot;

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author martinajireckova
 */
public class GUI_Panel_intro extends JPanel {
     
    private JLabel intro;
    
    public GUI_Panel_intro(){
        intro = new JLabel("Console");
        intro.setHorizontalAlignment(SwingConstants.CENTER);
        intro.setFont(new Font("Calibri", Font.PLAIN, 20));
        this.add(intro);
    }
}
