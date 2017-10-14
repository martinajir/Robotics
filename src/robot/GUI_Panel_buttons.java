/*
 * constructs a panel with buttons
 */
package robot;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author martinajireckova
 */
public class GUI_Panel_buttons  extends JPanel{
   
    public JButton up;
    private ImageIcon upi = new ImageIcon(getClass().getResource("arrow_up.png"));
    public JButton down;
    private ImageIcon downi = new ImageIcon(getClass().getResource("arrow-alt-down.png"));
    public JButton left;
    private ImageIcon lefti = new ImageIcon(getClass().getResource("arrow_left_2.png"));
    public JButton right;
    private ImageIcon righti = new ImageIcon(getClass().getResource("arrow-alt-right.png"));
    
    
    public GUI_Panel_buttons(){
        
        up = new JButton(upi);
        up.setPreferredSize(new Dimension(80,80));
        up.setMaximumSize(new Dimension(80,80));
       
        right = new JButton(righti);
        right.setPreferredSize(new Dimension(80,80));
        
        left = new JButton(lefti);
        left.setPreferredSize(new Dimension(80,80));
       
        down = new JButton(downi);
        down.setPreferredSize(new Dimension(80,80));
       
        this.setLayout(new BorderLayout());
        
        
        this.add(up,BorderLayout.NORTH);
        this.add(right,BorderLayout.EAST);
        this.add(left,BorderLayout.WEST);
        this.add(down, BorderLayout.CENTER);
        
       // this.setPreferredSize(new Dimension(130,130));
        
        
}
}