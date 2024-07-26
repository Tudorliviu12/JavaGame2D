package object;

import javax.imageio.ImageIO;
import java.io.IOException;

//obiect collectable pentru nivelul 3
public class OBJ_Scarab extends SuperObject{
    public OBJ_Scarab(){
        name = "Scarab";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/scarab.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
