package object;

import javax.imageio.ImageIO;
import java.io.IOException;

//obiect utilizat la finalul nivelului 3, pentru finalizarea jocului si trecerea la story state
public class OBJ_Potion extends SuperObject{
    public OBJ_Potion(){
        name = "Potion";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/potion.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
