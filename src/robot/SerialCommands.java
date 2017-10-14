
package robot;

/**
 *
 * @author martinajireckova
 */
import java.io.FileOutputStream;
import java.io.IOException;

public class SerialCommands{
    private FileOutputStream fos;
    
    public SerialCommands(FileOutputStream fos1){
        fos = fos1;
    }
    
    public void forward() throws IOException{
        fos.write(0);
  
    }
    public void backward() throws IOException{
        fos.write(1);

    }
    
    public void left() throws IOException{
        fos.write(2);
    
    }
    public void right() throws IOException{
        fos.write(3);
      
    }
    
    public void stop() throws IOException{
        fos.write(4);
       
    }
}
