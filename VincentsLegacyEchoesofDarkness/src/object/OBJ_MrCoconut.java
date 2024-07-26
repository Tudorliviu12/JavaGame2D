package object;

import javax.imageio.ImageIO;
import java.io.IOException;

//obiect collectable pentru nivelul 2
public class OBJ_MrCoconut extends SuperObject {
    public OBJ_MrCoconut(){
        name = "MrCoconut";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/mrCoconut.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
