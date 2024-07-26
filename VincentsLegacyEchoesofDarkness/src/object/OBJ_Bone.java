package object;

import javax.imageio.ImageIO;
import java.io.IOException;

//obiect collectable pentru nivelul 1
public class OBJ_Bone extends SuperObject{
    public OBJ_Bone(){
        name = "Bone";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/bone.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
